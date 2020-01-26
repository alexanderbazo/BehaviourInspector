package app.listeners.events.ui;

import app.listeners.events.base.BaseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuActionListener extends BaseListener implements ActionListener {

    public MenuActionListener() {
        super("Menu");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        log(actionEvent.getActionCommand());
    }
}
