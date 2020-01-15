package app.ui;

import app.App;
import app.services.application.ApplicationService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import org.jetbrains.annotations.NotNull;

public class SessionAction extends AnAction {

    private static final String START_SESSION_TEXT = "Start Session";
    private static final String SAVE_SESSION_TEXT = "Save Session";
    private static final String SESSION_RUNNING_TEXT = "BI Plugin is running";
    private static final String SESSION_STOPPED_TEXT = "Thanks for participating";

    private ApplicationService applicationService;

    public SessionAction() {
        applicationService = ServiceManager.getService(ApplicationService.class);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        switch (applicationService.getState()) {
            case IDLE:
                applicationService.startSession();
                setStatusBarState(true);
                e.getPresentation().setText(SAVE_SESSION_TEXT);
                break;
            case RECORDING:
                applicationService.saveSession();
                setStatusBarState(false);
                e.getPresentation().setText(START_SESSION_TEXT);
                break;
        }

    }

    //show hint in statusbar when the plugin is running
    private void setStatusBarState(Boolean isRunning) {
        StatusBar statusBar = WindowManager.getInstance().getStatusBar(App.getCurrentProject());

        if (statusBar != null) {
            if (isRunning) {
                statusBar.setInfo(SESSION_RUNNING_TEXT);
            } else {
                statusBar.setInfo(SESSION_STOPPED_TEXT);
            }
        }
    }

}