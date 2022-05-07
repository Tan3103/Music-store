package com.company;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private Integer id;
    private String type;
    private String name;
    private int cost;
    private int count;
    private int discount;

    public Product() {
    }

    public Product(Integer id, String type, String name, int cost, int count, int discount) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.cost = cost;
        this.count = count;
        this.discount = discount;
    }

    public Product(String name, int cost, int discount) {
        this.name = name;
        this.cost = cost;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public abstract void showDetails();

    public String countDiscount() {
        if(discount>0) {
            float newPrice = 0;
            newPrice = (float) (getCost() - (getCost() * getDiscount() * 0.01));
            return getId() + ")  " + getType() + " " + getName() + ", " + getDiscount() + "% discount" + ", Price with discount: " + newPrice;
        }else return "";
    }

    @Override
    public String toString() {
        return type + " " + name + " " + cost + " " + count + " " + discount;
    }

    public String info() {
        return getId() + ")  " + type + " " + name + '\n'+ "  Price:" + cost + ", Quantities:" + count;
    }

    public String listInfo() {
        return getId() + ")  " + getType() + " " + getName() + "  Price:" + getCost();
    }
}
