package org.skypro.skyshop.Product;

import org.skypro.skyshop.Searching.Searchable;
import org.skypro.skyshop.Searching.SearchableComparator;

import java.util.Objects;

public abstract class Product extends SearchableComparator implements Searchable {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
