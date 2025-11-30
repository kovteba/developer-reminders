package kovteba.factory;

import kovteba.notification.Notification;

// tag::NotificationFactory[]
public abstract class NotificationFactory {

    public abstract Notification createNotification();

    // спільний метод для відсилання сповіщення
    public void sendNotification() {

        Notification notification = createNotification();
        notification.notifyUser();
    }
}
// end::NotificationFactory[]
