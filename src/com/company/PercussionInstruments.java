package com.company;

import java.io.Serializable;

public class PercussionInstruments extends Product implements Serializable {
    private String diameter;

    public PercussionInstruments(Integer id, String type, String name, int cost, int count, int discount, String diameter) {
        super(id, type, name, cost, count, discount);
        this.diameter = diameter;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    @Override
    public void showDetails() {
        System.out.println(getType() + " " + getName() + ", diameter: " + getDiameter() + ", Price: " + getCost() + ", Number of products: " + getCount());
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
        return getType() + " " + getName() + " " + getCost() + " " + getCount() + " " + getDiscount()+ " " +  getDiameter();
    }

    @Override
    public String info() {
        return getId() + ")  " + getType() + " " + getName() + '\n' + "  Price:" + getCost() + ", Quantities:" + getCount() + ", diameter: " + getDiameter();
    }
}
