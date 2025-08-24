
abstract class Loan {
    private String borrowerName;
    private double loanAmount;

    public Loan(String borrowerName, double loanAmount) {
        try {
            if (loanAmount <= 0) {
                throw new Exception("Loan amount must be greater than zero!");
            }
            this.borrowerName = borrowerName;
            this.loanAmount = loanAmount;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            this.borrowerName = borrowerName;
            this.loanAmount = 0; // safe default
        }
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public abstract double calculateInterest();
}

class HomeLoan extends Loan {
    public HomeLoan(String borrowerName, double loanAmount) {
        super(borrowerName, loanAmount);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.08;
    }
}
class CarLoan extends Loan {
    public CarLoan(String borrowerName, double loanAmount) {
        super(borrowerName, loanAmount);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.10;
    }
}

class EducationLoan extends Loan {
    public EducationLoan(String borrowerName, double loanAmount) {
        super(borrowerName, loanAmount);
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.05;
    }
}
public class LoanProcessingSystem {
    public static void main(String[] args) {
        Loan l1 = new HomeLoan("Sita", 500000);
        Loan l2 = new CarLoan("Ram", 300000);
        Loan l3 = new EducationLoan("Hari", 200000);
        Loan l4 = new HomeLoan("Gita", -10000); // invalid loan amount
        System.out.println(l1.getBorrowerName() + " Home Loan Interest: " + l1.calculateInterest());
        System.out.println(l2.getBorrowerName() + " Car Loan Interest: " + l2.calculateInterest());
        System.out.println(l3.getBorrowerName() + " Education Loan Interest: " + l3.calculateInterest());
        System.out.println(l4.getBorrowerName() + " Home Loan Interest: " + l4.calculateInterest());
    }
}

