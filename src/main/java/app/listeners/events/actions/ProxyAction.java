package app.listeners.events.actions;

import app.listeners.events.base.BaseListener;
import app.services.application.ApplicationService;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;

public class ProxyAction extends AnAction  {

    private AnAction oldAction;
    private ActionManager actionManager;
    private ApplicationService applicationManager;
    private String category;
    private String description;

    public ProxyAction(String actionId, String category, String description)  {
        applicationManager = ServiceManager.getService(ApplicationService.class);
        this.category = category;
        this.description = description;
        initAction(actionId);
    }

    private void initAction(String actionId) {
        actionManager = ActionManager.getInstance();
        oldAction = actionManager.getAction(actionId);
        actionManager.unregisterAction(actionId);
        actionManager.registerAction(actionId, this);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        applicationManager.inspectIdeAction(category, description);
        oldAction.actionPerformed(e);
    }

}
