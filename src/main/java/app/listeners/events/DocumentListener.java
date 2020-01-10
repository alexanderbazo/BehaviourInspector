package app.listeners.events;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManagerListener;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class DocumentListener extends BaseListener implements FileDocumentManagerListener {
    @Override
    public void beforeAllDocumentsSaving() {

    }

    @Override
    public void beforeDocumentSaving(@NotNull Document document) {

    }

    @Override
    public void beforeFileContentReload(@NotNull VirtualFile file, @NotNull Document document) {

    }

    @Override
    public void fileWithNoDocumentChanged(@NotNull VirtualFile file) {

    }

    @Override
    public void fileContentReloaded(@NotNull VirtualFile file, @NotNull Document document) {

    }

    @Override
    public void fileContentLoaded(@NotNull VirtualFile file, @NotNull Document document) {
        System.out.println("in: fileContentLoaded");
    }

    @Override
    public void unsavedDocumentsDropped() {

    }
}
