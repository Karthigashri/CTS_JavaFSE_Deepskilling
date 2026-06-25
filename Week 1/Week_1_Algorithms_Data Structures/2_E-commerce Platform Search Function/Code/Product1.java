public class Product1 {

    int productId;
    String productName;
    String category;

    public Product1(int productId, String productName, String categ) {
        this.productId = productId;
        this.productName = productName;
        this.category = categ;
    }
    // Display Product Details
    public void display() {
        System.out.println("Product ID : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Category : " + category);
    }
}