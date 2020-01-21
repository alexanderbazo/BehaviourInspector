package app.listeners.events.actions;

import java.util.HashMap;

public class ActionPool {

    private static ActionPool instance;
    private HashMap<String, ProxyAction> actions;

    private ActionPool() {
        actions = new HashMap<String, ProxyAction>();
    }

    public void registerProxyAction(String action, String category, String description) {
        if(actions.containsKey(action)) {
            return;
        }
        ProxyAction proxyAction = new ProxyAction(action, category, description);
        actions.put(action, proxyAction);
    }

    public static ActionPool getInstance() {
        if(instance == null) {
            instance = new ActionPool();
        }
        return instance;
    }

}
