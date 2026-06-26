import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testVoidMethod() {

        //Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        //Stub the void method
        doNothing().when(mockApi).deleteData();

        //Create service
        MyService service = new MyService(mockApi);

        //Call the method
        service.removeData();

        //Verify interaction
        verify(mockApi).deleteData();
    }
}