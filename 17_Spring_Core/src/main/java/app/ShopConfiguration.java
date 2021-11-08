package app;

import model.Shop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import repository.ShopDao;
import repository.impl.ShopDaoImpl;

@Configuration
public class ShopConfiguration {

    @Bean(name = "shopDao")
    @Scope("singleton")
    public ShopDao getShopDao() {
        return new ShopDaoImpl();
    }

    @Bean(name = "shop1")
    public Shop shop() {
        return new Shop(1, "Daily Products", 120, 20);
    }

    @Bean(name = "shop2")
    public Shop shop2() {
        return new Shop(2, "ATB", 130, 30);
    }

    @Bean(name = "shop3")
    public Shop shop3() {
        return new Shop(3, "Silpo", 140, 40);
    }
}
