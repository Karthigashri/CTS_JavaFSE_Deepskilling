import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testVoidMethodException() {

        //Create Mock
        ExternalApi mockApi = mock(ExternalApi.class);

        //Stub exception
        doThrow(new RuntimeException("Delete Failed"))
                .when(mockApi)
                .deleteData();

        //Create Service
        MyService service = new MyService(mockApi);

        //Verify exception
        assertThrows(RuntimeException.class,
                () -> service.removeData());

        //Verify interaction
        verify(mockApi).deleteData();

    }
}