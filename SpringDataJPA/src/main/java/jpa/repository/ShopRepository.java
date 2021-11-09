package jpa.repository;

import jpa.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer>, CrudRepository<Shop, Integer> {

    List<Shop> findByName(String name);

    List<Shop> findMaxPeopleLessThanEqual(int maxPeople);
}
