package org.skypro.skyshop.Product.FixPriceProduct;

import org.skypro.skyshop.Product.Product;

public class FixPriceProduct extends Product {
    private final int FIX_PRICE = 100;

    public FixPriceProduct(String title) {
        super(title);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    public int getPrice() {
        return FIX_PRICE;
    }

    public String toString() {
        return getTitle() + ": фиксированная цена " + FIX_PRICE;
    }
    public boolean isSpecial() {
        return true;
    }
}
