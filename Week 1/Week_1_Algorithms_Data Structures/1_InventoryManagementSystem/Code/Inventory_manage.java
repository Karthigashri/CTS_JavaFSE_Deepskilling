
import java.util.HashMap;
import java.util.Scanner;

public class Inventory_manage {
    HashMap<String, Product> inventory = new HashMap<>();

    void addProduct(Scanner sc) {
        System.out.println("Enter Product ID: ");
        String id = sc.nextLine();
        if (inventory.containsKey(id)) {
            System.out.println("Product with this ID already exists.\n");
            return;
        }
        System.out.println("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Quantity: ");
        int quant = sc.nextInt();
        System.out.println("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        Product p = new Product(id, name, quant, price);
        inventory.put(id, p);
        System.out.println("Product added successfully.");
    }

    void updateProduct(Scanner sc) {
        System.out.print("Enter Product ID to update: ");
        String id = sc.nextLine();
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            System.out.print("Enter Name: ");
            p.setProductName(sc.nextLine());
            System.out.print("Enter New Quantity: ");
            p.setQuantity(sc.nextInt());
            System.out.print("Enter New Price: ");
            p.setPrice(sc.nextDouble());
            sc.nextLine();
            System.out.println("Product updated.\n");
        } else {
            System.out.println("Product not found.\n");
        }
    }

    void deleteProduct(Scanner sc) {
        System.out.print("Enter Product ID to delete: ");
        String id = sc.nextLine();
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted.\n");
        } else {
            System.out.println("Product not found.\n");
        }
    }

    void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.\n");
        } else {
            System.out.println("Inventory List:");
            for (Product p : inventory.values()) {
                p.display();
            }
        }
    }
	public static void main(String[] args) {
		Inventory_manage system = new Inventory_manage();
        int choose;
        try (Scanner menu = new Scanner(System.in)) {
            do {
                System.out.println("Inventory Menu");
                System.out.println("1. Add Product");
                System.out.println("2. Update Product");
                System.out.println("3. Delete Product");
                System.out.println("4. Show All Products");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                while (!menu.hasNextInt()) {
                    System.out.println("Enter a valid number:");
                    menu.next(); 
                }
                choose = menu.nextInt();
                menu.nextLine(); 
                switch (choose) {
                    case 1 -> system.addProduct(menu);
                    case 2 -> system.updateProduct(menu);
                    case 3 -> system.deleteProduct(menu);
                    case 4 -> system.showInventory();
                    case 5 -> System.out.println("Exiting system.");
                    default -> System.out.println("Invalid choice.\n");
                }
            } while (choose != 5);
        }
    }
}


