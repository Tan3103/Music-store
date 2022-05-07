package com.company;

import java.io.Serializable;

public class Guitar extends Product implements Serializable {
    private int numberStrings;
    private int Frets;

    public Guitar() {
    }

    public Guitar(Integer id, String type, String name, int cost, int count, int discount) {
        super(id, type, name, cost, count, discount);
    }

    public Guitar(Integer id, String type, String name, int cost, int count, int discount, int numberStrings, int frets) {
        super(id, type, name, cost, count, discount);
        this.numberStrings = numberStrings;
        Frets = frets;
    }

    public Guitar(String name, int cost, int discount) {
        super(name, cost, discount);
    }

    public int getNumberStrings() {
        return numberStrings;
    }

    public void setNumberStrings(int numberStrings) {
        this.numberStrings = numberStrings;
    }

    public int getFrets() {
        return Frets;
    }

    public void setFrets(int frets) {
        Frets = frets;
    }

    @Override
    public void showDetails() {
        System.out.println(getType() + " " + getName() + ", Number of strings: " + numberStrings + ", Frets: " + Frets + ", Price: " + getCost() + ", Number of products: " + getCount());
    }

    public String countDiscount() {
        if(getDiscount()>0) {
            float newPrice = 0;
            newPrice = (float) (getCost() - (getCost() * getDiscount() * 0.01));
            return getId() + ")  " + getType() + " " + getName() + ", " + getDiscount() + "% discount" + ", Price with discount: " + newPrice;
        }else return "";
    }

    @Override
    public String toString() {
        return getType() + " " + getName() + " " + getCost() + " " + getCount() + " " + getDiscount()+ " " + getNumberStrings() + " " + getFrets();
    }

    @Override
    public String info() {
        return getId() + ")  " + getType() + " " + getName() + '\n' + "  Price:" + getCost() + ", Quantities:" + getCount()+ ", Number of strings: " + numberStrings + ", Frets: " + Frets;
    }

    public String listInfo() {
        return getId() + ")  " + getType() + " " + getName() + "  Price:" + getCost();
    }
}