import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {

        //Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        //Create service
        MyService service = new MyService(mockApi);

        //Call method
        service.fetchData(100);

        //Verify argument
        verify(mockApi).getData(eq(100));
    }
}