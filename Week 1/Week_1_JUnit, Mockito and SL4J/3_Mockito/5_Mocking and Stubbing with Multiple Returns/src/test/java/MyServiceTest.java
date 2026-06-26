import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testMultipleReturns() {

        //Create Mock
        ExternalApi mockApi = mock(ExternalApi.class);

        //Stub multiple return values
        when(mockApi.getData())
                .thenReturn("Data1")
                .thenReturn("Data2")
                .thenReturn("Data3");

        //Inject Mock
        MyService service = new MyService(mockApi);

        //Call method multiple times
        String result1 = service.fetchData();
        String result2 = service.fetchData();
        String result3 = service.fetchData();

        //Verify results
        assertEquals("Data1", result1);
        assertEquals("Data2", result2);
        assertEquals("Data3", result3);

        //Verify interaction
        verify(mockApi, times(3)).getData();
    }
}