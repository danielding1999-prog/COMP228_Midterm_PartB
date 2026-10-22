package DriverMain;
import LibraryManagementSystem.*;
import java.util.ArrayList;
import Book.Book;

public class DriverMain {

	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();
        ArrayList<Book> bookCatalog = new ArrayList<>();

        Book b1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book b2 = new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman");
        bookCatalog.add(b1);
        bookCatalog.add(b2);

        try {
            Member member1 = new Member("P001", "Alice Smith", "416-555-0192", "M-1001", 25, "Standard");
            Member member2 = new Member("P002", "Bob Jones", "647-555-8391", "M-1002", 30, "Premium");

            member1.registerMember();
            member2.registerMember("Premium", 15.0);

            Librarian librarian = new Librarian("P003", "Charlie Brown", "905-555-4920", "S-2001", "Circulation", 3200.0, 50, 150);
            SeniorLibrarian seniorLibrarian = new SeniorLibrarian("P004", "Diana Prince", "416-555-7382", "S-2002", "Acquisitions", 4800.0, 100, 220, "Rare Manuscripts", 600.0);
            LibraryAssistant assistant = new LibraryAssistant("P005", "Evan Wright", "647-555-1129", "S-2003", "Shelving & Maintenance", 2400.0, "Evening Shift", 300.0);

            people.add(member1);
            people.add(member2);
            people.add(librarian);
            people.add(seniorLibrarian);
            people.add(assistant);

            System.out.println("=== COUNTERS ===");
            System.out.println("Total Persons: " + Person.getPersonCount());
            System.out.println("Total Members: " + Member.getMemberCount());
            System.out.println("Total Staff: " + LibraryStaff.getStaffCount());

            System.out.println("\n=== MEMBER AND STAFF DETAILS ===");
            for (Person p : people) {
                System.out.println("--------------------------------------------------");
                p.displayBasicDetails();
                System.out.println("Role Description: " + p.getRoleDescription());
                }

            System.out.println("\n=== COMPILETIME POLYMORPHISM(OVERLOADED) LATE FEES ===");
            System.out.println("Member 1 Late Fee (7 days): $" + member1.calculateLateFee(7));
            System.out.println("Member 2 Late Fee (4 days, $2.50/day): $" + member2.calculateLateFee(4, 2.50));

            System.out.println("\n=== RUNTIME POLYMORPHISM(Overriding) & REPORTS ===");
            for (Person p : people) {
                if (p instanceof Reportable) {
                    ((Reportable) p).generateReport();
                }
            }

            System.out.println("\n=== BOOK RESERVATION DEMO ===");
            Book targetBook = bookCatalog.get(0);
            System.out.println("Attempting reservation for: " + targetBook.getTitle());
            member1.reserveBook(targetBook);

            System.out.println("\nAttempting duplicate reservation for: " + targetBook.getTitle());
            member2.reserveBook(targetBook);

        } catch (IllegalArgumentException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }
    }
	

}


