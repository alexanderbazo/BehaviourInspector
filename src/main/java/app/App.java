package app;

import app.listeners.events.MenuListener;
import app.services.ManagerService;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import com.intellij.openapi.wm.impl.IdeFrameImpl;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import java.awt.*;

public class App implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {
        System.out.println("Starting ...");
        findRootComponent(FileEditorManager.getInstance(project).getSelectedEditor().getComponent().getParent());
        ManagerService.getInstance().init(project.getMessageBus());
    }

    public void findRootComponent(Container parent) {
        System.out.println(parent);
        if(parent.getParent() != null) {
            findRootComponent(parent.getParent());
        } else {
            IdeFrameImpl frame = (IdeFrameImpl) parent;
            MenuListener menuListener = new MenuListener();
            for(int i = 0; i < frame.getJMenuBar().getMenuCount(); i++) {
                frame.getJMenuBar().getMenu(i).addMenuListener(menuListener);
            }
        }
    }

}
