package repository.impl;

import model.Shop;
import repository.ShopDao;

import java.util.ArrayList;
import java.util.List;

public class ShopDaoImpl implements ShopDao {

    private List<Shop> shopList;

    public ShopDaoImpl() {
        this.shopList = new ArrayList<Shop>();
    }

    public List<Shop> readAll() {
        return null;
    }

    public Shop read(int id) {
        return null;
    }

    public void create(Shop shop) {

    }

    public void update(Shop shop, String property, String newValue) {

    }

    public void delete(int id) {

    }
}
