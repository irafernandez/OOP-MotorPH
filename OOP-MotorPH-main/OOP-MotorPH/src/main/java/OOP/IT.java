package OOP;

import GUI.*;
import javax.swing.*;
import java.io.*;

public class IT extends User {
        public IT(String email, String password, String role) {
            super(email, password, role);
    }
    
    //This won't be changed since it's final :)
    static final String EMPLOYEE_CSV = "C:\\Users\\vvele\\Downloads\\OOP-MotorPH\\OOP-MotorPH-main\\OOP-MotorPH\\src\\main\\java\\CSV\\EmpData.csv";
    private static final String ADMIN_CSV = "C:\\Users\\vvele\\Downloads\\OOP-MotorPH\\OOP-MotorPH-main\\OOP-MotorPH\\src\\main\\java\\CSV\\AdminLogin.csv";
    private static final String HR_CSV = "C:\\Users\\vvele\\Downloads\\OOP-MotorPH\\OOP-MotorPH-main\\OOP-MotorPH\\src\\main\\java\\CSV\\HRLogin.csv";
    private static final String FINANCE_CSV = "C:\\Users\\vvele\\Downloads\\OOP-MotorPH\\OOP-MotorPH-main\\OOP-MotorPH\\src\\main\\java\\CSV\\FinanceLogin.csv";

    
    //Method for redirecting the users to their designated GUI frame
    public static void validateLogin(String email, String password, JFrame loginFrame) {
        if (checkCredentials(ADMIN_CSV, email, password)) {
            redirectToPortal(new Admin(email, password), new AdminPortal(), "Admin", loginFrame);
        } else if (checkCredentials(HR_CSV, email, password)) {
            redirectToPortal(new HR(email, password), new HRPortal(), "HR", loginFrame);
        } else if (checkCredentials(FINANCE_CSV, email, password)) {
            redirectToPortal(new Finance(email, password), new FinancePortal(), "Finance", loginFrame);
        } else {
            Employee employee = getEmployeeDetails(email, password);
            if (employee != null) {
                showEmployeePortal(employee, loginFrame);
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed! Incorrect email or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static boolean checkCredentials(String filePath, String email, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true; //Skip the header from the csv :D
            while ((line = br.readLine()) != null) {
                if (isFirstLine) { 
                    isFirstLine = false; 
                    continue; 
                }
                String[] values = line.split(","); 
                if (values.length > 1 && values[0].trim().equals(email) && values[1].trim().equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static Employee getEmployeeDetails(String email, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(EMPLOYEE_CSV))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) { 
                    isFirstLine = false; 
                    continue; 
                }

                // Parsing with handling for commas inside quotes
                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                // Trim and clean values
                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].replaceAll("^\"|\"$", "").trim(); // Remove quotes
                }

                if (values.length > 20 && values[19].equals(email) && values[20].equals(password)) {
                    try {
                        return new Employee(
                            values[19], values[20],
                            values[0], values[1], values[2], values[7], values[10],
                            values[9], values[8], 
                            Double.parseDouble(values[13].replace(",", "")),  // Handle "60,000"
                            Double.parseDouble(values[18].replace(",", "")),  
                            Double.parseDouble(values[14].replace(",", "")),  
                            Double.parseDouble(values[15].replace(",", "")),  
                            Double.parseDouble(values[16].replace(",", "")),  
                            values[3], values[6], values[4], values[5]
                        );
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing numeric values in CSV: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void redirectToPortal(User user, JFrame portal, String role, JFrame loginFrame) {
        JOptionPane.showMessageDialog(null, "Successfully Logged In as " + role + "!");
        portal.setVisible(true);
        loginFrame.dispose();
    }
    //showing the employee portal if the entered email and password are from employee csv
    private static void showEmployeePortal(Employee employee, JFrame loginFrame) {
        EmployeePortal frame = new EmployeePortal();
        frame.fillEmployeeDetails(employee);
        redirectToPortal(employee, frame, "Employee", loginFrame);
    }
}

