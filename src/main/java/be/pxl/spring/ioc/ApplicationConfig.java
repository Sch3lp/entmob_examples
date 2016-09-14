package be.pxl.spring.ioc;

import be.pxl.spring.ioc.order.OrderDAO;
import be.pxl.spring.ioc.order.DatabaseOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public DatabaseOrderService orderService(){
        return new DatabaseOrderService(orderDAO());
    }

    @Bean
    public OrderDAO orderDAO() {
        return new OrderDAO();
    }
}
