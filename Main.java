import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Employee class
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

    // List of employees
    static ArrayList<Employee> employees = new ArrayList<>();

    // Find employee by ID
    static Employee findEmployee(int id) {

        for (Employee employee : employees) {
            if (employee.id == id) {
                return employee;
            }
        }

        return null;
    }

    // Add employee
    static void addEmployee(Scanner scanner) {

        System.out.println("\n========== ADD EMPLOYEE ==========");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (findEmployee(id) != null) {
            System.out.println("Employee ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();

        System.out.print("Enter Allowances: ");
        double allowances = scanner.nextDouble();

        System.out.print("Enter Deductions: ");
        double deductions = scanner.nextDouble();

        if (basicSalary < 0 || allowances < 0 || deductions < 0) {
            System.out.println("Salary values cannot be negative.");
            return;
        }

        Employee employee = new Employee(
                id,
                name,
                department,
                designation,
                basicSalary,
                allowances,
                deductions
        );

        employees.add(employee);

        System.out.println("Employee added successfully.");
    }

    // Display all employees
    static void viewEmployees() {

        System.out.println("\n========== EMPLOYEE LIST ==========");

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            employee.display();
        }
    }

    // Search employee
    static void searchEmployee(Scanner scanner) {

        System.out.println("\n========== SEARCH EMPLOYEE ==========");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            employee.display();
        }
    }

    // Generate payslip
    static void generatePayslip(Scanner scanner) {

        System.out.println("\n========== GENERATE PAYSLIP ==========");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("              EMPLOYEE PAYSLIP");
        System.out.println("========================================");
        System.out.println("Employee ID  : " + employee.id);
        System.out.println("Name         : " + employee.name);
        System.out.println("Department   : " + employee.department);
        System.out.println("Designation  : " + employee.designation);
        System.out.println("----------------------------------------");
        System.out.printf("Basic Salary : %.2f%n", employee.basicSalary);
        System.out.printf("Allowances   : %.2f%n", employee.allowances);
        System.out.printf("Gross Salary : %.2f%n", employee.grossSalary());
        System.out.printf("Deductions   : %.2f%n", employee.deductions);
        System.out.println("----------------------------------------");
        System.out.printf("Net Salary   : %.2f%n", employee.netSalary());
        System.out.println("========================================");
    }

    // Delete employee
    static void deleteEmployee(Scanner scanner) {

        System.out.println("\n========== DELETE EMPLOYEE ==========");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        Employee employee = findEmployee(id);

        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            employees.remove(employee);
            System.out.println("Employee deleted successfully.");
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

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

                choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        addEmployee(scanner);
                        break;

                    case 2:
                        viewEmployees();
                        break;

                    case 3:
                        searchEmployee(scanner);
                        break;

                    case 4:
                        generatePayslip(scanner);
                        break;

                    case 5:
                        deleteEmployee(scanner);
                        break;

                    case 6:
                        System.out.println(
                            "Thank you for using Employee Payroll System!"
                        );
                        break;

                    default:
                        System.out.println(
                            "Invalid choice. Please try again."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                    "Invalid input. Please enter a valid value."
                );

                scanner.nextLine();
                choice = 0;
            }

        } while (choice != 6);

        scanner.close();
    }
}
