
class InvalidCreditException extends Exception {
    public InvalidCreditException(String message) {
        super(message);
    }
}

abstract class Course {
    private String courseCode;
    private int credit;
    public Course(String courseCode, int credit) throws InvalidCreditException {
        if (credit <= 0) {
            throw new InvalidCreditException("Credit must be positive!");
        }
        this.courseCode = courseCode;
        this.credit = credit;
    }
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) throws InvalidCreditException {
        if (credit <= 0) {
            throw new InvalidCreditException("Credit must be positive!");
        }
        this.credit = credit;
    }
    public abstract int calculateWorkload();
}
class TheoryCourse extends Course {
    public TheoryCourse(String courseCode, int credit) throws InvalidCreditException {
        super(courseCode, credit);
    }
    @Override
    public int calculateWorkload() {
        return getCredit() * 3;
    }
}
class LabCourse extends Course {
    public LabCourse(String courseCode, int credit) throws InvalidCreditException {
        super(courseCode, credit);
    }
    @Override
    public int calculateWorkload() {
        return getCredit() * 2;
    }
}

public class UniversityCourse {
    public static void main(String[] args) {
        try {
            Course theory = new TheoryCourse("CS101", 3);
            Course lab = new LabCourse("CS102L", 2);

            System.out.println("Course: " + theory.getCourseCode() +
                    " | Workload: " + theory.calculateWorkload() + " hours");
            System.out.println("Course: " + lab.getCourseCode() +
                    " | Workload: " + lab.calculateWorkload() + " hours");

            Course invalid = new TheoryCourse("CS103", -4);

        } catch (InvalidCreditException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

