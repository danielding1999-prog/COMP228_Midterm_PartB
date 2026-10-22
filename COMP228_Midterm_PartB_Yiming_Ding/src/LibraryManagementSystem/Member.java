package LibraryManagementSystem;
import Book.Book;

public class Member extends Person implements Reservable {
    private static int memberCount = 0;
    
    private final String memberNumber;
    private final int age;
    private final String membershipType;
    private double outstandingFees;

    
    public Member(String personId, String name, String phoneNumber, String memberNumber, int age, String membershipType) {
        super(personId, name, phoneNumber);
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age provided for member: " + name);
        }
        if (memberNumber == null || memberNumber.isBlank()) {
            throw new IllegalArgumentException("Member number cannot be blank.");
        }
        this.memberNumber = memberNumber;
        this.age = age;
        this.membershipType = membershipType;
        this.outstandingFees = 0.0;
        memberCount++;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    
    public void registerMember() {
        System.out.println("[SUCCESS] Member " + name + " registered successfully with standard profile.");
    }

    public void registerMember(String customType, double initialFee) {
        if (initialFee < 0) {
            throw new IllegalArgumentException("Initial fee cannot be negative.");
        }
        this.outstandingFees += initialFee;
        System.out.println("[SUCCESS] Member " + name + " registered with custom type [" + customType + "] and initial fee: $" + initialFee);
    }

    public double calculateLateFee(int daysOverdue) {
        if (daysOverdue < 0) {
            throw new IllegalArgumentException("Days overdue cannot be negative.");
        }
        double defaultRate = 1.00; // $1.00 per overdue day rule
        return daysOverdue * defaultRate;
    }

    public double calculateLateFee(int daysOverdue, double dailyRate) {
        if (daysOverdue < 0 || dailyRate < 0) {
            throw new IllegalArgumentException("Days overdue and daily rate must be non-negative.");
        }
        return daysOverdue * dailyRate;
    }

    public void addFee(double fee) {
        if (fee > 0) {
            this.outstandingFees += fee;
        }
    }

    public double getOutstandingFees() {
        return outstandingFees;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public int getAge() {
        return age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    @Override
    public String getRoleDescription() {
        return "Library Member " + membershipType ;
    }

    @Override
    public void reserveBook(Book book) {
    	if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("[RESERVATION] Book '" + book.getTitle() + "' is available. Member " + name + " successfully reserved it.");
        } else {
            System.out.println("[UNSUCCESSFUL] Book '" + book.getTitle() + "' is not available for reservation.");
        }
    }
}