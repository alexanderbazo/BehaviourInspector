package app.listeners.events;

import app.listeners.events.base.BaseListener;
import com.intellij.execution.*;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RunListener extends BaseListener implements RunManagerListener, ExecutionListener {

    @Override
    public void runConfigurationSelected(@Nullable RunnerAndConfigurationSettings settings) {

    }

    @Override
    public void beforeRunTasksChanged() {

    }

    @Override
    public void runConfigurationAdded(@NotNull RunnerAndConfigurationSettings settings) {

    }

    @Override
    public void runConfigurationRemoved(@NotNull RunnerAndConfigurationSettings settings) {

    }

    @Override
    public void runConfigurationChanged(@NotNull RunnerAndConfigurationSettings settings, @Nullable String existingId) {

    }

    @Override
    public void runConfigurationChanged(@NotNull RunnerAndConfigurationSettings settings) {

    }

    @Override
    public void beginUpdate() {
        System.out.println("in: beginUpdate");
    }

    @Override
    public void endUpdate() {

    }

    @Override
    public void stateLoaded(@NotNull RunManager runManager, boolean isFirstLoadState) {

    }

    @Override
    public void processStartScheduled(@NotNull String executorId, @NotNull ExecutionEnvironment env) {

    }

    @Override
    public void processStarting(@NotNull String executorId, @NotNull ExecutionEnvironment env) {
    }

    @Override
    public void processNotStarted(@NotNull String executorId, @NotNull ExecutionEnvironment env) {

    }

    @Override
    public void processStarted(@NotNull String executorId, @NotNull ExecutionEnvironment env, @NotNull ProcessHandler handler) {
        System.out.println("in: processStarted");
    }

    @Override
    public void processTerminating(@NotNull String executorId, @NotNull ExecutionEnvironment env, @NotNull ProcessHandler handler) {

    }

    @Override
    public void processTerminated(@NotNull String executorId, @NotNull ExecutionEnvironment env, @NotNull ProcessHandler handler, int exitCode) {

    }
}
