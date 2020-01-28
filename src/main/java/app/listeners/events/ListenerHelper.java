package app.listeners.events;

import app.App;
import app.listeners.events.actions.ActionPool;
import app.listeners.events.topics.*;
import app.listeners.events.ui.PopupMenuListener;
import com.intellij.codeInsight.completion.CompletionPhaseListener;
import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer;
import com.intellij.execution.ExecutionManager;
import com.intellij.execution.ui.RunContentManager;
import com.intellij.find.FindManager;
import com.intellij.openapi.actionSystem.impl.ActionMenu;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.wm.impl.IdeRootPane;
import com.intellij.task.ProjectTaskListener;
import com.intellij.util.messages.MessageBus;
import com.intellij.xdebugger.breakpoints.XBreakpointListener;

import javax.swing.*;
import java.awt.*;

public class ListenerHelper {

    private static boolean menuListenerInitialized = false;

    public static void initListener() {
        Project currentProject = App.getCurrentProject();
        FileEditor currentEditor = FileEditorManager.getInstance(currentProject).getSelectedEditor();
        initMenuListener(currentEditor);
        initProxyActions();
        initMessageBusListener(currentProject.getMessageBus(), currentProject);
    }

    public static void initMenuListener(FileEditor currentEditor) {
        JComponent entryPoint = currentEditor.getComponent();
        if(entryPoint == null) {
            return;
        }
        if(menuListenerInitialized) {
            return;
        }
        PopupMenuListener popupListener = new PopupMenuListener();
        JMenuBar menuBar = findMenuBar(entryPoint.getParent());
        for (MenuElement element : menuBar.getSubElements()) {
            JPopupMenu popupMenu = ((ActionMenu) element).getPopupMenu();
            popupMenu.addPopupMenuListener(popupListener);
        }
        menuListenerInitialized = true;
    }

    private static  void initMessageBusListener(MessageBus bus, Project currentProject) {
        bus.connect().subscribe(RefactoringListener.REFACTORING_EVENT_TOPIC, new RefactoringListener());
        bus.connect().subscribe(CompletionPhaseListener.TOPIC, new CodeCompletionListener());
        bus.connect().subscribe(IDEHintListener.TOPIC, new IDEHintListener());
        bus.connect().subscribe(XBreakpointListener.TOPIC, new BreakpointListener());
        bus.connect().subscribe(ProjectManager.TOPIC, new ProjectListener());
        bus.connect().subscribe(FindManager.FIND_MODEL_TOPIC, new FindListener());
        bus.connect().subscribe(IDECommandListener.TOPIC, new IDECommandListener());
        bus.connect().subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileListener());
        bus.connect().subscribe(ProjectTaskListener.TOPIC, new TaskListener());
        bus.connect().subscribe(DaemonCodeAnalyzer.DAEMON_EVENT_TOPIC, new CodeAnalyzerListener(currentProject));
        bus.connect().subscribe(ExecutionManager.EXECUTION_TOPIC, new RunListener());
    }

    private static void initProxyActions() {
        ActionPool.getInstance().registerProxyAction("CallHierarchy", "Insights", "Call Hierarchy");
        ActionPool.getInstance().registerProxyAction("MethodHierarchy", "Insights", "Method Hierarchy");
        ActionPool.getInstance().registerProxyAction("TypeHierarchy", "Insights", "Type Hierarchy");
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
