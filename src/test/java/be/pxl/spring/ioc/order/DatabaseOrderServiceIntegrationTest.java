package be.pxl.spring.ioc.order;

import be.pxl.spring.ioc.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class DatabaseOrderServiceIntegrationTest {

    @Autowired
    private DatabaseOrderService dbOrderService;

    @Test
    public void createOrder_PersistsAnOrder() throws Exception {
        dbOrderService.createOrder();
    }
}