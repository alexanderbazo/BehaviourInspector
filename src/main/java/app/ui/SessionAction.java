package app.ui;

import app.App;
import app.services.application.ApplicationService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import data.StringValues;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class SessionAction extends AnAction implements StringValues {

    private static final Color YELLOW = new Color(237,162,0);
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
                hint.setVisible(true);
                statusBar.setInfo(StringValues.PLUGIN_RUNNING_STATUS);
            } else {
                hint.setVisible(false);
                statusBar.setInfo(StringValues.PLUGIN_STOPPED_STATUS);
            }
        }
    }

    //shows permanent line that plugin is running at bottom of IDE
    private JPanel createPermanentHint(JFrame jFrame) {
        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(YELLOW);
        statusPanel.setPreferredSize(new Dimension(jFrame.getWidth(), PLUGIN_BAR_HEIGHT));
        JLabel statusLabel = new JLabel(StringValues.PLUGIN_RUNNING_BAR);
        statusLabel.setForeground(Color.WHITE);
        statusPanel.add(statusLabel);

        return statusPanel;
    }

}