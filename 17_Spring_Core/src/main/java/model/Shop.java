package model;

import lombok.Data;

@Data

public class Shop {
    private int id;
    private String name;
    private double square;
    private int maxPeople;

    public Shop(int id, String name, double square, int maxPeople) {
        this.id = id;
        this.name = name;
        this.square = square;
        this.maxPeople = maxPeople;
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
