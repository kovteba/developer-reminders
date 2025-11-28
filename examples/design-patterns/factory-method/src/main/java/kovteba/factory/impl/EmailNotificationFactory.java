package kovteba.factory.impl;

import kovteba.factory.NotificationFactory;
import kovteba.notification.Notification;
import kovteba.notification.impl.EmailNotification;

// tag::EmailNotificationFactory[]
public class EmailNotificationFactory extends NotificationFactory {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
// end::EmailNotificationFactory[]
