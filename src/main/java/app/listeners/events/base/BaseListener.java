package app.listeners.events.base;

import app.services.ManagerService;
import com.intellij.openapi.components.ServiceManager;

public class BaseListener {

    private ManagerService manager;

    public BaseListener() {
        manager = ServiceManager.getService(ManagerService.class);
    }

    protected ManagerService getManager() {
        return manager;
    }
}
