package org.skypro.skyshop.Product;

import org.skypro.skyshop.Searching.Searchable;

public abstract class Product implements Searchable{
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

    @Override
    public String searchTerm() {
        return this.title;
    }

    @Override
    public String contentType() {
        return "PRODUCT";
    }

}
