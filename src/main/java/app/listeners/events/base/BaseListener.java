package app.listeners.events.base;

import app.services.application.ApplicationService;
import com.intellij.openapi.components.ServiceManager;

public class BaseListener {

    private ApplicationService manager;

    public BaseListener() {
        manager = ServiceManager.getService(ApplicationService.class);
    }

    protected ApplicationService getApplicationService() {
        return manager;
    }

}
