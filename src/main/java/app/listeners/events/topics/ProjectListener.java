package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;

public class ProjectListener extends BaseListener implements ProjectManagerListener {
    @Override
    public void projectOpened(@NotNull Project project) {
        getApplicationService().inspectTopicAction("Project", "Project opened [" + project.getName() + "]");
    }

    @Override
    public void projectClosed(@NotNull Project project) {
        getApplicationService().inspectTopicAction("Project", "Project closed [" + project.getName() + "]");
    }

    @Override
    public void projectClosing(@NotNull Project project) {

    }

    @Override
    public void projectClosingBeforeSave(@NotNull Project project) {
        getApplicationService().saveSession();
    }
}
