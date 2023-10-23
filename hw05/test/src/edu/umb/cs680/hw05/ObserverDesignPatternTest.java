package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverDesignPatternTest {

    @Test
    public void testWhetherSubscribersAreAdded() {
        YoutubeChannel channel = new YoutubeChannel();
        channel.addObserver(new Subscriber1());
        channel.addObserver(new Subscriber2());
        channel.addObserver(new Subscriber3());
        assertEquals(3, channel.countObservers());
    }

    @Test
    public void testIfSubscriber1ReceivedNotification() {
        YoutubeChannel channel = new YoutubeChannel();
        Subscriber1 subscriber = new Subscriber1();
        channel.addObserver(subscriber);

        channel.notifyObservers(new Notification("HI message here!"));
        assertEquals("HI message here!", subscriber.getMessage());
    }

    @Test
    public void testIfSubscriber2ReceivedNotification() {
        YoutubeChannel channel = new YoutubeChannel();
        Subscriber2 subscriber = new Subscriber2();
        channel.addObserver(subscriber);

        channel.notifyObservers(new Notification("HI message here!"));
        assertEquals("HI message here!", subscriber.getMessage());
    }

    @Test
    public void testIfSubscriber3ReceivedNotification() {
        YoutubeChannel channel = new YoutubeChannel();
        Subscriber3 subscriber = new Subscriber3();
        channel.addObserver(subscriber);

        channel.notifyObservers(new Notification("HI message here!"));
        assertEquals("HI message here!", subscriber.getMessage());
    }

    @Test
    public void testGetObservers() {
        YoutubeChannel channel = new YoutubeChannel();
        Subscriber1 subscriber1 = new Subscriber1();
        Subscriber2 subscriber2 = new Subscriber2();
        Subscriber3 subscriber3 = new Subscriber3();
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
        Subscriber1 subscriber1 = new Subscriber1();
        Subscriber2 subscriber2 = new Subscriber2();
        Subscriber3 subscriber3 = new Subscriber3();
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
        Subscriber1 subscriber1 = new Subscriber1();
        Subscriber2 subscriber2 = new Subscriber2();
        Subscriber3 subscriber3 = new Subscriber3();
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
