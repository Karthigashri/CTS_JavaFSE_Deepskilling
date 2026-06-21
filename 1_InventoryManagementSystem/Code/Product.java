
public class Product {
	private final String productId;	//instance variable
	private String productName;
	private int quantity;
	private double price;
	
	public Product(String productId,String productName,int quantity, double price) {
	this.productId=productId;//instance_variable as parameter 
	this.productName=productName;
	this.quantity=quantity;
	this.price=price;
}
	//setters to modify private field
	public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
	 public void display() {
	        System.out.println("---------Inventory Management System------------");
	        System.out.println("Product ID: " + productId);
	        System.out.println("Name: " + productName);
	        System.out.println("Quantity: " + quantity);
	        System.out.println("Price: " + price);
	    }
 
}

