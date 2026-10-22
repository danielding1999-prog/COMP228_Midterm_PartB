package LibraryManagementSystem;

public abstract class LibraryStaff extends Person implements Reportable{
protected static int staffCount = 0;
    
    protected final String staffId;
    protected final String department;
    protected final double monthlySalary;

    public LibraryStaff(String personId, String name, String phoneNumber, String staffId, String department, double monthlySalary) {
        super(personId, name, phoneNumber);
        if (monthlySalary < 0) {
            throw new IllegalArgumentException("Monthly salary cannot be negative.");
        }
        this.staffId = staffId;
        this.department = department;
        this.monthlySalary = monthlySalary;
        staffCount++;
    }

    public static int getStaffCount() {
        return staffCount;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getDepartment() {
        return department;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public abstract double calculateMonthlyCompensation();

    public void displayStaffDetails() {
        displayBasicDetails();
        System.out.println("Staff ID: " + staffId + " | Dept: " + department + " | Base Salary: $" + monthlySalary);
    }
}
