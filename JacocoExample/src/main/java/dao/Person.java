package dao;

import lombok.*;

import java.util.Date;

@Data

@NoArgsConstructor
public class Person {

    private String name;
    @NonNull private String email;
    @NonNull private String password;
    private Date dateOfBirth;


    public Person(String name, @NonNull String email, @NonNull String password, Date dateOfBirth) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }
}
