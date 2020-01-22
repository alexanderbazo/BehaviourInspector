package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.task.*;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class TaskListener extends BaseListener implements ProjectTaskListener {
    @Override
    public void started(@NotNull ProjectTaskContext context) {
    }

    @Override
    public void finished(@NotNull ProjectTaskContext context, @NotNull ProjectTaskResult executionResult) {
        Map<ProjectTask, ProjectTaskState> x = executionResult.getTasksState();
        for(ProjectTask task: x.keySet()) {
            getApplicationService().inspectTopicAction("Task", task.getPresentableName());
        }
    }
}
