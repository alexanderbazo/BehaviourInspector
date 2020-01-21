package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.command.CommandEvent;
import org.jetbrains.annotations.NotNull;

public class CommandListener extends BaseListener implements com.intellij.openapi.command.CommandListener {

    @Override
    public void commandStarted(@NotNull CommandEvent event) {
        getApplicationService().inspectTopicAction("Command started", event.getCommandName());
    }

    @Override
    public void beforeCommandFinished(@NotNull CommandEvent event) {

    }

    @Override
    public void commandFinished(@NotNull CommandEvent event) {
        getApplicationService().inspectTopicAction("Command finished", event.getCommandName());
    }

    @Override
    public void undoTransparentActionStarted() {

    }

    @Override
    public void beforeUndoTransparentActionFinished() {

    }

    @Override
    public void undoTransparentActionFinished() {

    }
}
