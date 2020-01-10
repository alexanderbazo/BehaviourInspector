package app.listeners.events;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.command.CommandEvent;
import org.jetbrains.annotations.NotNull;

public class CommandListener extends BaseListener implements com.intellij.openapi.command.CommandListener {

    @Override
    public void commandStarted(@NotNull CommandEvent event) {

    }

    @Override
    public void beforeCommandFinished(@NotNull CommandEvent event) {

    }

    @Override
    public void commandFinished(@NotNull CommandEvent event) {
        System.out.println("in: Command Finished");
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
