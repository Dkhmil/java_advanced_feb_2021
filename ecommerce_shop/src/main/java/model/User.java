package model;

import dao.annotation.Column;
import dao.annotation.Table;
import lombok.*;

import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER")
public class User {
    @Column(name = "USER_ID")
    private int id;
    @Column(name = "USER_EMAIL")
    private String email;
    @Column(name = "USER_PASSWORD")
    private String password;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ROLE")
    @Setter(value= AccessLevel.PRIVATE)
    private String role;

    public User(String email, String password, String firstName, String lastName, String role) {
        this(new Random().ints(1, 1000000)
                .findFirst()
                .getAsInt(), email, password, firstName, lastName, role);
    }

}
