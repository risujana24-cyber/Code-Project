
class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
        super(message);
    }
}
abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws InvalidDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Person name cannot be null or empty.");
        }
        if (age <= 0) {
            throw new InvalidDataException("Person age must be a positive number.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract String getDetails();
}

class Doctor extends Person {
    private String specialization;

    public Doctor(String name, int age, String specialization) throws InvalidDataException {
        super(name, age);
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new InvalidDataException("Doctor specialization cannot be null or empty.");
        }
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String getDetails() {
        return "Doctor: " + getName() + ", Age: " + getAge() + ", Specialization: " + specialization;
    }
}
class Patient extends Person {
    private String ailment;

    public Patient(String name, int age, String ailment) throws InvalidDataException {
        super(name, age);
        if (ailment == null || ailment.trim().isEmpty()) {
            throw new InvalidDataException("Patient ailment cannot be null or empty.");
        }
        this.ailment = ailment;
    }

    public String getAilment() {
        return ailment;
    }

    @Override
    public String getDetails() {
        return "Patient: " + getName() + ", Age: " + getAge() + ", Ailment: " + ailment;
    }
}
public class Hospital {
    public static void main(String[] args) {
        try {
            Doctor doc1 = new Doctor("Dr. Ram", 45, "Cardiology");
            System.out.println(doc1.getDetails());
            Patient pat1 = new Patient("Sita", 30, "Fever");
            System.out.println(pat1.getDetails());

        } catch (InvalidDataException e) {
            System.err.println("Error creating person: " + e.getMessage());
        }
    }
}
