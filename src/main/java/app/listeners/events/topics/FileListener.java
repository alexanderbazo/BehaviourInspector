package app.listeners.events.topics;

import app.listeners.events.ListenerHelper;
import app.listeners.events.base.BaseListener;
import com.intellij.openapi.fileEditor.*;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class FileListener extends BaseListener implements FileEditorManagerListener {

    private boolean wasInvokedOnce = false;

    @Override
    public void fileOpenedSync(@NotNull FileEditorManager source, @NotNull VirtualFile file, @NotNull Pair<FileEditor[], FileEditorProvider[]> editors) {
    }

    @Override
    public void fileOpened(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
        FileEditor currentEditor = source.getSelectedEditor();
        if(!wasInvokedOnce) {
            ListenerHelper.initMenuListener(currentEditor.getComponent());
            wasInvokedOnce = true;
        }
    }

    @Override
    public void fileClosed(@NotNull FileEditorManager source, @NotNull VirtualFile file) {
    }

    @Override
    public void selectionChanged(@NotNull FileEditorManagerEvent event) {
    }
}
