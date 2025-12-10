package org.skypro.skyshop.Product;

import org.skypro.skyshop.Searching.Searchable;

public abstract class Product implements Searchable {
    private String title;

    public Product(String title) {
        // Проверка корректности ввода имени продукта
        if (title.isBlank()) {
            throw new IllegalArgumentException("Не указано название продукта!");
        } else {
            this.title = title;
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
