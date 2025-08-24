
abstract class LibrarySystem {
    protected String memberId;
    protected String name;

    public LibrarySystem(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public abstract void borrowBook(Book book) throws BorrowingLimitException;

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name;
    }
}

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class BorrowingLimitException extends Exception {
    public BorrowingLimitException(String message) {
        super(message);
    }
}


class Student extends LibrarySystem {
    private int booksBorrowed;
    private static final int BORROWING_LIMIT = 5;

    public Student(String memberId, String name) {
        super(memberId, name);
        this.booksBorrowed = 0;
    }

    @Override
    public void borrowBook(Book book) throws BorrowingLimitException {
        if (booksBorrowed >= BORROWING_LIMIT) {
            throw new BorrowingLimitException("Student " + getName() + " has reached the borrowing limit of " + BORROWING_LIMIT + " books.");
        }
        System.out.println("Student " + getName() + " is borrowing the book: " + book.getTitle());
        booksBorrowed++;
    }
}

class Teacher extends LibrarySystem{
    private int booksBorrowed;
    private static final int BORROWING_LIMIT = 10;

    public Teacher(String memberId, String name) {
        super(memberId, name);
        this.booksBorrowed = 0;
    }

    @Override
    public void borrowBook(Book book) throws BorrowingLimitException {
        if (booksBorrowed >= BORROWING_LIMIT) {
            throw new BorrowingLimitException("Teacher " + getName() + " has reached the borrowing limit of " + BORROWING_LIMIT + " books.");
        }
        System.out.println("Teacher " + getName() + " is borrowing the book: " + book.getTitle());
        booksBorrowed++;
    }
}

class Guest extends LibrarySystem {
    private int booksBorrowed;
    private static final int BORROWING_LIMIT = 1;

    public Guest(String memberId, String name) {
        super(memberId, name);
        this.booksBorrowed = 0;
    }

    @Override
    public void borrowBook(Book book) throws BorrowingLimitException {
        if (booksBorrowed >= BORROWING_LIMIT) {
            throw new BorrowingLimitException("Guest " + getName() + " has reached the borrowing limit of " + BORROWING_LIMIT + " book.");
        }
        System.out.println("Guest " + getName() + " is borrowing the book: " + book.getTitle());
        booksBorrowed++;
    }
}

public class LibraryMemberSystem{
    public static void main(String[] args) {
        Student student1 = new Student("S101", "Ram");
        Teacher teacher1 = new Teacher("T201", "Shyam");
        Guest guest1 = new Guest("G301", "Hari");

        Book book1 = new Book("The Great Gatsby");
        Book book2 = new Book("To Kill a Mockingbird");

        try {
            System.out.println("--- Student ---");
            student1.borrowBook(book1);
            student1.borrowBook(book2);

            for (int i = 0; i < 4; i++) {
                student1.borrowBook(new Book("Student Book " + (i + 1)));
            }
        } catch (BorrowingLimitException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\n--- Teacher ---");
            teacher1.borrowBook(book1);
            teacher1.borrowBook(book2);
            for (int i = 0; i < 9; i++) {
                teacher1.borrowBook(new Book("Teacher Book " + (i + 1)));
            }
        } catch (BorrowingLimitException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\n--- Guest ---");
            guest1.borrowBook(book1);
            guest1.borrowBook(book2);
        } catch (BorrowingLimitException e) {
            System.out.println(e.getMessage());
        }
    }
}