package app.services.log;

import com.intellij.openapi.components.ServiceManager;
import data.Values;
import de.ur.mi.pluginhelper.User.User;
import de.ur.mi.pluginhelper.logger.Log;
import de.ur.mi.pluginhelper.logger.LogDataType;
import de.ur.mi.pluginhelper.logger.LogManager;
import de.ur.mi.pluginhelper.logger.SyncProgressListener;
import de.ur.mi.pluginhelper.ui.UserDialogManager;
import de.ur.mi.pluginhelper.ui.UserResponse;

import java.awt.*;
import java.net.URI;

public class LogService implements SyncProgressListener, Values {

    private User localUser;
    private Log currentLog;

    public static LogService getInstance() {
        return ServiceManager.getService(LogService.class);
    }

    public void init() {
        localUser = User.getLocalUser();
    }

    public void createSessionLog() {
        localUser.updateSessionID();
        currentLog = LogManager.openLog(localUser.getID(), LOG_TITLE);
    }

    public void syncCurrentLog() {
        if (currentLog != null) {
            UserResponse response = UserDialogManager.showConfirmationDialog(UPLOAD_CONFIRMATION_DIALOG_MSG, UPLOAD_CONFIRMATION_DIALOG_TITLE);
            if (response == UserResponse.ACCEPT) {
                LogManager.syncLog(currentLog, localUser, UPLOAD_SERVER_URL, this);
            }
        }
    }

    public void logAction(String label, String menuAction) {
        currentLog.log(localUser.getSessionID(), LogDataType.IDE, label, menuAction);
    }

    @Override
    public void onFinished() {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(CONFIRMATION_FORM_URL.replace("$ID", localUser.getID())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailed() {
    }
}
