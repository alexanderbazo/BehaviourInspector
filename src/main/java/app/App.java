package app;

import app.services.LogService;
import app.services.ManagerService;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

public class App implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {
        // TODO: Make sure, that this code is only run once
        LogService.getInstance().init();
        ManagerService.getInstance().initMenuListener(FileEditorManager.getInstance(project).getSelectedEditor().getComponent());
        ManagerService.getInstance().subscribeToMessageBus(project.getMessageBus());
    }
}
