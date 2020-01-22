package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.project.Project;
import com.intellij.ui.HintListener;
import com.intellij.ui.LightweightHint;
import data.Measurements;
import org.jetbrains.annotations.NotNull;

import java.util.EventObject;

public class EditorHintListener extends BaseListener implements com.intellij.codeInsight.hint.EditorHintListener, HintListener, Measurements {

    private long lastHintShown = 0;
    private long lastHintHidden = 0;

    @Override
    public void hintShown(Project project, @NotNull LightweightHint hint, int flags) {
        long now = System.currentTimeMillis();
        if (now - lastHintShown < MIN_EVENT_DELAY_IN_MS) {
            return;
        }
        hint.addHintListener(this);
        getApplicationService().inspectTopicAction("EditorHint", "Hint shown");
        lastHintShown = now;
    }

    @Override
    public void hintHidden(@NotNull EventObject event) {
        long now = System.currentTimeMillis();
        if (now - lastHintHidden < MIN_EVENT_DELAY_IN_MS) {
            return;
        }
        getApplicationService().inspectTopicAction("EditorHint", "Hint hidden");
        lastHintHidden = now;
    }
}
