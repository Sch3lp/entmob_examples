package be.pxl.spring.ioc;

import be.pxl.spring.ioc.order.OrderDAO;
import be.pxl.spring.ioc.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public OrderService orderService(){
        return new OrderService(orderDAO());
    }

    @Bean
    public OrderDAO orderDAO() {
        return new OrderDAO();
    }
}
