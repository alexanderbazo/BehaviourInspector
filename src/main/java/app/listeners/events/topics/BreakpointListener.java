package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.xdebugger.breakpoints.XBreakpoint;
import com.intellij.xdebugger.breakpoints.XBreakpointListener;
import org.jetbrains.annotations.NotNull;

public class BreakpointListener extends BaseListener implements XBreakpointListener {

    @Override
    public void breakpointAdded(@NotNull XBreakpoint breakpoint) {
        getApplicationService().inspectTopicAction("Breakpoint", "Breakpoint added");
    }

    @Override
    public void breakpointRemoved(@NotNull XBreakpoint breakpoint) {
        getApplicationService().inspectTopicAction("Breakpoint", "Breakpoint removed");
    }

    @Override
    public void breakpointChanged(@NotNull XBreakpoint breakpoint) {
        getApplicationService().inspectTopicAction("Breakpoint", "Breakpoint changed");

    }
}
