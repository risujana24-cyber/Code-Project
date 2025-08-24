
class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}
abstract class Payment {
    private double amount;

    public Payment(double amount) throws PaymentException {
        if (amount <= 0) {
            throw new PaymentException("Amount must be greater than zero!");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract void processPayment() throws PaymentException;
}

class CreditCard extends Payment {
    private String cardNumber;
    private String cvv;

    public CreditCard(double amount, String cardNumber, String cvv) throws PaymentException {
        super(amount);
        if (cardNumber == null || cardNumber.length() != 16) {
            throw new PaymentException("Invalid Credit Card number! Must be 16 digits.");
        }
        if (cvv == null || cvv.length() != 3) {
            throw new PaymentException("Invalid CVV! Must be 3 digits.");
        }
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void processPayment() throws PaymentException {
        System.out.println("Processing Credit Card payment of Rs." + getAmount());
        System.out.println("Card Number: **** **** **** " + cardNumber.substring(12));
        System.out.println("Payment Successful via Credit Card!");
    }
}
class UPI extends Payment {
    private String upiId;

    public UPI(double amount, String upiId) throws PaymentException {
        super(amount);
        if (upiId == null || !upiId.contains("@")) {
            throw new PaymentException("Invalid UPI ID!");
        }
        this.upiId = upiId;
    }

    @Override
    public void processPayment() throws PaymentException {
        System.out.println("Processing UPI payment of Rs." + getAmount());
        System.out.println("UPI ID: " + upiId);
        System.out.println("Payment Successful via UPI!");
    }
}

class NetBanking extends Payment {
    private String userId;
    private String password;

    public NetBanking(double amount, String userId, String password) throws PaymentException {
        super(amount);
        if (userId == null || userId.trim().isEmpty()) {
            throw new PaymentException("User ID cannot be empty!");
        }
        if (password == null || password.length() < 4) {
            throw new PaymentException("Password must be at least 4 characters long!");
        }
        this.userId = userId;
        this.password = password;
    }

    @Override
    public void processPayment() throws PaymentException {
        System.out.println("Processing NetBanking payment of Rs." + getAmount());
        System.out.println("User ID: " + userId);
        System.out.println("Payment Successful via NetBanking!");
    }
}

public class OnlinePaymentGateway {
    public static void main(String[] args) {
        try {
            Payment[] payments = new Payment[3];

            payments[0] = new CreditCard(5000, "1234567812345678", "123");
            payments[1] = new UPI(1500, "user@upi");
            payments[2] = new NetBanking(2500, "ram", "pass123");
            for (Payment p : payments) {
                try {
                    p.processPayment();
                    System.out.println("-----------------------");
                } catch (PaymentException e) {
                    System.out.println("Payment Error: " + e.getMessage());
                }
            }

            Payment invalid = new CreditCard(-200, "1111222233334444", "123");
            invalid.processPayment();

        } catch (PaymentException e) {
            System.out.println("Initialization Error: " + e.getMessage());
        }
    }
}

