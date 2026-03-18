package org.skypro.skyshop;

import org.skypro.skyshop.Articles.Article;
import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.Product.DiscountedProduct.DiscountedProduct;
import org.skypro.skyshop.Product.FixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.Product.Product;
import org.skypro.skyshop.Product.SimpleProdukt.SimpleProduct;
import org.skypro.skyshop.Searching.SearchEngine;
import org.skypro.skyshop.Searching.Searchable;
import org.skypro.skyshop.basket.ProductBasket;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Создание списка продуктов
        Product product1 = new SimpleProduct("Книга 'Война и мир'", 100);
        Product product2 = new DiscountedProduct("Книга 'Алмазный меч'", 200, 50);
        Product product3 = new FixPriceProduct("Книга 'Ведьмак'");
        Product product4 = new SimpleProduct("Книга 'Гиперион'", 140);
        Product product5 = new DiscountedProduct("Настольная игра 'Эверделл'", 130, 40);
        Product product6 = new SimpleProduct("Настольная игра 'Сумерки империи'", 90);
        Product product7 = new FixPriceProduct("Книга 'Ведьмак '");
        // Создание объектов класса Article
        Article article1 = new Article("Настольная игра", "Игра, в которую играют несколько человек");
        Article article2 = new Article("Книга", "Книги и аудиокниги разных жанров");
        Article article3 = new Article("Электронная Книга", "Книга - электронная vs бумажная. Какую выбрать?");
        Article article4 = new Article("Телевизор", "Есть ли видимое преимущество в картинке у телевизоров 8К");
        Article article5 = new Article("Ноутбук", "Как выбрать игровой ноутбук");

        System.out.println("Домашняя работа полиморфизм, интерфейсы:\n");

        //Проверка методов класса Article и переопределенных методов интерфейса Searchable
        System.out.println(article3.toString());
        System.out.println(product2.getStringRepresentation());
        System.out.println(article1.searchTerm() + " " + article1.contentType() + "\n");

        System.out.println("Домашняя работа Java Collection Framework: Set:\n");

        //Инициализация и заполнение списка поиска
        SearchEngine search = new SearchEngine();
        HashSet<Searchable> books = new HashSet<>();
        books.add(product1);
        books.add(product2);
        books.add(product3);
        books.add(product4);
        books.add(product4);
        books.add(product4);
        books.add(product7);
        HashSet<Searchable> boardGames = new HashSet<>();
        boardGames.add(product5);
        boardGames.add(product6);
        boardGames.add(product5);
        boardGames.add(product6);
        HashSet<Searchable> articles = new HashSet<>();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);

        search.add("Книга", books);
        search.add("Настольная игра", boardGames);
        search.add("Книга", articles);

        //Проверка методов поиска
        Set<Searchable> results1 = search.search("Гиперион");
        System.out.println("Результаты поиска 'Гиперион':");
        for (Searchable result : results1) {
            System.out.println("- " + result.getTitle() + " (" + result.contentType() + ")");
        }

        Set<Searchable> results2 = search.search("Эверделл");
        System.out.println("\nРезультаты поиска 'Эверделл':");
        for (Searchable result : results2) {
            System.out.println("- " + result.getTitle() + " (" + result.contentType() + ")");
        }
        Set<Searchable> results3 = search.search("Книга");
        System.out.println("\nРезультаты поиска 'Книга':");
        for (Searchable result : results3) {
            System.out.println("- " + result.getTitle() + " (" + result.contentType() + ")");
        }

        System.out.println("\n");
        System.out.println("Домашняя работа Stream API и лямбда-выражения:\n");

        // Инициализация и заполнение корзины
        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product5);

        // Печать содержимого корзины
        basket.printBasket();

        // Получение стоимости корзины
        System.out.println("\nОбщая стоимость продуктов в корзине: " + basket.priceBasket());

        // Поиск товаров в корзине
        System.out.println("\n" + basket.searchBasket("Книга 'Ведьмак'"));
        System.out.println(basket.searchBasket("Настольная игра 'Сумерки империи'"));

        // Удаление продукта "Настольная игра 'Эверделл'" и вывод списка удаленных продуктов
        System.out.println("\n" + basket.deleteSearch("Настольная игра 'Эверделл'"));

        // Очистка корзины
        basket.deleteBasket();

        //Печать содержимого пустой корзины
        basket.printBasket();

        // Удаление продукта несуществующего продукта "Настольная игра 'Эверделл'" и вывод списка удаленных продуктов
        System.out.println(basket.deleteSearch("Настольная игра 'Эверделл'"));

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость продуктов в корзине: " + basket.priceBasket());

        // Поиск товара в пустой корзине
        System.out.println(basket.searchBasket("Книга 'Ведьмак'"));
    }
}