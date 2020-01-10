package app.listeners.events;

import app.listeners.events.base.BaseListener;
import com.intellij.ide.navigationToolbar.NavBarModelListener;

public class NavigationBarListener extends BaseListener implements NavBarModelListener {
    @Override
    public void modelChanged() {
        System.out.println("in: modelChanged (NavigationBarListener");
    }

    @Override
    public void selectionChanged() {
        System.out.println("in: selectionChanged (NavigationBarListener");
    }
}
