package app.listeners.events;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ex.ToolWindowManagerListener;
import org.jetbrains.annotations.NotNull;

public class ToolWindowListener extends BaseListener implements ToolWindowManagerListener {
    @Override
    public void toolWindowRegistered(@NotNull String id) {

    }

    @Override
    public void toolWindowUnregistered(@NotNull String id, @NotNull ToolWindow toolWindow) {

    }

    @Override
    public void stateChanged() {
        System.out.println("in: stateChanged");
    }
}
