import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Employee {
        int id;
        String name;
        String department;
        String designation;
        double basicSalary;
        double allowances;
        double deductions;

        Employee(int id, String name, String department, String designation,
                 double basicSalary, double allowances, double deductions) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.designation = designation;
            this.basicSalary = basicSalary;
            this.allowances = allowances;
            this.deductions = deductions;
        }

        double grossSalary() {
            return basicSalary + allowances;
        }

        double netSalary() {
            return grossSalary() - deductions;
        }

        void display() {
            System.out.println("----------------------------------------");
            System.out.println("Employee ID  : " + id);
            System.out.println("Name         : " + name);
            System.out.println("Department   : " + department);
            System.out.println("Designation  : " + designation);
            System.out.printf("Basic Salary : %.2f%n", basicSalary);
            System.out.printf("Allowances   : %.2f%n", allowances);
            System.out.printf("Deductions   : %.2f%n", deductions);
            System.out.printf("Gross Salary : %.2f%n", grossSalary());
            System.out.printf("Net Salary   : %.2f%n", netSalary());
            System.out.println("----------------------------------------");
        }
    }

    static ArrayList<Employee> employees = new ArrayList<>();

    // returns null if nobody has that id
    static Employee findEmployee(int id) {
        for (Employee e : employees) {
            if (e.id == id) return e;
        }
        return null;
    }

    static void addEmployee(Scanner sc) {
        System.out.println("\n========== ADD EMPLOYEE ==========");
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findEmployee(id) != null) {
            System.out.println("That ID is already taken.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();
        System.out.print("Enter Allowances: ");
        double allowances = sc.nextDouble();
        System.out.print("Enter Deductions: ");
        double deductions = sc.nextDouble();

        if (basic < 0 || allowances < 0 || deductions < 0) {
            System.out.println("Salary fields can't be negative, try again.");
            return;
        }

        employees.add(new Employee(id, name, dept, designation, basic, allowances, deductions));
        System.out.println("Employee added.");
    }

    static void viewEmployees() {
        System.out.println("\n========== EMPLOYEE LIST ==========");

        if (employees.isEmpty()) {
            System.out.println("Nothing to show yet - no employees on file.");
            return;
        }

        for (Employee e : employees) {
            e.display();
        }
    }

    static void searchEmployee(Scanner sc) {
        System.out.println("\n========== SEARCH EMPLOYEE ==========");
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);
        if (e == null) {
            System.out.println("No employee with that ID.");
        } else {
            e.display();
        }
    }

    static void generatePayslip(Scanner sc) {
        System.out.println("\n========== GENERATE PAYSLIP ==========");
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);
        if (e == null) {
            System.out.println("No employee with that ID.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("              EMPLOYEE PAYSLIP");
        System.out.println("========================================");
        System.out.println("Employee ID  : " + e.id);
        System.out.println("Name         : " + e.name);
        System.out.println("Department   : " + e.department);
        System.out.println("Designation  : " + e.designation);
        System.out.println("----------------------------------------");
        System.out.printf("Basic Salary : %.2f%n", e.basicSalary);
        System.out.printf("Allowances   : %.2f%n", e.allowances);
        System.out.printf("Gross Salary : %.2f%n", e.grossSalary());
        System.out.printf("Deductions   : %.2f%n", e.deductions);
        System.out.println("----------------------------------------");
        System.out.printf("Net Salary   : %.2f%n", e.netSalary());
        System.out.println("========================================");
    }

    static void deleteEmployee(Scanner sc) {
        System.out.println("\n========== DELETE EMPLOYEE ==========");
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);
        if (e == null) {
            System.out.println("No employee with that ID.");
        } else {
            employees.remove(e);
            System.out.println("Employee removed.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("       EMPLOYEE PAYROLL SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Generate Payslip");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addEmployee(sc);
                    case 2 -> viewEmployees();
                    case 3 -> searchEmployee(sc);
                    case 4 -> generatePayslip(sc);
                    case 5 -> deleteEmployee(sc);
                    case 6 -> System.out.println("Thanks for using the Employee Payroll System!");
                    default -> System.out.println("Not a valid option, try again.");
                }

            } catch (Exception e) {
                System.out.println("That input doesn't look right - please try again.");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 6);

        sc.close();
    }
}
