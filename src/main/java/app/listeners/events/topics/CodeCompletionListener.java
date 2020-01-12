package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.codeInsight.completion.CompletionPhaseListener;

public class CodeCompletionListener extends BaseListener implements CompletionPhaseListener {
    @Override
    public void completionPhaseChanged(boolean isCompletionRunning) {
        getApplicationService().inspectTopicAction("CodeCompletion", "CodeCompletion triggered");
    }
}
