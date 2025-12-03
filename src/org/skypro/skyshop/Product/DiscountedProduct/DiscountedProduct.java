package org.skypro.skyshop.Product.DiscountedProduct;

import org.skypro.skyshop.Product.Product;

public class DiscountedProduct extends Product {
    private int price;
    private int discount;

    public DiscountedProduct(String title, int price, int discount) {
        super(title);
        // Проверка корректности ввода цены продукта
        try {
            if (price <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException product) {
            System.out.println(product + " Цена должна быть больше 0");
        }
        // Проверка корректности ввода скидки
        try {
            if (discount < 0 || discount > 100) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException product) {
            System.out.println(product + " Скидка должна быть в диапазоне от 0 до 100%");
        }
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
