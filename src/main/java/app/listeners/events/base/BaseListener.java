package app.listeners.events.base;

import app.services.application.ApplicationService;
import com.intellij.openapi.components.ServiceManager;

public class BaseListener {

    private ApplicationService manager;
    private String label;

    public BaseListener() {
        this("");
    }

    public BaseListener(String label) {
        manager = ServiceManager.getService(ApplicationService.class);
        this.label = label;
    }

    public void log(String msg) {
        Event logEvent = new Event(label, msg);
        manager.inspectEvent(logEvent);
    }

    protected ApplicationService getApplicationService() {
        return manager;
    }

}
