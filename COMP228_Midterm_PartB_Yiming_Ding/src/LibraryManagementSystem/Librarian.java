package LibraryManagementSystem;

public class Librarian extends LibraryStaff{
	protected final int dailyIssueLimit;
    protected final int booksProcessed;

    public Librarian(String personId, String name, String phoneNumber, String staffId, String department, double monthlySalary, int dailyIssueLimit, int booksProcessed) {
        super(personId, name, phoneNumber, staffId, department, monthlySalary);
        this.dailyIssueLimit = dailyIssueLimit;
        this.booksProcessed = booksProcessed;
    }

    @Override
    public double calculateMonthlyCompensation() {
        
        double processingAllowance = booksProcessed * 2.00;
        return getMonthlySalary() + processingAllowance;
    }

    
    public double calculateLateFee(int daysOverdue) {
        if (daysOverdue < 0) throw new IllegalArgumentException("Negative days not allowed.");
        return daysOverdue * 1.00;
    }

    public double calculateLateFee(int daysOverdue, double customRate) {
        if (daysOverdue < 0 || customRate < 0) throw new IllegalArgumentException("Invalid parameters.");
        return daysOverdue * customRate;
    }

    @Override
    public String getRoleDescription() {
        return "Librarian (Processing Capacity: " + dailyIssueLimit + " books/day)";
    }

    @Override
    public void generateReport() {
        System.out.println("[REPORT] Librarian " + name + " generated monthly circulation processing report.");
    }

    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.println("Daily Issue Limit: " + dailyIssueLimit + " | Books Processed: " + booksProcessed);
    }
}
