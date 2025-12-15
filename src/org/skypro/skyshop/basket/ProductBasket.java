package org.skypro.skyshop.basket;

import org.skypro.skyshop.Product.Product;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private LinkedList<Product> products = new LinkedList<>();

    // Добавление продукта в корзину
    public void addProduct(Product product) {
        products.add(product);
    }

    // Вычисление стоимости корзины
    public int priceBasket() {
        int basketPrice = 0;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product products = iterator.next();
            basketPrice = basketPrice + products.getPrice();
        }
        return basketPrice;
    }

    // Вывод корзины в консоль
    public void printBasket() {
        int basketPrice = 0;
        int special = 0;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product products = iterator.next();
            basketPrice = basketPrice + products.getPrice();
            System.out.println(products.toString());
            if (products.isSpecial()) {
                special++;
            }
        }
        if (basketPrice > 0) {
            System.out.println("Итого: " + basketPrice);
            System.out.println("Специальных товаров: " + special);
        } else System.out.println("В корзине пусто");
    }

    // Проверка продукта в корзине по имени
    public boolean searchBasket(String nameProduct) {
        boolean contrast = false;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product products = iterator.next();
            if (nameProduct.equals(products.getTitle())) {
                contrast = true;
                break;
            }
        }
        return contrast;
    }

    // Очистка корзины
    public void deleteBasket() {
        products.clear();
    }

    // Удаление продукта по заданному имени
    public List<Product> deleteSearch(String name) {
        LinkedList<Product> deletedProduct = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product products = iterator.next();
            if (name.equals(products.getTitle())) {
                deletedProduct.add(products);
                iterator.remove();
            }
        }
        if (deletedProduct.isEmpty()) {
            System.out.println("Список пуст");
        }
        return (deletedProduct);
    }

}
