package kovteba.notification.impl;

import kovteba.notification.Notification;

// tag::EmailNotification[]
public class EmailNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending an email notification to the user.");
    }
}
// end::EmailNotification[]
