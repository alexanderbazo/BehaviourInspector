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
import data.Values;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class SessionAction extends AnAction {

    private static final String START_SESSION_TEXT = "Start Session";
    private static final String SAVE_SESSION_TEXT = "Save Session";
    private static final String SESSION_RUNNING_TEXT = "BI Plugin is running";
    private static final Color CUSTOM_GREEN = new Color(215, 245, 184);
    private static final int PLUGIN_BAR_HEIGHT = 50;

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

    //make visible that plugin is running
    private void setStatusBarState(boolean isRunning) {
        StatusBar statusBar = WindowManager.getInstance().getStatusBar(App.getCurrentProject());
        JFrame jFrame = WindowManager.getInstance().getFrame(App.getCurrentProject());
        JPanel hint = createPermanentHint(jFrame);

        jFrame.add(hint, BorderLayout.SOUTH);

        if (statusBar != null) {
            if (isRunning) {
                createBalloon(statusBar);
                hint.setVisible(true);
                statusBar.setInfo(Values.PLUGIN_RUNNING_STATUS);
            } else {
                hint.setVisible(false);
                statusBar.setInfo(Values.PLUGIN_STOPPED_STATUS);
            }
        }
    }

    //shows permanent line that plugin is running at bottom of IDE
    private JPanel createPermanentHint(JFrame jFrame) {
        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(CUSTOM_GREEN);
        statusPanel.setPreferredSize(new Dimension(jFrame.getWidth(), PLUGIN_BAR_HEIGHT));
        JLabel statusLabel = new JLabel(Values.PLUGIN_RUNNING_BAR);
        statusPanel.add(statusLabel);

        return statusPanel;
    }

    //creates single time popup that plugin was started
    private void createBalloon(StatusBar bar) {
        JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder(SESSION_RUNNING_TEXT, MessageType.INFO, null)
                .setFadeoutTime(7500)
                .createBalloon()
                .show(RelativePoint.getNorthEastOf(bar.getComponent()),
                        Balloon.Position.atRight);
    }

}