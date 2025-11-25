package org.skypro.skyshop.Product.DiscountedProduct;

import org.skypro.skyshop.Product.Product;

public class DiscountedProduct extends Product {
    private int price;
    private int discount;

    public DiscountedProduct(String title, int price, int discount) {
        super(title);
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    public int getPrice() {
        return price - (discount * (price / 100));
    }

    public String toString() {
        return getTitle() + ": " + (price - (discount * (price / 100))) + " (скидка " + discount + "%)";
    }

    public boolean isSpecial() {
        return true;
    }

}
