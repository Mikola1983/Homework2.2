package org.skypro.skyshop.Searching;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.Product.Product;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class SearchEngine {
    private TreeMap<String, LinkedList<Product>> searching = new TreeMap<>();
    private HashMap<String, LinkedList<Product>> searchResult = new HashMap<>();

    // Добавление объектов в список поиска
    public void add(String key, LinkedList<Product> search) {
        searching.put(key, search);
    }

    // Поиск объектов по заданной строке
    public Map<String, LinkedList<Product>> search(String result) {
        int count2 = 0;
        // Сброс результатов предыдущего поиска
        searchResult.clear();
        // Переборка списка и заполнения списка результата поиска
        for (Map.Entry<String, LinkedList<Product>> entry : searching.entrySet()) {
            String category = entry.getKey();
            LinkedList<Product> productList = entry.getValue();
            LinkedList<Product> foundInCategory = new LinkedList<>();
            // Перебираем продукты в текущем списке
            for (Product product : productList) {
                if (product.searchTerm().contains(result)) {
                    foundInCategory.add(product);
                    count2++;
                }
            }
            // Если в категории найдены продукты, добавляем их в результат
            if (!foundInCategory.isEmpty()) {
                searchResult.put(category, foundInCategory);
            }
        }
        System.out.println("Найдено " + count2 + " совпадений");
        return searchResult;
    }

    // Поиск наилучшего результата
    public Searchable searchMax(String search) throws BestResultNotFound {
        int count2 = 0;
        String object;
        Searchable result;
        result = null;
        // Перебираем все категории и списки продуктов
        for (Map.Entry<String, LinkedList<Product>> entry : searching.entrySet()) {
            LinkedList<Product> productList = entry.getValue();
            // Перебираем продукты в текущем списке
            for (Product product : productList) {
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

