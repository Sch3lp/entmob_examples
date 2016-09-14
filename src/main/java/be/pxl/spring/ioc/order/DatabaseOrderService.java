package be.pxl.spring.ioc.order;


import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseOrderService implements OrderService {

    private OrderDAO orderDAO;

    @Autowired
    public DatabaseOrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void createOrder() {
        Order order = new Order("my first order", 1);
        orderDAO.persist(order);
    }

}
