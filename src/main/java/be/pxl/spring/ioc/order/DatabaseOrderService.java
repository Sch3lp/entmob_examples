package be.pxl.spring.ioc.order;


public class DatabaseOrderService implements OrderService {

    private OrderDAO orderDAO;

    public DatabaseOrderService() {
        this.orderDAO = new OrderDAOImpl();
    }

    @Override
    public void createOrder() {
        Order order = new Order("my first order", 1);
        orderDAO.persist(order);
    }

}
