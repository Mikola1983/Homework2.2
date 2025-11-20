package org.skypro.skyshop.Product;

public class Product {
    private String title;
    private int price;

    public Product(String title, int price) {
        if (title != "") {
            this.title = title;
        } else {
            throw new IllegalArgumentException("Нет названия продукта");
        }
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return title + " цена " + price;
    }

}
