
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}


abstract class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) throws InvalidSalaryException {
        if (baseSalary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative for " + name);
        }
        this.name = name;
        this.baseSalary = baseSalary;
    }


    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) throws InvalidSalaryException {
        if (baseSalary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative for " + name);
        }
        this.baseSalary = baseSalary;
    }


    public abstract double calculateSalary();
}


class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) throws InvalidSalaryException {
        super(name, baseSalary);
        if (bonus < 0) {
            throw new InvalidSalaryException("Bonus cannot be negative for " + name);
        }
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) throws InvalidSalaryException {
        if (bonus < 0) {
            throw new InvalidSalaryException("Bonus cannot be negative for " + getName());
        }
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
}

class Developer extends Employee {
    private double overtime;

    public Developer(String name, double baseSalary, double overtime) throws InvalidSalaryException {
        super(name, baseSalary);
        if (overtime < 0) {
            throw new InvalidSalaryException("Overtime cannot be negative for " + name);
        }
        this.overtime = overtime;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) throws InvalidSalaryException {
        if (overtime < 0) {
            throw new InvalidSalaryException("Overtime cannot be negative for " + getName());
        }
        this.overtime = overtime;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + overtime * 20; // assuming $20 per overtime hour
    }
}


public class EmployeeSystem {
    public static void main(String[] args) {
        try {
            Employee m1 = new Manager("Alice", 5000, 1000);
            Employee d1 = new Developer("Bob", 4000, 50); // 50 hours overtime

            System.out.println(m1.getName() + " (Manager) salary: $" + m1.calculateSalary());
            System.out.println(d1.getName() + " (Developer) salary: $" + d1.calculateSalary());

            Employee invalid = new Developer("Charlie", -3000, 10);

        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
