package org.skypro.skyshop.Searching;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.Product.Product;

import java.util.*;

public class SearchEngine {
    private Set<HashSet<Searchable>> searching = new HashSet<>();

    // Добавление объектов в список поиска
    public void add(String key, HashSet<Searchable> search) {
        if (search != null) {
            searching.add(search);
        }
    }

    // Поиск объектов по заданной строке
    public Set<Searchable> search(String result) {
        int count2 = 0;
        Set<Searchable> searchResult = new TreeSet<>(new SearchableComparator());
        // Сброс результатов предыдущего поиска
        searchResult.clear();
        // Переборка списка и заполнения списка результата поиска
        for (HashSet<Searchable> productHashSet : searching) {
            // Перебираем продукты в текущем списке
            for (Searchable product : productHashSet) {
                if (product.searchTerm().contains(result)) {
                    searchResult.add(product);
                    count2++;
                }
            }
        }
        System.out.println("Найдено " + count2 + " совпадений");
        return searchResult;
    }

    // Поиск наилучшего результата
    public Searchable searchMax(String search) throws BestResultNotFound {
        int count2 = 0;
        //String object;
        Searchable result = null;
        // Перебираем все категории и списки продуктов
        for (HashSet<Searchable> productHashSet : searching) {
            // Перебираем продукты в текущем списке
            for (Searchable product : productHashSet) {
                if (product == null || product.searchTerm() == null) {
                    continue;
                }
                String term = product.searchTerm().toLowerCase();
                String query = search.toLowerCase();
                // Подсчёт количества вхождений подстроки
                int count = 0;
                int index2 = 0;
                while ((index2 = term.indexOf(query, index2)) != -1) {
                    count++;
                    index2 += query.length();
                }
                // Обновляем лучший результат
                if (count > count2) {
                    count2 = count;
                    result = product;
                }
            }
        }
        if (result == null) {
            throw new BestResultNotFound("Для запроса '" + search + "' не нашлось лучшего результата");
        }
        return result;
    }
}

