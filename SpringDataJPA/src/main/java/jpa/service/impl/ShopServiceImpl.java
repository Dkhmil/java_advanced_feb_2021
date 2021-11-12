package jpa.service.impl;

import jpa.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpa.repository.ShopRepository;
import jpa.service.ShopService;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository repository;

    public void save(Shop shop) {
        repository.save(shop);
    }

    public Shop findById(int id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Shop> findAll() {
        return repository.findAll();
    }

    public Shop update(Shop shop) {
        return repository.save(shop);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Shop> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Shop> findMaxPeopleLessThanEqual(int maxPeople) {
        return repository.findByMaxPeopleLessThanEqual(maxPeople);
    }
}
