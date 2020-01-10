package app.listeners.events;

import app.listeners.events.base.BaseListener;
import com.intellij.task.ProjectTaskContext;
import com.intellij.task.ProjectTaskManager;
import org.jetbrains.annotations.NotNull;

public class ProjectTaskListener extends BaseListener implements com.intellij.task.ProjectTaskListener {
    @Override
    public void started(@NotNull ProjectTaskContext context) {
        System.out.println("in: started (ProjectTaskListener)");
    }

    @Override
    public void finished(@NotNull ProjectTaskManager.Result result) {

    }
}
