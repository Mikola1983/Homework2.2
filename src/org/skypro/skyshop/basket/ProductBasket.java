package org.skypro.skyshop.basket;

import org.skypro.skyshop.Product.Product;

public class ProductBasket {
    private Product products[] = new Product[5];

    // Добавление продукта в корзину
    public void addProduct(Product product) {
        int count = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                this.products[i] = product;
                break;
            } else {
                count++;
            }
            if (count == products.length) {
                System.out.println("Невозможно добавить продукт");
            }
        }
    }

    // Вычисление стоимости корзины
    public int priceBasket() {
        int basketPrice = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                basketPrice = basketPrice + this.products[i].getPrice();
            }
        }
        return basketPrice;
    }

    // Вывод корзины в консоль
    public void printBasket() {
        int basketPrice = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                basketPrice = basketPrice + this.products[i].getPrice();
                System.out.println(products[i].getTitle() + ": " + products[i].getPrice());
            }
        }
        if (basketPrice > 0) {
            System.out.println("Итого: " + basketPrice);
        } else System.out.println("В корзине пусто");
    }

    // Проверка продукта в корзине по имени
    public boolean searchBasket(String nameProduct) {
        boolean contrast = false;
        Product product;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                contrast = false;
                break;
            }
            if (products[i].getTitle() == nameProduct) {
                contrast = true;
                break;
            }
        }
        return contrast;
    }

    // Очистка корзины
    public void deleteBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }

}
