package edu.umb.cs680.hw05;

public class Subscriber1 implements Observer<Notification> {

    String message;

    public void update(Observable<Notification> observer ,Notification notification) {
        this.message = notification.getMessage();
        System.out.println(notification.getMessage());
    }

    public String getMessage() {
        return this.message;
    }
    
}
