# Behaviour Inspector

A IntelliJ IDEA plugin to log user behaviour during programming assignments.

## Motivation and Premise

This plugin aims to log as many of the user's interactions with the IntelliJ IDEA IDE to get insights into the usage behaviour of programmers. To do so, the plugin connects to the IDE's `MessageBus` to listen to public `Topics`. In addition multiple listeners are use to observer events, available through the IntelliJ Plugin SDK. Finally, several listeners are registered on the actual AWT/Swing components of the IDE application itself.

## Design

The plugins functionality is provides through *services*:

- `app/services/application/ApplicationService` provides the plugin's basic functionality, allowing log sessions to be started and saved.
- `app/services/log/LogService` logs and syncs interaction events, using the [`PluginHelper`](https://github.com/OOP-Regensburg/PluginHelper), provided by `libs/PluginHelper.jar`.


`App` serves as the main entry point, triggered when a project is opened. During runtime the current project can be accessed from a static member.

Log sessions are started and saved through a menu entry, implemented in `app/ui/SessionAction`, and will be synced to a remote server.


## Implemented/Watched behviour

| Behaviour | Listeners | Notes |
|-----------|-----------|-------|
| Menu usage | `app/listeners/events/ui/MenuActionListener` | Interaction with the main menu is logged by adding `ActionListeners` to all items of the IDE's `JMenuBar`. Listeners are added when a `PopupMenu` becomes visible for the first time. |