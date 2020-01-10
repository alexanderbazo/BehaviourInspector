package app.services;

import com.intellij.openapi.components.ServiceManager;

import java.awt.event.ActionEvent;

public class InspectorService {

    private LogService logService;

    public static InspectorService getInstance() {
        return ServiceManager.getService(InspectorService.class);
    }

    public void inspectMenuAction(ActionEvent event) {
        if(logService == null) {
            logService = ServiceManager.getService(LogService.class);
        }
        logService.logMenuAction(event.getActionCommand());
    }
}
