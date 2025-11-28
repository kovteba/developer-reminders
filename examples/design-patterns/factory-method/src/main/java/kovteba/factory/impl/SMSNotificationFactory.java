package kovteba.factory.impl;

import kovteba.factory.NotificationFactory;
import kovteba.notification.Notification;
import kovteba.notification.impl.SMSNotification;

// tag::SMSNotificationFactory[]
public class SMSNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
// end::SMSNotificationFactory[]
