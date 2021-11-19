package jpa.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int id;
    @Column(name = "shop_name")
    @NotBlank
    @Size(min = 5, max = 30, message = "incorrect length")
    private String name;
    @Column(name = "shop_square")
    @Positive
    private double square;
    @Column(name = "max_num_people")
    @Min(value = 1, message = "Max people should not be less than 1")
    @Max(value = 1500, message = "Max people should not be less than 15000")
    private int maxPeople;

    public Shop(int id, String name, double square, int maxPeople) {
        this.id = id;
        this.name = name;
        this.square = square;
        this.maxPeople = maxPeople;
    }

    public Shop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
}
