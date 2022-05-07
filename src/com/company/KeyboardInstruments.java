package com.company;
import java.io.Serializable;

public class KeyboardInstruments extends Product implements Serializable {
    private int numberKeys;

    public KeyboardInstruments(Integer id, String type, String name, int cost, int count, int discount, int numberKeys) {
        super(id, type, name, cost, count, discount);
        this.numberKeys = numberKeys;
    }

    public int getNumberKeys() {
        return numberKeys;
    }

    public void setNumberKeys(int numberKeys) {
        this.numberKeys = numberKeys;
    }

    @Override
    public void showDetails() {
        System.out.println(getType() + " " + getName() + ", number of keys: " + getNumberKeys() + ", Price: " + getCost() + ", Number of products: " + getCount());
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
        return getType() + " " + getName() + " " + getCost() + " " + getCount() + " " + getDiscount()+ " " +  getNumberKeys();
    }

    @Override
    public String info() {
        return getId() + ")  " + getType() + " " + getName() + '\n' + "  Price:" + getCost() + ", Quantities:" + getCount() + ", number of keys: " + getNumberKeys();
    }
}
