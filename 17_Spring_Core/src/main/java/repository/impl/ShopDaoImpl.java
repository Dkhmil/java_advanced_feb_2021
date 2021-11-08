package repository.impl;

import model.Shop;
import repository.ShopDao;

import java.util.ArrayList;
import java.util.List;

public class ShopDaoImpl implements ShopDao {

    private final List<Shop> shopList;

    public ShopDaoImpl() {
        this.shopList = new ArrayList<Shop>();
    }

    public List<Shop> readAll() {
        return shopList;
    }

    public Shop read(int id) {
        return shopList.stream()
                .filter(sh -> sh.getId() == id)
                .findFirst()
                .orElseGet(Shop::new);
    }

    public void create(Shop shop) {
        if (!shopList.contains(shop)) {
            shopList.add(shop);
        } else {
            throw new RuntimeException("Shop already added");
        }
    }

    public void update(Shop shop, String property, String newValue) {
        if (shopList.contains(shop)) {
            Shop shopToUpdate = read(shop.getId());
            shopToUpdate.setName(shop.getName());
            shopToUpdate.setSquare(shop.getSquare());
            shopToUpdate.setMaxPeople(shop.getMaxPeople());
        }
    }

    public void delete(int id) {
        shopList.stream()
                .filter(sh -> sh.getId() == id)
                .forEach(shopList::remove);
    }
}
