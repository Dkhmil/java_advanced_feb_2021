package jpa.service;

import jpa.model.Shop;

import java.util.List;

public interface ShopService {

    void save(Shop shop);

    Shop findById(int id);

    List<Shop> findAll();

    Shop update(Shop shop);

    void delete(int id);

    List<Shop> findByName(String name);

    List<Shop> findMaxPeopleLessThanEqual(int maxPeople);
}
