package org.skypro.skyshop.basket;

import org.skypro.skyshop.Product.Product;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private HashMap<String, LinkedList<Product>> products = new HashMap<>();

    // Добавление продукта в корзину
    public void addProduct(Product product) {
        products.computeIfAbsent(product.getTitle(), key -> new LinkedList<>());
        products.get(product.getTitle()).add(product);
    }

    // Вычисление стоимости корзины
    public int priceBasket() {
        int basketPrice = 0;
        // Перебираем все списки продуктов в корзине
        for (LinkedList<Product> productList : products.values()) {
            // Перебираем каждый продукт в текущем списке
            for (Product product : productList) {
                basketPrice += product.getPrice();
            }
        }
        return basketPrice;
    }

    // Вывод корзины в консоль
    public void printBasket() {
        int basketPrice = 0;
        int special = 0;
        int i =0;
        // Перебираем все списки продуктов в корзине
        for (LinkedList<Product> productList : products.values()) {
            //System.out.println("Категория " + products.keySet());
            // Перебираем каждый продукт в текущем списке
            for (Product product : productList) {
                basketPrice += product.getPrice();
                i++;
                //System.out.println(products.keySet());
                if (product.isSpecial()) {
                    special++;
                }
            }
        }
        System.out.println(products.keySet());
        System.out.println("Всего товаров " + i);
        if (basketPrice > 0) {
            System.out.println("Итого: " + basketPrice);
            System.out.println("Специальных товаров: " + special);
        } else {
            System.out.println("В корзине пусто");
        }
    }

    // Проверка продукта в корзине по имени
    public boolean searchBasket(String nameProduct) {
        for (LinkedList<Product> productList : products.values()) {
            for (Product product : productList) {
                if (nameProduct.equals(product.getTitle())) {
                    return true;
                }
            }
        }
        return false;
    }

    // Очистка корзины
    public void deleteBasket() {
        products.clear();
    }

    // Удаление продукта по заданному имени
    public List<Product> deleteSearch(String name) {
        List<Product> removedProducts = products.remove(name);
        if (removedProducts == null) {
            return new LinkedList<>(); // Категория не найдена
        }
        return removedProducts;
    }

}
