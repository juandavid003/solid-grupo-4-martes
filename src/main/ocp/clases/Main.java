package ocp.clases;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.sendNotification(new EmailNotification(), "Hello via Email!");
        service.sendNotification(new SMSNotification(), "Hello via SMS!");
        service.sendNotification(new PushNotification(), "Hello via Push Notification!");

        // try {
        //     Notification fax = NotificationFactory.createNotification("Fax");
        //     service.sendNotification(fax, "Hello via Fax!");
        // } catch (IllegalArgumentException e) {
        //     System.out.println(e.getMessage());
        // }
    }
}

