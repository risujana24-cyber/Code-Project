
class Employee {
    private String name;
    private double salary;


    public Employee(String name, double salary) {
        try {
            if (salary < 0) {
                throw new Exception("Salary cannot be negative.");
            }
            this.name = name;
            this.salary = salary;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            this.salary = 0; // default safe value
        }
    }


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        try {
            if (salary < 0) {
                throw new Exception("Salary cannot be negative.");
            }
            this.salary = salary;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public double calculateBonus() {
        return 0;
    }
}
class PermanentEmployee extends Employee {
    public PermanentEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.20;
    }
}

class ContractEmployee extends Employee {
    public ContractEmployee(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.10;
    }
}
public class EmployeeBonusSystem {
    public static void main(String[] args) {
        Employee emp1 = new PermanentEmployee("Sita", 50000);
        Employee emp2 = new ContractEmployee("Ram", 30000);
        Employee emp3 = new PermanentEmployee("Hari", -20000);


        System.out.println(emp1.getName() + " Bonus: " + emp1.calculateBonus());
        System.out.println(emp2.getName() + " Bonus: " + emp2.calculateBonus());
        System.out.println(emp3.getName() + " Bonus: " + emp3.calculateBonus());
    }
}
