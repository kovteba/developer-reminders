package kovteba;

import kovteba.factory.NotificationFactory;
import kovteba.factory.impl.EmailNotificationFactory;
import kovteba.factory.impl.SMSNotificationFactory;
import kovteba.notification.Notification;
import kovteba.notification.impl.EmailNotification;
import kovteba.notification.impl.SMSNotification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {

    @Test
    void emailFactory_createsEmailNotification() {
        NotificationFactory factory = new EmailNotificationFactory();
        Notification notification = factory.createNotification();
        assertInstanceOf(EmailNotification.class, notification);
    }

    @Test
    void smsFactory_createsSmsNotification() {
        NotificationFactory factory = new SMSNotificationFactory();
        Notification notification = factory.createNotification();
        assertInstanceOf(SMSNotification.class, notification);
    }

    @Test
    void emailFactory_sendNotification_doesNotThrow() {
        NotificationFactory factory = new EmailNotificationFactory();
        assertDoesNotThrow(factory::sendNotification);
    }

    @Test
    void smsFactory_sendNotification_doesNotThrow() {
        NotificationFactory factory = new SMSNotificationFactory();
        assertDoesNotThrow(factory::sendNotification);
    }

    @Test
    void emailNotification_notifyUser_doesNotThrow() {
        Notification n = new EmailNotification();
        assertDoesNotThrow(n::notifyUser);
    }

    @Test
    void smsNotification_notifyUser_doesNotThrow() {
        Notification n = new SMSNotification();
        assertDoesNotThrow(n::notifyUser);
    }
}
