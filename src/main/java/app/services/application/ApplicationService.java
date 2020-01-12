package app.services.application;

import app.App;
import app.listeners.events.ListenerHelper;
import app.services.log.LogService;
import com.intellij.openapi.components.ServiceManager;

import java.awt.event.ActionEvent;

public class ApplicationService {

    private boolean logIsReady = false;
    private boolean listenersAreReady = false;
    private ApplicationState state = ApplicationState.IDLE;
    private LogService logService;

    public static ApplicationService getInstance() {
        return ServiceManager.getService(ApplicationService.class);
    }

    public ApplicationState getState() {
        return state;
    }

    public void startSession() {
        if (state == ApplicationState.RECORDING) {
            return;
        }
        if(!logIsReady) {
           logService = ServiceManager.getService(LogService.class);
           logService.init();
        }
        if (!listenersAreReady) {
            ListenerHelper.initListener();
            listenersAreReady = true;
        }
        logService.createSessionLog();
        logService.logAction("Plugin", "Session started");
        state = ApplicationState.RECORDING;
    }

    public void saveSession() {
        if (state == ApplicationState.IDLE) {
            return;
        }
        logService.logAction("Plugin", "Session saved");
        logService.syncCurrentLog();
        state = ApplicationState.IDLE;
    }

    public void inspectTopicAction(String topic, String action) {
        inspectAction(topic, action);
    }

    public void inspectMenuAction(ActionEvent event) {
        logService.logAction("Menu", event.getActionCommand());
    }

    public void inspectAction(String label, String action) {
        if(state == ApplicationState.IDLE) {
            return;
        }
        logService.logAction(label, action);
    }

}