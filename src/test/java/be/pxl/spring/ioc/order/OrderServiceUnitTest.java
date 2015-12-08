package be.pxl.spring.ioc.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceUnitTest {

//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderDAO orderDAOMock;

    @Test
    public void createOrder_PersistsAnOrder() throws Exception {
        orderService.createOrder();
        Mockito.verify(orderDAOMock).persist(Matchers.any(Order.class));
    }
}