package edu.umb.cs680.hw16;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverDesignPatternTest {

    @Test
    public void testWhetherSubscribersAreAdded() {
        YoutubeChannel channel = new YoutubeChannel();
        channel.addObserver((obs, notification) -> {});
        channel.addObserver((obs, notification) -> {});
        channel.addObserver((obs, notification) -> {});
        assertEquals(3, channel.countObservers());
    }

    @Test
    public void testGetObservers() {
        YoutubeChannel channel = new YoutubeChannel();
        Observer<Notification> subscriber1 = (obs, notification) -> {};
        Observer<Notification> subscriber2 = (obs, notification) -> {};
        Observer<Notification> subscriber3 = (obs, notification) -> {};
        channel.addObserver(subscriber1);
        channel.addObserver(subscriber2);
        channel.addObserver(subscriber3);

        LinkedList<Observer<Notification>> observers = new LinkedList<Observer<Notification>>();
        observers.add(subscriber1);
        observers.add(subscriber2);
        observers.add(subscriber3);
        assertIterableEquals(observers, channel.getObservers());
    }

    @Test
    public void testClearObservers() {
        YoutubeChannel channel = new YoutubeChannel();
        Observer<Notification> subscriber1 = (obs, notification) -> {};
        Observer<Notification> subscriber2 = (obs, notification) -> {};
        Observer<Notification> subscriber3 = (obs, notification) -> {};
        channel.addObserver(subscriber1);
        channel.addObserver(subscriber2);
        channel.addObserver(subscriber3);

        LinkedList<Observer<Notification>> observers = new LinkedList<Observer<Notification>>();
        channel.clearObservers();
        assertIterableEquals(observers, channel.getObservers());
    }

    @Test
    public void testRemoveObserver() {
        YoutubeChannel channel = new YoutubeChannel();
        Observer<Notification> subscriber1 = (obs, notification) -> {};
        Observer<Notification> subscriber2 = (obs, notification) -> {};
        Observer<Notification> subscriber3 = (obs, notification) -> {};
        channel.addObserver(subscriber1);
        channel.addObserver(subscriber2);
        channel.addObserver(subscriber3);

        LinkedList<Observer<Notification>> observers = new LinkedList<Observer<Notification>>();
        observers.add(subscriber1);
        observers.add(subscriber2);

        channel.removeObserver(subscriber3);
        assertIterableEquals(observers, channel.getObservers());
    }


}
