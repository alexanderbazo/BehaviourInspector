package app.listeners.events;

import app.listeners.events.base.BaseListener;
import com.intellij.refactoring.listeners.RefactoringEventData;
import com.intellij.refactoring.listeners.RefactoringEventListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RefactoringListener extends BaseListener implements RefactoringEventListener {
    @Override
    public void refactoringStarted(@NotNull String refactoringId, @Nullable RefactoringEventData beforeData) {
        System.out.println("Refactoring started");
    }

    @Override
    public void refactoringDone(@NotNull String refactoringId, @Nullable RefactoringEventData afterData) {

    }

    @Override
    public void conflictsDetected(@NotNull String refactoringId, @NotNull RefactoringEventData conflictsData) {

    }

    @Override
    public void undoRefactoring(@NotNull String refactoringId) {

    }
}
