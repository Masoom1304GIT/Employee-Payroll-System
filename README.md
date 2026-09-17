# Employee Payroll System

A simple **command-line based Employee Payroll System** developed in Java.
The project allows users to add, view, search, delete employees, and generate employee payslips.

## Features

* Add new employee records
* Prevent duplicate Employee IDs
* View all employees
* Search employee by ID
* Generate employee payslip
* Calculate gross salary
* Calculate net salary
* Delete employee records
* Validate salary values
* Handle invalid menu input
* Runs completely through the command line

## Technologies Used

* **Java**
* **ArrayList** – for storing employee records
* **Scanner** – for taking user input
* **Object-Oriented Programming (OOP)** concepts

## Project Structure

```text
Employee-Payroll-System/
│
├── Main.java
└── README.md
```

## Employee Details

The system stores the following information for each employee:

* Employee ID
* Name
* Department
* Designation
* Basic Salary
* Allowances
* Deductions

## Salary Calculation

### Gross Salary

```text
Gross Salary = Basic Salary + Allowances
```

### Net Salary

```text
Net Salary = Gross Salary - Deductions
```

## How to Run

### 1. Install Java

Make sure Java JDK is installed on your computer.

Check the Java version using:

```bash
java -version
```

Check the Java compiler using:

```bash
javac -version
```

### 2. Compile the Program

Open a terminal in the project folder and run:

```bash
javac Main.java
```

### 3. Run the Program

After successful compilation, run:

```bash
java Main
```

## Main Menu

When the program starts, the following menu is displayed:

```text
========================================
       EMPLOYEE PAYROLL SYSTEM
========================================
1. Add Employee
2. View All Employees
3. Search Employee
4. Generate Payslip
5. Delete Employee
6. Exit
========================================
Enter your choice:
```

## Example

After adding an employee, the system can generate a payslip similar to:

```text
========================================
              EMPLOYEE PAYSLIP
========================================
Employee ID  : 101
Name         : Rahul
Department   : IT
Designation  : Software Developer
----------------------------------------
Basic Salary : 30000.00
Allowances   : 5000.00
Gross Salary : 35000.00
Deductions   : 2000.00
----------------------------------------
Net Salary   : 33000.00
========================================
```

## Input Validation

The program includes basic validation:

* Employee IDs must be unique.
* Salary values cannot be negative.
* Invalid menu input is handled using exception handling.
* The program displays an error message when an employee ID is not found.

## OOP Concepts Used

This project demonstrates several Java programming concepts:

* **Class and Objects** – `Employee` class represents employee information.
* **Encapsulation** – employee data and related methods are grouped inside the `Employee` class.
* **Methods** – separate methods are used for adding, searching, displaying, deleting, and generating payslips.
* **Constructor** – initializes employee information when an object is created.
* **ArrayList** – stores multiple employee objects.
* **Exception Handling** – handles invalid user input using `try-catch`.
* **Loops and Conditional Statements** – used for menu operations and employee searching.

## Limitations

* Employee data is stored only in memory.
* Data is lost when the program is closed.
* The project does not use a database or file storage.
* It is designed as a command-line application.

## Future Enhancements

The project can be improved by adding:

* File-based data storage
* Database connectivity using JDBC
* Employee update functionality
* Payroll history
* Employee login/authentication
* Monthly salary reports
* Tax and bonus calculations
* Graphical user interface

## Author

**Masoom Ali**

B.Tech CSE (AI/ML)
VIT Bhopal University

## License

This project is created for educational and academic purposes.
