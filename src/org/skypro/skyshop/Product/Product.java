package org.skypro.skyshop.Product;

public abstract class Product {
    private String title;

    public Product(String title) {
        if (title != "") {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Нет названия продукта");
        }
    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

}
