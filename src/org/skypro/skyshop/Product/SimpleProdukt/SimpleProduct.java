package org.skypro.skyshop.Product.SimpleProdukt;

import org.skypro.skyshop.Product.Product;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String title, int price) {
        super(title);
        this.price = price;
    }


    @Override
    public String getTitle() {
        return super.getTitle();
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return getTitle() + ": " + price;
    }
    public boolean isSpecial(){
        return false;
    };
}
