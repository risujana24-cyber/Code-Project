
abstract class InsurancePolicy {
    private String policyHolder;
    private int age;
    private double coverageAmount;

    public InsurancePolicy(String policyHolder, int age, double coverageAmount) {
        try {
            if (age <= 0) {
                throw new Exception("Age must be greater than zero!");
            }
            if (coverageAmount <= 0) {
                throw new Exception("Coverage amount must be greater than zero!");
            }
            this.policyHolder = policyHolder;
            this.age = age;
            this.coverageAmount = coverageAmount;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            this.policyHolder = policyHolder;
            this.age = 0;
            this.coverageAmount = 0;
        }
    }


    public String getPolicyHolder() {
        return policyHolder;
    }

    public int getAge() {
        return age;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }


    public abstract double calculatePremium();
}


class HealthInsurance extends InsurancePolicy {
    public HealthInsurance(String policyHolder, int age, double coverageAmount) {
        super(policyHolder, age, coverageAmount);
    }

    @Override
    public double calculatePremium() {
        double basePremium = getCoverageAmount() * 0.05;
        if (getAge() > 50) {
            basePremium += 2000;
        }
        return basePremium;
    }
}


class LifeInsurance extends InsurancePolicy {
    public LifeInsurance(String policyHolder, int age, double coverageAmount) {
        super(policyHolder, age, coverageAmount);
    }

    @Override
    public double calculatePremium() {

        double basePremium = getCoverageAmount() * 0.03;
        if (getAge() > 60) {
            basePremium += 3000;
        }
        return basePremium;
    }
}


class TravelInsurance extends InsurancePolicy {
    public TravelInsurance(String policyHolder, int age, double coverageAmount) {
        super(policyHolder, age, coverageAmount);
    }

    @Override
    public double calculatePremium() {

        double basePremium = getCoverageAmount() * 0.04;
        if (getAge() < 18) {
            basePremium += 1000;
        }
        return basePremium;
    }
}


public class InsurancePolicySystem {
    public static void main(String[] args) {

        InsurancePolicy p1 = new HealthInsurance("Sita", 45, 500000);
        InsurancePolicy p2 = new LifeInsurance("Ram", 65, 1000000);
        InsurancePolicy p3 = new TravelInsurance("Hari", 16, 200000);
        InsurancePolicy p4 = new HealthInsurance("Gita", -25, 300000); // Invalid age test
        InsurancePolicy p5 = new LifeInsurance("Shyam", 30, -10000);   // Invalid coverage test


        System.out.println(p1.getPolicyHolder() + " Health Premium: Rs." + p1.calculatePremium());
        System.out.println(p2.getPolicyHolder() + " Life Premium: Rs." + p2.calculatePremium());
        System.out.println(p3.getPolicyHolder() + " Travel Premium: Rs." + p3.calculatePremium());
        System.out.println(p4.getPolicyHolder() + " Health Premium: Rs." + p4.calculatePremium());
        System.out.println(p5.getPolicyHolder() + " Life Premium: Rs." + p5.calculatePremium());
    }
}
