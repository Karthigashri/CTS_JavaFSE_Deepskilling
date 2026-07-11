package Taskmanage;
import java.util.Scanner;

public class TaskManagement {

    Task head = null;

    Scanner sc = new Scanner(System.in);

    public void addTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Task Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Status: ");
        String status = sc.nextLine();

        Task newTask = new Task(id, name, status);

        if (head == null) {

            head = newTask;

        } else {

            Task temp = head;

            while (temp.next != null) {

                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task Added Successfully.");
    }

    public void searchTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id) {

                temp.display();
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    
    public void displayTasks() {

        if (head == null) {

            System.out.println("No Tasks Available.");
            return;
        }

        Task temp = head;

        while (temp != null) {

            temp.display();
            temp = temp.next;
        }
    }

    public void deleteTask() {

        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();

        if (head == null) {

            System.out.println("List is Empty.");
            return;
        }

        if (head.taskId == id) {

            head = head.next;
            System.out.println("Task Deleted.");
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {

            temp = temp.next;
        }

        if (temp.next == null) {

            System.out.println("Task Not Found.");

        } else {

            temp.next = temp.next.next;

            System.out.println("Task Deleted Successfully.");
        }
    }

    public static void main(String[] args) {

        TaskManagement tm = new TaskManagement();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n<-----TASK MANAGEMENT----->");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    tm.addTask();
                    break;

                case 2:
                    tm.searchTask();
                    break;

                case 3:
                    tm.displayTasks();
                    break;

                case 4:
                    tm.deleteTask();
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