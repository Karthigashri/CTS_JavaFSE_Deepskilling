import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class MyServiceTest {

    @Test
    public void testInteractionOrder() {

        //Create Mock
        ExternalApi mockApi = mock(ExternalApi.class);

        //Create Service
        MyService service = new MyService(mockApi);

        //Call method
        service.processData();

        //Create InOrder object
        InOrder inOrder = inOrder(mockApi);

        //Verify order
        inOrder.verify(mockApi).connect();
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).disconnect();

    }
}