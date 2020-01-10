package app.listeners.events.base;

import app.services.InspectorService;
import app.services.ManagerService;
import com.intellij.openapi.components.ServiceManager;

public class BaseListener {

    private ManagerService manager;
    private InspectorService inspector;

    public BaseListener() {
        manager = ServiceManager.getService(ManagerService.class);
        inspector = ServiceManager.getService(InspectorService.class);
    }

    protected ManagerService getManager() {
        return manager;
    }

    protected InspectorService getInspector() {
        return inspector;
    }
}
