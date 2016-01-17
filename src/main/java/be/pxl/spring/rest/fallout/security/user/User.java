package be.pxl.spring.rest.fallout.security.user;

import be.pxl.spring.rest.fallout.item.Item;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "UNAME")
    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_USER_ID")
    private List<Item> items;

    protected User(){}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.role = Role.ROLE_USER;
        this.enabled = true;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void addItemToInventory(Item item) {
        item.setHolder(getName());
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
