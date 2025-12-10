package org.skypro.skyshop.Product.DiscountedProduct;

import org.skypro.skyshop.Product.Product;

public class DiscountedProduct extends Product {
    private int price;
    private int discount;

    public DiscountedProduct(String title, int price, int discount) {
        super(title);
        // Проверка корректности ввода цены продукта
        if (price <= 0) {
            throw new IllegalArgumentException(title + " Цена должна быть больше 0");
        } else {
            this.price = price;
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException(title + " Скидка должна быть в диапазоне от 0 до 100%");
        } else {
            this.discount = discount;
        }
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
