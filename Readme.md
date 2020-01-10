# Behaviour Inspector

A IntelliJ IDEA plugin to log user behaviour during programming assignments.

## Motivation and Premise

This plugin aims to log as many of the user's interactions with the IntelliJ IDEA IDE to get insights into the usage behaviour of programmers. To do so, the plugin connects to the IDE's `MessageBus` to listen to public `Topics`. In addition multiple listeners are use to observer events, available through the IntelliJ Plugin SDK. Finally, several listeners are registered on the actual AWT/Swing components of the IDE application itself.

## Design

The plugins functionality is provides through *services*:

- `LogService` logs and syncs interaction events, using the [`PluginHelper`](https://github.com/OOP-Regensburg/PluginHelper), provided by `libs/PluginHelper.jar`.
- `ManagerService` initializes all necessary event listeners.
- `InspectorService` is used by all listeners to processes and log events. 

`App` serves as the main entry point, triggered when a project is opened. Here, the `LogService` is started and the initializing routines from `ManagerService`are called.

## Implemented/Watched behviour

| Behaviour | Listeners | Notes |
|-----------|-----------|-------|
| Menu usage | `MenuActionListener` | Interaction with the main menu is logged by adding `ActionListeners` to all items of the IDE's `JMenuBar`. Listeners are added when a `PopupMenu` becomes visible for the first time. |