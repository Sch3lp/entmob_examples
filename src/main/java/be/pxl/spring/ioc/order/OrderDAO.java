package be.pxl.spring.ioc.order;

public class OrderDAO {

    public void persist(Order order) {
        //save an Order to the database or something.
        System.out.println(String.format("Order with id %s persisted", order.getId()));
    }
}
