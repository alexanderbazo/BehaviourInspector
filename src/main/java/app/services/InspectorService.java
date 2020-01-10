package app.services;

import com.intellij.openapi.components.ServiceManager;

public class InspectorService {

    public static InspectorService getInstance() {
        return ServiceManager.getService(InspectorService.class);
    }

    public void log() {
        System.out.println("Received event from Listener");
    }
}
