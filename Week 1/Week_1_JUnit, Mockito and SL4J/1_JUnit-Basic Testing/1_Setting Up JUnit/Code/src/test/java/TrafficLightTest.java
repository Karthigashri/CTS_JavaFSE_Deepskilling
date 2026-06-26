import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TrafficLightTest {
    @Test
    public void testRedSignal() {
        TrafficLight light = new TrafficLight();
        assertEquals("RED", light.getSignal(1));
    }

    @Test
    public void testYellowSignal() {
        TrafficLight light = new TrafficLight();
        assertEquals("YELLOW", light.getSignal(2));
    }

    @Test
    public void testGreenSignal() {
        TrafficLight light = new TrafficLight();
        assertEquals("GREEN", light.getSignal(3));
    }

    @Test
    public void testInvalidSignal() {
        TrafficLight light = new TrafficLight();
        assertEquals("INVALID", light.getSignal(5));
    }
}
