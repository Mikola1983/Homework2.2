package org.skypro.skyshop;

import org.skypro.skyshop.Product.Product;
import org.skypro.skyshop.basket.ProductBasket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Создание списка продуктов
        Product product1 = new Product("Война и мир", 100);
        Product product2 = new Product("Алмазный меч", 150);
        Product product3 = new Product("Ведьмак", 120);
        Product product4 = new Product("Гиперион", 140);
        Product product5 = new Product("Эверделл", 130);
        Product product6 = new Product("Сумерки империи", 90);

        // Инициализация и заполнение корзины с её переполнением
        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product1);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product5);
        System.out.println("");

        // Печать содержимого корзины
        basket.printBasket();
        System.out.println("");

        // Получение стоимости корзины
        System.out.println("Общая стоимость продуктов в корзине: " + basket.priceBasket());
        System.out.println("");


        // Поиск товаров в корзине
        System.out.println(basket.searchBasket("Ведьмак"));
        System.out.println(basket.searchBasket("Сумерки империи"));

        // Очистка корзины
        basket.deleteBasket();

        //Печать содержимого пустой корзины
        basket.printBasket();

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость продуктов в корзине: " + basket.priceBasket());

        // Поиск товара в пустой корзине
        System.out.println(basket.searchBasket("Ведьмак"));

    }

}