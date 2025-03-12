package OOP;

public class Admin extends User {
    public Admin(String email, String password) {
        super(email, password, "Admin");
    }

    public void generateReport() {
        System.out.println("Generating company report...");
    }

    public void manageUsers() {
        System.out.println("Managing system users...");
    }
}
