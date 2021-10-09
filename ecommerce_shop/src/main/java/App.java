import model.Bucket;
import model.Product;
import model.Role;
import model.User;
import service.BucketService;
import service.ProductService;
import service.UserService;
import service.impl.BucketServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class App {

    public static void main(String[] args) {
        User user = new User("eamil@gmail.com",
                "123",
                "Vasyl",
                "Vasylenko",
                Role.USER);

        UserService userService = new UserServiceImpl();
        userService.create(user);


    }
}
