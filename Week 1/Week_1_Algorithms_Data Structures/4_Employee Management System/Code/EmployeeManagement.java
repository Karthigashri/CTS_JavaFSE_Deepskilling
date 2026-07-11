package ems;
import java.util.Scanner;

public class EmployeeManagement {

    static Employee[] employees = new Employee[10];
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    
    public static void addEmployee() {

        if (count == employees.length) {

            System.out.println("Employee Array is Full.");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Position: ");
        String position = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        employees[count] = new Employee(id, name, position, salary);

        count++;

        System.out.println("Employee Added Successfully.");
    }

    public static void searchEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                employees[i].display();
                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("Employee Not Found.");
        }
    }

    public static void displayEmployees() {

        if (count == 0) {

            System.out.println("No Employees Found.");
            return;
        }

        for (int i = 0; i < count; i++) {

            employees[i].display();
        }
    }

    public static void deleteEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                index = i;
                break;
            }
        }

        if (index == -1) {

            System.out.println("Employee Not Found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {

            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;

        count--;

        System.out.println("Employee Deleted Successfully.");
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    searchEmployee();
                    break;

                case 3:
                    displayEmployees();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}