package be.pxl.spring.ioc;

import be.pxl.spring.ioc.order.OrderDAO;
import be.pxl.spring.ioc.order.OrderService;

public class IoC101 {

    public static void main(String[] args){
        new IoC101().run();
    }

    private void run() {
        OrderDAO orderDAO = new OrderDAO();
        OrderService orderService = new OrderService(orderDAO);
        orderService.createOrder();
    }
}
