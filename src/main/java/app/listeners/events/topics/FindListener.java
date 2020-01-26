package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.find.FindModelListener;

public class FindListener extends BaseListener implements FindModelListener {

    public FindListener() {
        super("Search");
    }

    @Override
    public void findNextModelChanged() {
        log("Find next item");
    }
}
