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

        Shop shop = new Shop(1, "Shop1", 15, 150);
        Shop shop2 = new Shop(2, "Shop2", 16, 400);
        Shop shop3 = new Shop(3, "Shop3", 17, 800);

        //shopService.save(shop);
        //shopService.save(shop2);
        //shopService.save(shop3);


        //shopService.findAll().forEach(System.out::println);

        // System.out.println(shopService.findById(2));
/*        shopService.update(shop);
        shopService.update(shop2);
        shopService.update(shop3);

        shopService.findAll().forEach(System.out::println);*/

        //System.out.println(shopService.findByName("Shop3"));

        // System.out.println(shopService.findMaxPeopleLessThanEqual(200));

        shopService.delete(3);
        shopService.findAll().forEach(System.out::println);
    }
}
