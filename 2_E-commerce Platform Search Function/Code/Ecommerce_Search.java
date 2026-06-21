import java.util.Scanner;

public class Ecommerce_Search {

    // Linear Search
    public static Product1 linearSearch(Product1[] pdt, String target) {

        for (Product1 p : pdt) {

            if (p.productName.equalsIgnoreCase(target)) {
                return p;
            }
        }

        return null;
    }
    // Binary Search
    public static Product1 binarySearch(Product1[] prd, String target) {

        int low = 0;
        int high = prd.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result =
                    prd[mid].productName
                    .compareToIgnoreCase(target);

            if (result == 0) {
                return prd[mid];
            }

            else if (result < 0) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Sorted Array for Binary Search
        try (Scanner sc = new Scanner(System.in)) {
            // Sorted Array for Binary Search
            Product1[] pdts = {
                
                new Product1(1, "Apple", "Fruits"),
                new Product1(2, "Banana", "Fruits"),
                new Product1(3, "Blue Berry", "Fruits"),
                new Product1(4, "Goa", "Fruits"),
                new Product1(5, "Jack Fruit", "Fruits")
            };
            
            int choice;
            
            do {
                
                System.out.println("\n====== E-COMMERCE SEARCH ======");
                System.out.println("1. Linear Search");
                System.out.println("2. Binary Search");
                System.out.println("3. Display Products");
                System.out.println("4. Exit");
                System.out.print("Enter Choice: ");
                
                choice = sc.nextInt();
                sc.nextLine();
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter Product Name: ");
                        String linearTarget = sc.nextLine();
                        Product1 linearResult =
                                linearSearch(pdts, linearTarget);
                        
                        if (linearResult != null) {
                            
                            System.out.println("\nProduct Found:");
                            linearResult.display();
                            
                        } else {
                            
                            System.out.println("Product Not Found");
                        }
                        
                        break;
                        
                    case 2:
                        
                        System.out.print("Enter Product Name: ");
                        String binaryTarget = sc.nextLine();
                        
                        Product1 binaryResult =
                                binarySearch(pdts, binaryTarget);
                        
                        if (binaryResult != null) {
                            
                            System.out.println("\nProduct Found:");
                            binaryResult.display();
                            
                        } else {
                            
                            System.out.println("Product Not Found");
                        }
                        
                        break;
                        
                    case 3:
                        
                        System.out.println("\nAvailable Products:");
                        
                        for (Product1 p : pdts) {
                            p.display();
                        }
                        
                        break;
                        
                    case 4:
                        
                        System.out.println("Exiting...");
                        break;
                        
                    default:
                        
                        System.out.println("Invalid Choice");
                }
                
            } while (choice != 4);
        }
    }
}