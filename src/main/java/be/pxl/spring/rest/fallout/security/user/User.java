package be.pxl.spring.rest.fallout.security.user;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "UNAME")
    @Length(max = 50)
    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled;

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

}
