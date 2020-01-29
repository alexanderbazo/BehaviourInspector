# Behaviour Inspector

A IntelliJ IDEA plugin to log user behaviour during programming assignments.

## Motivation and Premise

This plugin aims to log as many of the user's interactions with the IntelliJ IDEA IDE to get insights into the usage behaviour of programmers. To do so, the plugin connects to the IDE's `MessageBus` to listen to public `Topics`. In addition multiple listeners are use to observer events, available through the [IntelliJ Plattform SDK](https://www.jetbrains.org/intellij/sdk/docs/welcome.html). Finally, several listeners are registered on the actual AWT/Swing components of the IDE application itself.

## Design

`App` serves as the main entry point, triggered when a project is opened. During runtime the current project can be accessed by a static member from `App`. Log sessions are started and saved through a menu entry, implemented in `app/ui/SessionAction`, and will be uploaded to a remote server using the [`PluginHelper's`](https://github.com/OOP-Regensburg/PluginHelper) build-in sync function.

The plugins main functionality is provides through *services*:

- `app/services/application/ApplicationService` provides the plugin's basic functionality, allowing log sessions to be started and saved. `ApplicationService` is using static methods from `ListenerHelper` to initialize the different behaviour listeners.
- `app/services/log/LogService` logs and syncs interaction events, using the [`PluginHelper`](https://github.com/OOP-Regensburg/PluginHelper), provided by `libs/PluginHelper.jar`.

### Listeners

The plugin is utilizing different types of events and listeners, provided by the [IntelliJ Plattform SDK](https://www.jetbrains.org/intellij/sdk/docs/welcome.html) to watch and log different types of user interaction.

#### Message Bus

Several IDE events are watched by subscribing to [Topics](https://www.jetbrains.org/intellij/sdk/docs/reference_guide/messaging_infrastructure.html) on the internal *Message Bus*. Subscribing is done in `ListenerHelper`. The matching listeners are implemented in `listeners/events/topics` and are all based on `BaseListener`. To catch the actual events the listeners implement the relevant interfaces from the Plattform SDK.

#### Actions

IntelliJ uses an [Action System](https://www.jetbrains.org/intellij/sdk/docs/basics/action_system.html) to enable plugins to provide (alternative) implementations for IDE functions. Existing actions are identified by unique IDs. This plugins uses *pass-through* actions to watch certain interaction behaviour. The `ProxyAction` class wraps existing actions, logs when they are triggered and afterwards runs the wrapped original action. The proxy actions are managed in `ActionPool`.

#### UI Events

Since IntelliJ's UI is build from Swing and AWT components, some interactions behaviour can be watched by attaching listeners to the actual UI components. This is used to catch all main menu actions (e.g. selecting an menu entry). Logging these actions currently only work on non-windows machines.

### Logging and Syncing

While the actual logging and syncing is done by using the [`PluginHelper`](https://github.com/OOP-Regensburg/PluginHelper), this plugins provides some UI components to ask for the user's consent before uploading the logged data.

## Currently watched interactions 

- Opening of and switching to files
- Frequency of editing actions
- Usage of the search function
- Usage of the refactoring feature
- Usage of code completion feature
- Usage of the hierarchy tree feature
- Adding and Removing of breakpoints
- Triggering of internal commands, e.g. code formatting
- Warnings and errors in code
- Lifecycle of in-code hints
- Lifecycle of executed/debugged projects