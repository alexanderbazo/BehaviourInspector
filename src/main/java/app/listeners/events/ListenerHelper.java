package app.listeners.events;

import app.App;
import app.listeners.events.topics.*;
import app.listeners.events.ui.PopupMenuListener;
import com.intellij.codeInsight.completion.CompletionPhaseListener;
import com.intellij.openapi.actionSystem.impl.ActionMenu;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.impl.IdeFrameImpl;
import com.intellij.util.messages.MessageBus;
import com.intellij.xdebugger.breakpoints.XBreakpointListener;

import javax.swing.*;
import java.awt.*;

public class ListenerHelper {

    public static void initListener() {
        Project currentProject = App.getCurrentProject();
        initMenuListener(FileEditorManager.getInstance(currentProject).getSelectedEditor().getComponent());
        subscribeToMessageBus(currentProject.getMessageBus());
    }

    private static void initMenuListener(JComponent entryPoint) {
        PopupMenuListener popupListener = new PopupMenuListener();
        JMenuBar menuBar = findMenuBar(entryPoint.getParent());
        for (MenuElement element : menuBar.getSubElements()) {
            JPopupMenu popupMenu = ((ActionMenu) element).getPopupMenu();
            popupMenu.addPopupMenuListener(popupListener);
        }
    }

    private static  void subscribeToMessageBus(MessageBus bus) {
        bus.connect().subscribe(RefactoringListener.REFACTORING_EVENT_TOPIC, new RefactoringListener());
        bus.connect().subscribe(CompletionPhaseListener.TOPIC, new CodeCompletionListener());
        bus.connect().subscribe(EditorHintListener.TOPIC, new EditorHintListener());
        bus.connect().subscribe(XBreakpointListener.TOPIC, new BreakpointListener());
    }


    private static  JMenuBar findMenuBar(Container parent) {
        if (parent.getParent() != null) {
            return findMenuBar(parent.getParent());
        } else {
            IdeFrameImpl frame = (IdeFrameImpl) parent;
            return frame.getJMenuBar();
        }
    }

}
