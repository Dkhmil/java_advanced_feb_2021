package model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

@Data
@Table(name = "USER")
@Entity
public class User {
    @Id
    @Column(name = "USER_ID")
    private int id;
    @Column(name = "USER_EMAIL")
    private String email;
    @Column(name = "USER_PASSWORD")
    private  String password;
    @Column(name = "LAST_NAME")
    private  String lastName;
    @Column(name = "ROLE")
    @Setter(value = AccessLevel.PRIVATE)
    private  String role;

    public User(String email, String password, String firstName, String lastName, String role) {
        this(new Random().ints(1, 1000000)
                .findFirst()
                .getAsInt(), email, password, firstName, lastName, role);
    }

    public User(int id, String email, String password, String firstName, String lastName, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.role = role;
    }

    public User() {
    }
}
