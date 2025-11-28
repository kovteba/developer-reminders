package kovteba.notification.impl;

import kovteba.notification.Notification;

// tag::SMSNotification[]
public class SMSNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification to the user.");
    }
}
// end::SMSNotification[]
