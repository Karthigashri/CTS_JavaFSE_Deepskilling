public class TrafficLight {

    public String getSignal(int choice) {

        if (choice == 1)
            return "RED";
        else if (choice == 2)
            return "YELLOW";
        else if (choice == 3)
            return "GREEN";
        else
            return "INVALID";
    }
}