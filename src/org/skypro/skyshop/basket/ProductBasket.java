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
        return products.values().stream()
                // Преобразуем поток списков в поток продуктов
                .flatMap(java.util.Collection::stream)
                // Получаем поток цен (int)
                .mapToInt(Product::getPrice)
                // Суммируем цены
                .sum();
    }

    // Вспомогательный метод для подсчёта специальных товаров
    private long getSpecialCount() {
        // Фильтруем специальные продукты и считаем их количество
        return products.values().stream()
                .flatMap(java.util.Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    // Вывод корзины в консоль
    public void printBasket() {
        long totalCount = products.values().stream()
                .flatMap(java.util.Collection::stream)
                // Общее количество товаров
                .count();
        int basketPrice = priceBasket();
        long specialCount = getSpecialCount();
        if (totalCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        System.out.println("Всего товаров " + totalCount);
        System.out.println("Общая стоимость: " + basketPrice);
        System.out.println("Специальных товаров: " + specialCount);
        // Выводим информацию о каждом продукте
        products.values().stream()
                .flatMap(java.util.Collection::stream)
                .forEach(product -> System.out.println("Товар: " + product.getTitle() + ", Цена: " + product.getPrice() + (product.isSpecial() ? " (специальный)" : "")));
    }

    // Проверка продукта в корзине по имени
    public boolean searchBasket(String nameProduct) {
        return products.values().stream()
                .flatMap(java.util.Collection::stream)
                .anyMatch(product -> nameProduct.equals(product.getTitle()));
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
