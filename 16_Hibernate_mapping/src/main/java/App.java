import many_to_many.Team;
import many_to_many.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryUtil;

public class App {

    public static void main(String[] args) {
        Session session = SessionFactoryUtil.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        Team team1 = new Team("Team1");
        Team team2 = new Team("Team2");

        User user1 = new User("email1@gmail.com", "123");
        User user2 = new User("email2@gmail.com", "124");

        team1.addUser(user1);
        team1.addUser(user2);

        team2.addUser(user1);

        user1.addTeam(team1);
        user1.addTeam(team2);

        user2.addTeam(team1);

        session.save(team1);
        session.save(team2);
        transaction.commit();
        session.close();

    }
}
