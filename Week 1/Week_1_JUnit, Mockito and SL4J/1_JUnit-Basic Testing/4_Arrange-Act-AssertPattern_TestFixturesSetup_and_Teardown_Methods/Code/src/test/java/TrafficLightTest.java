import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrafficLightTest {

    private TrafficLight light;

    @Before
    public void setUp() {
        System.out.println("Setup: Creating TrafficLight object");
        light = new TrafficLight();
    }

    @After
    public void tearDown() {
        System.out.println("Teardown: Destroying TrafficLight object");
        light = null;
    }

    @Test
    public void testRedSignal() {

        int input = 1;

        String result = light.getSignal(input);

        assertEquals("RED", result);
    }

    @Test
    public void testGreenSignal() {

        // Arrange
        int input = 3;

        // Act
        String result = light.getSignal(input);

        // Assert
        assertEquals("GREEN", result);
    }
}