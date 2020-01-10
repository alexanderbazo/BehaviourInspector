package app.listeners.events.ui;

import app.listeners.events.base.BaseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuActionListener extends BaseListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        getInspector().inspectMenuAction(actionEvent);
    }
}
