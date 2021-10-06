
import model.Role;
import model.User;
import service.BucketService;
import service.ProductService;
import service.UserService;
import service.impl.BucketServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

public class App {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProductService productService = new ProductServiceImpl();
        BucketService bucketService = new BucketServiceImpl();

        userService.create(
                new User("eamil@gmail.com",
                        "123",
                        "Vasyl",
                        "Vasylenko",
                        Role.USER));


    }
}
