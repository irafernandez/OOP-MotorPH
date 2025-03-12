package OOP;

public class HR extends User {
    public HR(String email, String password) {
        super(email, password, "HR");
    }

    public void approveLeave(String employeeID) {
        //input
    }

    public void rejectLeave(String employeeID) {
        System.out.println("Leave rejected for Employee ID: " + employeeID);
    }
}

