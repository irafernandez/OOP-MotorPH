package OOP;

import GUI.ViewPortal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class Admin extends IT { // Extending IT 

    public Admin (String email, String password) {
        super(email, password, "Admin"); 
    }

    public void generateReport() {
        System.out.println("Generating company report...");
    }

    public void manageUsers() {
        System.out.println("Managing system users...");
    }

    public void viewEmployeeData(ViewPortal frame) {  // Use passed instance
        DefaultTableModel model = (DefaultTableModel) frame.viewEmployeeTable.getModel();

        try (BufferedReader br = new BufferedReader(new FileReader(EMPLOYEE_CSV))) { 
            String line;
            boolean isFirstRow = true;

            while ((line = br.readLine()) != null) {
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }
                String[] data = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                model.addRow(data); 
            }
        } catch (IOException e) {
            System.err.println("Error reading employee data: " + e.getMessage());
        }
    }
    
    
}
