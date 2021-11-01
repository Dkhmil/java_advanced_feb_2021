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
@Table(name = "TEAM")
@Entity
public class Team {
    private int id;
    private String teamName;
    private Set<User> users = new HashSet<User>();


    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
