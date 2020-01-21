package app.listeners.events;

import app.App;
import app.listeners.events.actions.ActionPool;
import app.listeners.events.actions.ProxyAction;
import app.listeners.events.topics.*;
import app.listeners.events.ui.PopupMenuListener;
import com.intellij.codeInsight.completion.CompletionPhaseListener;
import com.intellij.execution.RunManagerListener;
import com.intellij.find.FindManager;
import com.intellij.ide.todo.TodoConfiguration;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.impl.ActionMenu;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.ui.JBPopupMenu;
import com.intellij.openapi.wm.impl.IdeFrameImpl;
import com.intellij.openapi.wm.impl.IdeRootPane;
import com.intellij.task.ProjectTaskListener;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.Topic;
import com.intellij.xdebugger.XDebuggerManager;
import com.intellij.xdebugger.XDebuggerManagerListener;
import com.intellij.xdebugger.breakpoints.XBreakpointListener;
import net.miginfocom.layout.AC;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        bus.connect().subscribe(ProjectManager.TOPIC, new ProjectListener());
        bus.connect().subscribe(FindManager.FIND_MODEL_TOPIC, new FindListener());
        bus.connect().subscribe(CommandListener.TOPIC, new CommandListener());
    }

    private static  JMenuBar findMenuBar(Container parent) {
        if(parent instanceof IdeRootPane) {
            IdeRootPane rootPane = (IdeRootPane) parent;
            return rootPane.getJMenuBar();
        } else {
            return findMenuBar(parent.getParent());
        }
    }

}
