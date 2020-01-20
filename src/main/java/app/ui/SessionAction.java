package app.ui;

import app.services.application.ApplicationService;
import app.services.application.ApplicationState;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;

public class SessionAction extends AnAction {

    private static final String START_SESSION_TEXT = "Start Session";
    private static final String SAVE_SESSION_TEXT = "Save Session";

    private ApplicationService applicationService;

    public SessionAction() {
        applicationService = ServiceManager.getService(ApplicationService.class);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        ApplicationState currentState = applicationService.getState();
        switch (applicationService.getState()) {
            case IDLE:
                applicationService.startSession();
                e.getPresentation().setText(SAVE_SESSION_TEXT);
                break;
            case RECORDING:
                applicationService.saveSession();
                e.getPresentation().setText(START_SESSION_TEXT);
                break;
        }
    }

}
