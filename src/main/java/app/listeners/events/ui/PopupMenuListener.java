package app.listeners.events.ui;

import app.listeners.events.base.BaseListener;
import com.intellij.openapi.actionSystem.impl.ActionMenu;
import com.intellij.openapi.actionSystem.impl.ActionMenuItem;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import java.util.ArrayList;

public class PopupMenuListener extends BaseListener implements javax.swing.event.PopupMenuListener {

    private MenuActionListener actionListener;
    private ArrayList<JPopupMenu> knownMenus;

    public PopupMenuListener() {
        actionListener = new MenuActionListener();
        knownMenus = new ArrayList<JPopupMenu>();
    }

    @Override
    public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
        JPopupMenu menu = (JPopupMenu) popupMenuEvent.getSource();
        if(knownMenus.contains(menu)) {
            return;
        }
        for(MenuElement element: menu.getSubElements()) {
            processMenuElement(element);
        }
        knownMenus.add(menu);
    }

    @Override
    public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {

    }

    @Override
    public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {

    }

    public void processMenuElement(MenuElement element) {
        if(element instanceof ActionMenuItem) {
            ((ActionMenuItem) element).addActionListener(actionListener);
        } else if (element instanceof ActionMenu) {
            ActionMenu menu = (ActionMenu) element;
            for(MenuElement subElement: menu.getSubElements()) {
                processMenuElement(subElement);
            }
        }
    }
}
