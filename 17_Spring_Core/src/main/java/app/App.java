package app;

import model.Shop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import repository.impl.ShopDaoImpl;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);

        ShopDaoImpl shopDao = (ShopDaoImpl) context.getBean("shopDao");
        Shop shop1 = (Shop) context.getBean("shop1");
        Shop shop2 = (Shop) context.getBean("shop2");
        Shop shop3 = (Shop) context.getBean("shop3");

        System.out.println();


    }
}
