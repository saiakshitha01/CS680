package edu.umb.cs680.hw05;

public class Subscriber3 implements Observer<Notification> {

    private String message;

    public void update(Observable<Notification> observer ,Notification notification) {
        this.message = notification.getMessage();
        System.out.println(notification.getMessage());
    }

    public String getMessage() {
        return this.message;
    }
    
}