package be.pxl.spring.ioc;

import be.pxl.spring.ioc.order.OrderDAO;
import be.pxl.spring.ioc.order.DatabaseOrderService;
import be.pxl.spring.ioc.order.OrderService;

public class IoC101 {

    private OrderService orderService;

    private IoC101(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        DatabaseOrderService orderService = new DatabaseOrderService(orderDAO);
        new IoC101(orderService).run();
    }

    private void run() {
        orderService.createOrder();
    }
}
