package app.listeners.events;

import javax.swing.event.MenuEvent;

public class MenuListener implements javax.swing.event.MenuListener {
    @Override
    public void menuSelected(MenuEvent menuEvent) {
        System.out.println("in: menuSelected");
        System.out.println(menuEvent.getClass());
    }

    @Override
    public void menuDeselected(MenuEvent menuEvent) {

    }

    @Override
    public void menuCanceled(MenuEvent menuEvent) {

    }
}
