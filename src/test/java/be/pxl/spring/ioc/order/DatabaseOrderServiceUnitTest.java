package be.pxl.spring.ioc.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseOrderServiceUnitTest {

//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    private DatabaseOrderService dbOrderService;

    @Mock
    private OrderDAO orderDAOMock;

    @Test
    public void createOrder_PersistsAnOrder() throws Exception {
        dbOrderService.createOrder();
        Mockito.verify(orderDAOMock).persist(Matchers.any(Order.class));
    }
}