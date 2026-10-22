package LibraryManagementSystem;

public class LibraryAssistant extends LibraryStaff{
	private final String shiftType;
    private final double shiftAllowance;

    public LibraryAssistant(String personId, String name, String phoneNumber, String staffId, String department, double monthlySalary, String shiftType, double shiftAllowance) {
        super(personId, name, phoneNumber, staffId, department, monthlySalary);
        this.shiftType = shiftType;
        this.shiftAllowance = shiftAllowance;
    }

    @Override
    public double calculateMonthlyCompensation() {
        return getMonthlySalary() + shiftAllowance;
    }

    @Override
    public String getRoleDescription() {
        return "Library Assistant (Shift: " + shiftType + ")";
    }

    @Override
    public void generateReport() {
        System.out.println("[REPORT] Library Assistant " + name + " generated daily shelf maintenance log.");
    }

    @Override
    public void displayStaffDetails() {
        super.displayStaffDetails();
        System.out.println("Shift Type: " + shiftType + " | Shift Allowance: $" + shiftAllowance);
    }
}
