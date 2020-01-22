package app.listeners.events.ui;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class MenuListener implements javax.swing.event.MenuListener {

    @Override
    public void menuSelected(MenuEvent menuEvent) {
        JMenu menu = (JMenu) menuEvent.getSource();
        menu.getPopupMenu().addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
                System.out.println("TEST");
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {

            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {

            }
        });
        for(int i = 0; i < menu.getItemCount(); i++) {
            System.out.println(menu.getItem(i));
        }
    }

    @Override
    public void menuDeselected(MenuEvent menuEvent) {

    }

    @Override
    public void menuCanceled(MenuEvent menuEvent) {

    }
}
