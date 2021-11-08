package repository.impl;

import model.Shop;
import repository.ShopDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void update(Shop shop) {
        if (shopList.contains(shop)) {
            Shop shopToUpdate = read(shop.getId());
            shopToUpdate.setName(shop.getName());
            shopToUpdate.setSquare(shop.getSquare());
            shopToUpdate.setMaxPeople(shop.getMaxPeople());
        }
    }

    public void delete(int id) {
        Shop shopToDelete = read(id);
        if (Objects.nonNull(shopToDelete)) {
            shopList.remove(shopToDelete);
        }
    }
}
