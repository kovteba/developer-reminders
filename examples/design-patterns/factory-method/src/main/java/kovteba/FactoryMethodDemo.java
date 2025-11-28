package kovteba;

import kovteba.factory.NotificationFactory;
import kovteba.factory.impl.EmailNotificationFactory;
import kovteba.factory.impl.SMSNotificationFactory;

import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.DriverManager;
import java.util.logging.Logger;

// tag::FactoryMethodDemo[]
public class FactoryMethodDemo {

    public static void main(String[] args) {

        NotificationFactory factory1 = new SMSNotificationFactory();
        factory1.sendNotification();

        NotificationFactory factory2 = new EmailNotificationFactory();
        factory2.sendNotification();

//        DriverManager.getConnection();
//        Logger.getLogger();
        DocumentBuilderFactory.newInstance();
    }
}
// end::FactoryMethodDemo[]
