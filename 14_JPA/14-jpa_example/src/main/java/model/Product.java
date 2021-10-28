package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private int id;
    @Column(name = "PRODUCT_NAME")
    private  String name;
    @Column(name = "PRODUCT_DESCRIPTION")
    private String description;
    @Column(name = "PRODUCT_PRICE")
    private  double price;

    public Product(String name, String description, double price) {
        this.id = new Random().ints(1, 1000000)
                .findFirst()
                .getAsInt();
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
