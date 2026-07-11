package Library;
import java.util.Scanner;

public class LibraryManage {


  
    public static Book linearSearch(Book[] books, String target) {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(target)) {

                return book;
            }
        }

        return null;
    }

   
    public static Book binarySearch(Book[] books, String target) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result =
                    books[mid].title.compareToIgnoreCase(target);

            if (result == 0) {

                return books[mid];
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

        Scanner sc = new Scanner(System.in);

        Book[] books = {

                new Book(101, "Algorithms", "Thomas"),
                new Book(102, "Clean Code", "Robert"),
                new Book(103, "Data Structures", "Seymour Lipschutz"),
                new Book(104, "Java Programming", "Hema"),
                new Book(105, "Operating Systems", "Guru")

        };

        int choice;

        do {

            System.out.println("\n<<--- LIBRARY MANAGEMENT --->>");
            System.out.println("1. Display Books");
            System.out.println("2. Linear Search");
            System.out.println("3. Binary Search");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    for (Book b : books) {

                        b.display();
                    }

                    break;

                case 2:

                    System.out.print("Enter Book Title: ");

                    String linearTitle = sc.nextLine();

                    Book linearBook =
                            linearSearch(books, linearTitle);

                    if (linearBook != null) {

                        System.out.println("\nBook Found:");
                        linearBook.display();

                    } else {

                        System.out.println("Book Not Found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Book Title: ");

                    String binaryTitle = sc.nextLine();

                    Book binaryBook =
                            binarySearch(books, binaryTitle);

                    if (binaryBook != null) {

                        System.out.println("\nBook Found:");
                        binaryBook.display();

                    } else {

                        System.out.println("Book Not Found.");
                    }

                    break;

                case 4:

                    System.out.println("Exiting...");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 4);

        sc.close();
    
}}
