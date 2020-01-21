package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.find.FindModelListener;

public class FindListener extends BaseListener implements FindModelListener {


    @Override
    public void findNextModelChanged() {
        getApplicationService().inspectTopicAction("Search", "Find next item");
    }
}
