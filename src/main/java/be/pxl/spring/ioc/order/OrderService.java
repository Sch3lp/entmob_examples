package be.pxl.spring.ioc.order;


import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {

    private OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void createOrder() {
        Order order = new Order("my first order", 1);
        orderDAO.persist(order);
    }

}
