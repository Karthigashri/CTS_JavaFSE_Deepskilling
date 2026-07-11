package SortingOrders;
import java.util.Scanner;

public class OrderSorting {

    // Display Orders
    public static void displayOrders(Order[] orders) {

        for (Order order : orders) {
            order.display();
        }
    }

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {

        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice > orders[j + 1].totalPrice) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;

                }
            }
        }

        System.out.println("\nOrders Sorted using Bubble Sort.");
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);

            quickSort(orders, pivotIndex + 1, high);
        }
    }

    // Partition Method
    public static int partition(Order[] orders, int low, int high) {

        double pivot = orders[high].totalPrice;

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice <= pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Order[] orders = {

                new Order(101, "Rahul", 2500),

                new Order(102, "Anu", 8000),

                new Order(103, "Karthik", 3500),

                new Order(104, "Priya", 1500),

                new Order(105, "Ravi", 10000)

        };

        int choice;

        do {

            System.out.println("\n===== ORDER SORTING MENU =====");
            System.out.println("1. Display Orders");
            System.out.println("2. Bubble Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Exit");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    displayOrders(orders);
                    break;

                case 2:

                    bubbleSort(orders);

                    displayOrders(orders);

                    break;

                case 3:

                    quickSort(orders, 0, orders.length - 1);

                    System.out.println("\nOrders Sorted using Quick Sort.");

                    displayOrders(orders);

                    break;

                case 4:

                    System.out.println("Exiting...");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}