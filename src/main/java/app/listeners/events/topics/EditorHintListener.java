package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.project.Project;
import com.intellij.ui.LightweightHint;
import org.jetbrains.annotations.NotNull;

public class EditorHintListener extends BaseListener implements com.intellij.codeInsight.hint.EditorHintListener {

    @Override
    public void hintShown(Project project, @NotNull LightweightHint hint, int flags) {
    }
}
