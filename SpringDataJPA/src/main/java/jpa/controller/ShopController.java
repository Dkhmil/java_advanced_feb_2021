package jpa.controller;


import jpa.model.Shop;
import jpa.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Objects;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shops")
    public ResponseEntity<List<Shop>> getAllShops() {
        List<Shop> shops = shopService.findAll();
        if (shops.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/shops/by-name/{name}")
    public ResponseEntity<List<Shop>> getAllShopsByName(@PathVariable("name") String name) {
        List<Shop> shops = shopService.findByName(name);
        if (shops.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity<Shop> getAllShopsById(@PathVariable("id") int id) {
        Shop shop = shopService.findById(id);
        if (Objects.isNull(shop)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @PostMapping("/shops")
    public ResponseEntity<?> addNewShop(@RequestBody Shop shop, UriComponentsBuilder builder) {
        shopService.save(shop);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(builder.path("/shops/{id}").buildAndExpand(shop.getId()).toUri());
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/shops/{id}")
    public ResponseEntity<Shop> updateShopById(@RequestBody Shop shop, @PathVariable("id") int id) {
        Shop previous = shopService.findById(id);
        if (Objects.nonNull(previous)) {
            shopService.update(shop);
            return new ResponseEntity<>(shop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/shops/{id}")
    public ResponseEntity<?> deleteShopById(@PathVariable("id") int id) {
        if (Objects.isNull(shopService.findById(id))) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        shopService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
