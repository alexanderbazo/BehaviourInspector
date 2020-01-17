package app.ui;

import app.App;
import app.services.application.ApplicationService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.awt.RelativePoint;
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
                setStatusBarState();
                e.getPresentation().setText(SAVE_SESSION_TEXT);
                break;
            case RECORDING:
                applicationService.saveSession();
                e.getPresentation().setText(START_SESSION_TEXT);
                break;
        }
    }

    //show balloon, when plugin is started
    //TODO: Add hint in statusbar, that plugin is running
    private void setStatusBarState() {
        StatusBar statusBar = WindowManager.getInstance().getStatusBar(App.getCurrentProject());
        if (statusBar != null) {
            createBalloon(statusBar);
            showPermanentHint(statusBar);
        }
    }

    private void showPermanentHint(StatusBar statusBar) {

    }

    private void createBalloon(StatusBar bar) {
        JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder(SESSION_RUNNING_TEXT, MessageType.INFO, null)
                .setFadeoutTime(7500)
                .createBalloon()
                .show(RelativePoint.getCenterOf(bar.getComponent()),
                        Balloon.Position.atRight);
    }

}