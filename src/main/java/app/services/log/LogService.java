package app.services.log;

import app.ui.DataPrivacyDialog;
import app.ui.SecurityResponse;
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

    //Sync log only if user accepts privacy policy
    public void syncCurrentLog() {
        if (currentLog != null) {
            SecurityResponse dataSecurity =  DataPrivacyDialog.showConfirmationDialog(localUser.getID(), CONFIRMATION_DATA_SECURITY_TITLE);
            if (dataSecurity == SecurityResponse.ACCEPT) {
                LogManager.syncLog(currentLog, localUser, UPLOAD_SERVER_URL, this);
            } else if (dataSecurity == SecurityResponse.REJECT){
                DataPrivacyDialog.showStatusDialog(Values.DATA_PRIVACY_DECLINED_TITLE, Values.DATA_PRIVACY_DECLINED_MESSAGE);
            }
        }
    }

    public void logAction(String label, String menuAction) {
        currentLog.log(localUser.getSessionID(), LogDataType.IDE, label, menuAction);
    }

    //TODO: change google doc so that privacy policy is removed
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
