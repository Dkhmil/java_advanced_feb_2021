import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class App {

    public static void main(String[] args) {
        User user = new User("124@email.com", "123", "name", "lastName", "USER");
        UserService service = new UserServiceImpl();
        // service.createUser(user);

        // User user1 = service.readByEmail("124@email.com");
        // assert user1 != null;
        //service.delete(439596);

        System.out.println(service.findAll());
    }
}
