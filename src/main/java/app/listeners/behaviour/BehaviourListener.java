package app.listeners.behaviour;

import app.services.InspectorService;
import com.intellij.openapi.components.ServiceManager;

public abstract class BehaviourListener {

    private InspectorService inspector;

    public BehaviourListener() {
        inspector = ServiceManager.getService(InspectorService.class);
    }

    protected InspectorService getInspector() {
        return inspector;
    }

}
