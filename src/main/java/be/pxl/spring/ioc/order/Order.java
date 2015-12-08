package be.pxl.spring.ioc.order;

import java.util.UUID;

public class Order {
    private UUID id;
    private String name;
    private int quantity;

    public Order(String name, int quantity) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
