package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.codeInsight.completion.CompletionPhaseListener;

public class CodeCompletionListener extends BaseListener implements CompletionPhaseListener {

    private static final long MIN_DELAY = 500;
    private long lastTrigger = 0;

    @Override
    public void completionPhaseChanged(boolean isCompletionRunning) {
        long now = System.currentTimeMillis();
        if(now - lastTrigger < MIN_DELAY) {
            return;
        }
        getApplicationService().inspectTopicAction("CodeCompletion", "CodeCompletion triggered");
        lastTrigger = now;
    }
}
