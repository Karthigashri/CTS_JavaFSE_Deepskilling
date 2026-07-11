package SortingOrders;
public class Order {

    int orderId;
    String customerName;
    double totalPrice;

    // Constructor
    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Display Order Details
    public void display() {
        System.out.println("Order ID      : " + orderId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Total Price   : ₹" + totalPrice);
        System.out.println("------------------------------");
    }
}