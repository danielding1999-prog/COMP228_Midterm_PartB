package LibraryManagementSystem;

public class SeniorLibrarian extends Librarian {
    private final String specialization;
    private final double seniorityAllowance;

    public SeniorLibrarian(String personId, String name, String phoneNumber, String staffId, String department, double monthlySalary, int dailyIssueLimit, int booksProcessed, String specialization, double seniorityAllowance) {
        super(personId, name, phoneNumber, staffId, department, monthlySalary, dailyIssueLimit, booksProcessed);
        this.specialization = specialization;
        this.seniorityAllowance = seniorityAllowance;
    }

    @Override
    public double calculateMonthlyCompensation() {
        double baseCompensation = super.calculateMonthlyCompensation();
        return baseCompensation + seniorityAllowance;
    }

    @Override
    public String getRoleDescription() {
        return "Senior Librarian [Specialization: " + specialization + "]";
    }

    @Override
    public void generateReport() {
        System.out.println("[REPORT] Senior Librarian " + name + " generated comprehensive senior audit & departmental report.");
    }

    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.println("Specialization: " + specialization + " | Seniority Allowance: $" + seniorityAllowance);
    }
}
