package OOP;

public class User {
    private String userNumber;
    private String email;
    private String password;

    public User(String userNumber, String email, String password) {
        this.userNumber = userNumber;
        this.email = email;
        this.password = password;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}