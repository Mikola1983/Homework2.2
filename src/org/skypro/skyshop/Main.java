package org.skypro.skyshop;

import org.skypro.skyshop.Articles.Article;
import org.skypro.skyshop.Product.DiscountedProduct.DiscountedProduct;
import org.skypro.skyshop.Product.FixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.Product.Product;
import org.skypro.skyshop.Product.SimpleProdukt.SimpleProduct;
import org.skypro.skyshop.Searching.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Создание списка продуктов
        Product product1 = new SimpleProduct("Книга 'Война и мир'", 100);
        Product product2 = new DiscountedProduct("Книга 'Алмазный меч'", 200, 50);
        Product product3 = new FixPriceProduct("Книга 'Ведьмак'");
        Product product4 = new SimpleProduct("Книга 'Гиперион'", 140);
        Product product5 = new DiscountedProduct("Настольная игра 'Эверделл'", 130, 40);
        Product product6 = new SimpleProduct("Настольная игра 'Сумерки империи'", 90);

        // Инициализация и заполнение корзины с её переполнением
        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
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
        System.out.println(basket.searchBasket("Книга 'Ведьмак'"));
        System.out.println(basket.searchBasket("Настольная игра 'Сумерки империи'"));

        // Очистка корзины
        basket.deleteBasket();

        //Печать содержимого пустой корзины
        basket.printBasket();

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость продуктов в корзине: " + basket.priceBasket());

        // Поиск товара в пустой корзине
        System.out.println(basket.searchBasket("Книга 'Ведьмак'"));

        // Разделение домашних заданий в консоли для более удобного чтения
        System.out.println("\n");
        System.out.println("Домашняя работа полиморфизм, интерфейсы:\n");

        // Создание объектов класса Article
        Article article1 = new Article("Настольная игра", "Игра, в которую играют несколько человек");
        Article article2 = new Article("Книга", "Книги и аудиокниги разных жанров");
        Article article3 = new Article("Электронная книга", "Книга - электронная vs бумажная. Какую выбрать?");
        Article article4 = new Article("Телевизор", "Есть ли видимое преимущество в картинке у телевизоров 8К");
        Article article5 = new Article("Ноутбук", "Как выбрать игровой ноутбук");

        //Проверка методов класса Article и переопределенных методов интерфейса Searchable
        System.out.println(article3.toString());
        System.out.println(product2.getStringRepresentation());
        System.out.println(article1.searchTerm() + " " + article1.contentType() + "\n");

        //Инициализация и заполнение массива поиска с переполнением
        SearchEngine search = new SearchEngine(10);
        search.add(product1);
        search.add(product2);
        search.add(product3);
        search.add(product4);
        search.add(product5);
        search.add(product6);
        search.add(article1);
        search.add(article2);
        search.add(article3);
        search.add(article4);
        search.add(article5);

        // Поиск более 5 подходящих элементов - после 5 найденного остальные не проверяются
        System.out.println(search.search("Книга") + "\n");
        // Поиск менее 5 подходящих элементов
        System.out.println(search.search("Настольная игра") + "\n");
        // Поиск с нулевым результатом (article5 не поместился в массив searching, так как был 11 элементом)
        System.out.println(search.search("Ноутбук"));

    }

}