package many_to_many;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    private int id;
    private String email;
    private String password;
    private Set<Team> teams = new HashSet<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }
}
