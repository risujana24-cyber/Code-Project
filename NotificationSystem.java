
abstract class Notification {
    private String recipient;

    public Notification(String recipient) {
        try {
            if (recipient == null || recipient.trim().isEmpty()) {
                throw new Exception("Recipient details cannot be empty!");
            }
            this.recipient = recipient;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            this.recipient = "Unknown";
        }
    }

    public String getRecipient() {
        return recipient;
    }

    public abstract void send();
}
class EmailNotification extends Notification {
    private String emailMessage;

    public EmailNotification(String recipient, String emailMessage) {
        super(recipient);
        try {
            if (emailMessage == null || emailMessage.trim().isEmpty()) {
                throw new Exception("Email message cannot be empty!");
            }
            this.emailMessage = emailMessage;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            this.emailMessage = "Default Email Message";
        }
    }

    @Override
    public void send() {
        System.out.println("Sending Email to " + getRecipient() + ": " + emailMessage);
    }
}
class SMSNotification extends Notification {
    private String smsText;

    public SMSNotification(String recipient, String smsText) {
        super(recipient);
        try {
            if (smsText == null || smsText.trim().isEmpty()) {
                throw new Exception("SMS text cannot be empty!");
            }
            this.smsText = smsText;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            this.smsText = "Default SMS Message";
        }
    }

    @Override
    public void send() {
        System.out.println("Sending SMS to " + getRecipient() + ": " + smsText);
    }
}
class PushNotification extends Notification {
    private String pushMessage;

    public PushNotification(String recipient, String pushMessage) {
        super(recipient);
        try {
            if (pushMessage == null || pushMessage.trim().isEmpty()) {
                throw new Exception("Push message cannot be empty!");
            }
            this.pushMessage = pushMessage;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            this.pushMessage = "Default Push Message";
        }
    }

    @Override
    public void send() {
        System.out.println("Sending Push Notification to " + getRecipient() + ": " + pushMessage);
    }
}

public class NotificationSystem {
    public static void main(String[] args) {
        Notification n1 = new EmailNotification("sita@example.com", "Welcome to our service!");
        Notification n2 = new SMSNotification("9841234567", "Your OTP is 1234.");
        Notification n3 = new PushNotification("Hari's Device", "You have a new friend request.");
        Notification n4 = new EmailNotification("", ""); // Invalid test case

        n1.send();
        n2.send();
        n3.send();
        n4.send();
    }
}

