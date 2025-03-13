package OOP;

public class Finance extends User {
    public Finance(String email, String password) {
        super(email, password, "Finance");
    }


    public void processPayroll() {
        System.out.println("Processing payroll...");
    }

    public void generatePayslips() {
        System.out.println("Generating payslips...");
    }
}





