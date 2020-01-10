package app.listeners.behaviour;


import com.intellij.openapi.editor.event.EditorMouseEvent;
import com.intellij.openapi.editor.event.EditorMouseListener;
import com.intellij.openapi.editor.event.EditorMouseMotionListener;
import org.jetbrains.annotations.NotNull;

public class InEditorBehaviour extends BehaviourListener implements EditorMouseListener, EditorMouseMotionListener {

    @Override
    public void mousePressed(@NotNull EditorMouseEvent event) {

    }

    @Override
    public void mouseClicked(@NotNull EditorMouseEvent event) {
        System.out.println(event);
    }

    @Override
    public void mouseReleased(@NotNull EditorMouseEvent event) {

    }

    @Override
    public void mouseEntered(@NotNull EditorMouseEvent event) {

    }

    @Override
    public void mouseExited(@NotNull EditorMouseEvent event) {

    }

    @Override
    public void mouseMoved(@NotNull EditorMouseEvent e) {

    }

    @Override
    public void mouseDragged(@NotNull EditorMouseEvent e) {

    }
}
