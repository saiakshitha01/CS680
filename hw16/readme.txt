# Observer Design Pattern Example

This project demonstrates the Observer Design Pattern using classes `YoutubeChannel`, `Subscriber1`, `Subscriber2`, and `Subscriber3`. 
The Observer Pattern establishes a one-to-many dependency between objects, where one object (the subject) maintains a list of its dependents (observers) and notifies them of any state changes.

## Classes

### YoutubeChannel
- `YoutubeChannel` is the subject or publisher that notifies its subscribers (observers) when there is new content or notifications available.

### Subscriber1, Subscriber2, and Subscriber3
- `Subscriber1`, `Subscriber2`, and `Subscriber3` are observer classes that subscribe to the `YoutubeChannel` to receive notifications.
- They implement the `Observer` interface and provide an `update` method to react to notifications.

## Usage

1. Create an instance of `YoutubeChannel` and instances of subscribers (e.g., `Subscriber1`, `Subscriber2`, and `Subscriber3`).
2. Register the subscribers with the `YoutubeChannel`.
3. Whenever there is new content or notifications available, the `YoutubeChannel` notifies all registered subscribers by calling their `update` method.
4. Subscribers process the notifications, which can include messages or information about new content.

## Example

YoutubeChannel channel = new YoutubeChannel();
Subscriber1 subscriber1 = new Subscriber1();
Subscriber2 subscriber2 = new Subscriber2();
Subscriber3 subscriber3 = new Subscriber3();

channel.addObserver(subscriber1);
channel.addObserver(subscriber2);
channel.addObserver(subscriber3);

// When there's a new video or notification:
Notification notification = new Notification("New video: 'Title'");
channel.notifyObservers(notification);
