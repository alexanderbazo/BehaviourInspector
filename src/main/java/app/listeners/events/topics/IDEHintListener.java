package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.codeInsight.hint.EditorHintListener;
import com.intellij.openapi.project.Project;
import com.intellij.ui.HintListener;
import com.intellij.ui.LightweightHint;
import data.Measurements;
import org.jetbrains.annotations.NotNull;

import java.util.EventObject;

public class IDEHintListener extends BaseListener implements EditorHintListener, HintListener, Measurements {

    private long lastHintShown = 0;
    private long lastHintHidden = 0;

    public IDEHintListener() {
        super("EditorHint");
    }

    @Override
    public void hintShown(Project project, @NotNull LightweightHint hint, int flags) {
        long now = System.currentTimeMillis();
        if (now - lastHintShown < MIN_EVENT_DELAY_IN_MS) {
            return;
        }
        hint.addHintListener(this);
        log( "Hint shown");
        lastHintShown = now;
    }

    @Override
    public void hintHidden(@NotNull EventObject event) {
        long now = System.currentTimeMillis();
        if (now - lastHintHidden < MIN_EVENT_DELAY_IN_MS) {
            return;
        }
        log("Hint hidden");
        lastHintHidden = now;
    }
}
