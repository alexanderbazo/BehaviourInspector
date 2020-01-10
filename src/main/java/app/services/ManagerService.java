package app.services;


import app.listeners.behaviour.BehaviourListener;
import app.listeners.events.*;
import com.intellij.AppTopics;
import com.intellij.codeInsight.completion.CompletionPhaseListener;
import com.intellij.ide.navigationToolbar.NavBarModelListener;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.util.messages.MessageBus;
import com.intellij.xdebugger.breakpoints.XBreakpointListener;
import java.util.ArrayList;

public class ManagerService {

    private ArrayList<BehaviourListener> listeners = new ArrayList<BehaviourListener>();

    public static ManagerService getInstance() {
        return ServiceManager.getService(ManagerService.class);
    }

    public void init(MessageBus bus) {
        bus.connect().subscribe(RefactoringListener.REFACTORING_EVENT_TOPIC, new RefactoringListener());
        bus.connect().subscribe(CompletionPhaseListener.TOPIC, new CodeCompletionListener());
        bus.connect().subscribe(EditorHintListener.TOPIC, new EditorHintListener());
        bus.connect().subscribe(XBreakpointListener.TOPIC, new BreakpointListener());
        bus.connect().subscribe(ToolWindowListener.TOPIC, new ToolWindowListener());
        bus.connect().subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, new FileEditorListener());
        bus.connect().subscribe(AppTopics.FILE_DOCUMENT_SYNC, new DocumentListener());
        // bus.connect().subscribe(RunManagerListener.TOPIC, new RunListener());
        bus.connect().subscribe(CommandListener.TOPIC, new CommandListener());
        bus.connect().subscribe(ProjectTaskListener.TOPIC, new ProjectTaskListener());
        bus.connect().subscribe(ProjectTaskListener.TOPIC, new ProjectTaskListener());
        bus.connect().subscribe(ProjectManager.TOPIC, new ProjectManagerListener());
        bus.connect().subscribe(NavBarModelListener.NAV_BAR, new NavigationBarListener());
    }

}
