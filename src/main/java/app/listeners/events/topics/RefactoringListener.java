package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.refactoring.listeners.RefactoringEventData;
import com.intellij.refactoring.listeners.RefactoringEventListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RefactoringListener extends BaseListener implements RefactoringEventListener {
    @Override
    public void refactoringStarted(@NotNull String refactoringId, @Nullable RefactoringEventData beforeData) {
        getApplicationService().inspectTopicAction("Refactoring", "Refactoring started");
    }

    @Override
    public void refactoringDone(@NotNull String refactoringId, @Nullable RefactoringEventData afterData) {
        getApplicationService().inspectTopicAction("Refactoring", "Refactoring function used");
    }

    @Override
    public void conflictsDetected(@NotNull String refactoringId, @NotNull RefactoringEventData conflictsData) {
        getApplicationService().inspectTopicAction("Refactoring", "Refactoring conflict detected");
    }

    @Override
    public void undoRefactoring(@NotNull String refactoringId) {
        getApplicationService().inspectTopicAction("Refactoring", "Refactoring undo started");
    }
}
