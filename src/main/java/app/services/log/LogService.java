package app.services.log;

import app.ui.dataprivacy.DataPrivacyDialog;
import app.ui.dataprivacy.SecurityResponse;
import com.intellij.openapi.components.ServiceManager;
import data.StringValues;
import de.ur.mi.pluginhelper.User.User;
import de.ur.mi.pluginhelper.logger.Log;
import de.ur.mi.pluginhelper.logger.LogDataType;
import de.ur.mi.pluginhelper.logger.LogManager;
import de.ur.mi.pluginhelper.logger.SyncProgressListener;

import java.awt.*;
import java.net.URI;

public class LogService implements SyncProgressListener, StringValues {

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
        currentLog = LogManager.openLog(localUser.getSessionID(), LOG_TITLE);
    }

    //Sync log only if user accepts privacy policy
    public void syncCurrentLog() {
        if (currentLog != null) {
            SecurityResponse dataSecurity =  DataPrivacyDialog.showConfirmationDialog(localUser.getID(), CONFIRMATION_DATA_SECURITY_TITLE);
            if (dataSecurity == SecurityResponse.ACCEPT) {
                LogManager.syncLog(currentLog, localUser, UPLOAD_SERVER_URL, this);
            } else if (dataSecurity == SecurityResponse.REJECT){
                DataPrivacyDialog.showStatusDialog(StringValues.DATA_PRIVACY_DECLINED_TITLE, StringValues.DATA_PRIVACY_DECLINED_MESSAGE);
            }
        }
    }

    public void logAction(String label, String action) {
        currentLog.log(localUser.getSessionID(), LogDataType.IDE, label, action);
    }

    @Override
    public void onFinished() {
        DataPrivacyDialog.showStatusDialog(StringValues.DATA_UPLOAD_COMPLETED_TITLE, StringValues.DATA_UPLOAD_COMPLETED_MESSAGE);
    }

    @Override
    public void onFailed() {
    }
}
