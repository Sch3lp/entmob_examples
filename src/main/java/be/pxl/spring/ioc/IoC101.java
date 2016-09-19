package be.pxl.spring.ioc;

import be.pxl.spring.ioc.order.DatabaseOrderService;

public class IoC101 {

    private IoC101() {
    }

    public static void main(String[] args) {
        new IoC101().run();
    }

    private void run() {
        DatabaseOrderService orderService = new DatabaseOrderService();
        orderService.createOrder();
    }
}
