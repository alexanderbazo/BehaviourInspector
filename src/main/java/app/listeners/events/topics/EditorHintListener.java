package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.project.Project;
import com.intellij.ui.LightweightHint;
import org.jetbrains.annotations.NotNull;

public class EditorHintListener extends BaseListener implements com.intellij.codeInsight.hint.EditorHintListener {

    private static final long MIN_DELAY = 500;
    private long lastTrigger = 0;

    @Override
    public void hintShown(Project project, @NotNull LightweightHint hint, int flags) {
        long now = System.currentTimeMillis();
        if(now - lastTrigger < MIN_DELAY) {
            return;
        }
        getApplicationService().inspectTopicAction("EditorHint", "Hint shown");
        lastTrigger = now;
    }
}
