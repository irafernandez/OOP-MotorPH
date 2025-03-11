package OOP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IT {
    private String csvFile;

    public IT(String csvFile) {
        this.csvFile = csvFile;
    }

    public List<User> readUsers() throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] userData = line.split(",");
            if (userData.length == 3) {
                users.add(new User(userData[0], userData[1], userData[2]));
            }
        }
        br.close();
        return users;
    }

    public boolean authenticateUser(String email, String password) throws IOException {
        List<User> users = readUsers();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
