package jpa;

import jpa.model.Shop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import jpa.service.ShopService;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        ShopService shopService = context.getBean(ShopService.class);

        Shop shop = new Shop(1, "Name", 15, 150);

        shopService.save(shop);

    }
}
