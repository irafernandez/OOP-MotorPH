package OOP;

public class Employee extends User {
    private String employeeNumber, lastName, firstName, birthday, status, contactNumber, address;
    private double basicSalary, hourlyRate, riceSubsidy, phoneSubsidy, clothingAllowance;
    private String sssNumber, pagIbigNumber, philHealthNumber, tinNumber;

    // Constructor
    public Employee(String email, String password, String employeeNumber, String lastName, String firstName,
                    String birthday, String status, String contactNumber, String address, 
                    double basicSalary, double hourlyRate, double riceSubsidy, 
                    double phoneSubsidy, double clothingAllowance, 
                    String sssNumber, String pagIbigNumber, 
                    String philHealthNumber, String tinNumber) {
        super(email, password, "Employee");
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.status = status;
        this.contactNumber = contactNumber;
        this.address = address;
        this.basicSalary = basicSalary;
        this.hourlyRate = hourlyRate;
        this.riceSubsidy = riceSubsidy;
        this.phoneSubsidy = phoneSubsidy;
        this.clothingAllowance = clothingAllowance;
        this.sssNumber = sssNumber;
        this.pagIbigNumber = pagIbigNumber;
        this.philHealthNumber = philHealthNumber;
        this.tinNumber = tinNumber;
    }

    // Method to return employee details in a String array (Encapsulation respected)
    public String[] getDetails() {
        return new String[]{
            lastName, firstName, birthday, status, contactNumber, address,
            String.valueOf(basicSalary), String.valueOf(hourlyRate),
            String.valueOf(riceSubsidy), String.valueOf(phoneSubsidy), String.valueOf(clothingAllowance),
            sssNumber, pagIbigNumber, philHealthNumber, tinNumber
        };
    }
}
