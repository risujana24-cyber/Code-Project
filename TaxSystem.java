
class IncomeException extends Exception {
    public IncomeException(String message) {
        super(message);
    }
}

abstract class TaxPayer {
    private String name;
    private double income;

    public TaxPayer(String name, double income) throws IncomeException {
        if (income < 0) {
            throw new IncomeException("Income cannot be negative for " + name);
        }
        this.name = name;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

    public abstract double calculateTax();
}


class Individual extends TaxPayer {
    public Individual(String name, double income) throws IncomeException {
        super(name, income);
    }

    @Override
    public double calculateTax() {
        double taxRate = 0.1;
        return getIncome() * taxRate;
    }
}


class Business extends TaxPayer {
    public Business(String name, double income) throws IncomeException {
        super(name, income);
    }

    @Override
    public double calculateTax() {
        double taxRate = 0.25;
        return getIncome() * taxRate;
    }
}

class Freelancer extends TaxPayer {
    public Freelancer(String name, double income) throws IncomeException {
        super(name, income);
    }

    @Override
    public double calculateTax() {
        double taxRate = 0.15;
        return getIncome() * taxRate;
    }
}


public class TaxSystem {
    public static void main(String[] args) {
        try {
            TaxPayer ind = new Individual("Ram", 50000);
            TaxPayer biz = new Business("Shyam", 200000);
            TaxPayer free = new Freelancer("Hari", 80000);

            System.out.println(ind.getName() + " (Individual) tax: $" + ind.calculateTax());
            System.out.println(biz.getName() + " (Business) tax: $" + biz.calculateTax());
            System.out.println(free.getName() + " (Freelancer) tax: $" + free.calculateTax());

            TaxPayer invalid = new Individual("Bob", -10000);

        } catch (IncomeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

