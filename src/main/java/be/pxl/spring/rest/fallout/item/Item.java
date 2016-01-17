package be.pxl.spring.rest.fallout.item;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "pg-uuid")
    private UUID id;
    private String name;
    private String holder;

    protected Item(){}

    public Item(String name, String holder) {
        this.name = name;
        this.holder = holder;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }
}
