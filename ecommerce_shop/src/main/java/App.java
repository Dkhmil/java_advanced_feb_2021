import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

public class App {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User(955406, "eamil@gmail.com",
                "123",
                "Vasyl2",
                "Vasylenko",
                "USER");

      //  userService.create(user);
        User readUser = userService.read(955406l);

        userService.update(user);


    }
}
