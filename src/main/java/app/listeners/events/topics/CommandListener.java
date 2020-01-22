package app.listeners.events.topics;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.command.CommandEvent;
import org.jetbrains.annotations.NotNull;

public class CommandListener extends BaseListener implements com.intellij.openapi.command.CommandListener {

    private static final String[] BLACKLLIST = {"", "Typing", "Tab", "Enter", "Backspace"};

    private boolean isOnBlacklist(CommandEvent event) {
        String name = event.getCommandName();
        if(name == null) {
            return true;
        }
        for(String restrictedCommand: BLACKLLIST) {
            if(restrictedCommand.equals(event.getCommandName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void commandStarted(@NotNull CommandEvent event) {
        if(isOnBlacklist(event)) {
            return;
        }
        getApplicationService().inspectTopicAction("Command", event.getCommandName());
    }

    @Override
    public void beforeCommandFinished(@NotNull CommandEvent event) {

    }

    @Override
    public void commandFinished(@NotNull CommandEvent event) {
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
