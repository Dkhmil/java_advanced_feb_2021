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
/*        User user = new User("eamil@gmail.com",
                "123",
                "Vasyl",
                "Vasylenko",
                Role.USER);

        UserService userService = new UserServiceImpl(user);
        userService.create(user);*/
/*        User user1 = new User("eamil@gmail.com",
                "123",
                "Admin",
                "Admin",
                Role.ADMIN);

        UserService userService1 = new UserServiceImpl(user1);
        userService1.create(user1);*/

/*        Product product = new Product("phone", "cell phone", 20.000);
        Product product2 = new Product("watch", "some watch", 80.000);
        Product product3 = new Product("monitor", "monitor description", 90.000);
        Product product4 = new Product("keyboard", "dome keyboard", 120.000);
        Product product5 = new Product("car", "car description", 22220.000);

        ProductService productService = new ProductServiceImpl(product);
        ProductService productService2 = new ProductServiceImpl(product2);
        ProductService productService3 = new ProductServiceImpl(product3);
        ProductService productService4 = new ProductServiceImpl(product4);
        ProductService productService5 = new ProductServiceImpl(product5);

        productService.create(product);
        productService2.create(product2);
        productService3.create(product3);
        productService4.create(product4);
        productService5.create(product5);*/

        Bucket bucket = new Bucket(LocalDateTime.now());
        Bucket bucket2 = new Bucket(LocalDateTime.now().minus(1, ChronoUnit.MONTHS));

        BucketService bucketService = new BucketServiceImpl(bucket);
        BucketService bucketService2 = new BucketServiceImpl(bucket2);

        bucketService.create(bucket);
        bucketService2.create(bucket2);

    }
}
