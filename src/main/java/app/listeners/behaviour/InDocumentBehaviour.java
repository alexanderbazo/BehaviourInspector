package app.listeners.behaviour;

import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.editor.event.SelectionEvent;
import com.intellij.openapi.editor.event.SelectionListener;
import org.jetbrains.annotations.NotNull;

public class InDocumentBehaviour extends BehaviourListener implements DocumentListener, SelectionListener {

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        System.out.println(event);
    }

    @Override
    public void selectionChanged(@NotNull SelectionEvent e) {
        System.out.println(e);
    }
}
