import model.Role;
import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class App {

    public static void main(String[] args) {
        User user = new User("eamil@gmail.com",
                "123",
                "Vasyl",
                "Vasylenko",
                Role.USER);

        UserService userService = new UserServiceImpl(user);
        userService.create(user);


    }
}
