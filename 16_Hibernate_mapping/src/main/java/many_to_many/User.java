package many_to_many;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;
    @Column(name = "USER_EMAIL")
    private String email;
    @Column(name = "USER_PASSWORD")
    private String password;
    @ManyToMany(mappedBy = "users")
    private Set<Team> teams = new HashSet<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}
