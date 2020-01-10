package app.listeners.events;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class ProjectManagerListener extends BaseListener implements com.intellij.openapi.project.ProjectManagerListener {
    @Override
    public void projectOpened(@NotNull Project project) {
        System.out.println("in: projectOpened");
    }

    @Override
    public void projectClosed(@NotNull Project project) {
        System.out.println("in: projectClosed");

    }

    @Override
    public void projectClosing(@NotNull Project project) {

    }

    @Override
    public void projectClosingBeforeSave(@NotNull Project project) {

    }
}
