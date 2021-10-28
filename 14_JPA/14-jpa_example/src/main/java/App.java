import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class App {


    public static void main(String[] args) {
        User user = new User("123@email.com", "123", "name", "lastName", "USER");
        UserService service = new UserServiceImpl();
        service.createUser(user);
    }
}
