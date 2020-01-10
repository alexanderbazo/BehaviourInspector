package app.services;

import com.intellij.openapi.components.ServiceManager;
import de.ur.mi.pluginhelper.User.User;
import de.ur.mi.pluginhelper.logger.Log;
import de.ur.mi.pluginhelper.logger.LogDataType;
import de.ur.mi.pluginhelper.logger.LogManager;

public class LogService {

    private User localUser;
    private Log currentLog;

    public static LogService getInstance() {
        return ServiceManager.getService(LogService.class);
    }

    public void init() {
        localUser = User.getLocalUser();
        currentLog = LogManager.openLog(localUser.getSessionID(), "BehaviourInspector");
    }

    public void logMenuAction(String title) {
        currentLog.log(localUser.getSessionID(), LogDataType.CUSTOM, "MenuAction", title);
    }
}
