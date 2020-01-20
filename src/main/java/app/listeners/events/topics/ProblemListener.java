package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class ProblemListener extends BaseListener implements com.intellij.problems.ProblemListener {
    @Override
    public void problemsAppeared(@NotNull VirtualFile file) {
        System.out.printf("Problems appeared");
    }

    @Override
    public void problemsChanged(@NotNull VirtualFile file) {

    }

    @Override
    public void problemsDisappeared(@NotNull VirtualFile file) {

    }
}
