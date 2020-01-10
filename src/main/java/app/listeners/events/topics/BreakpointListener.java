package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.xdebugger.breakpoints.XBreakpoint;
import com.intellij.xdebugger.breakpoints.XBreakpointListener;
import org.jetbrains.annotations.NotNull;

public class BreakpointListener extends BaseListener implements XBreakpointListener {

    @Override
    public void breakpointAdded(@NotNull XBreakpoint breakpoint) {
    }

    @Override
    public void breakpointRemoved(@NotNull XBreakpoint breakpoint) {
    }

    @Override
    public void breakpointChanged(@NotNull XBreakpoint breakpoint) {

    }
}