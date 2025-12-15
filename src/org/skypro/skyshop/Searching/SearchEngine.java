package org.skypro.skyshop.Searching;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.Product.Product;

import java.util.LinkedList;

public class SearchEngine {
    private LinkedList<Searchable> searching = new LinkedList<>();
    private LinkedList<Searchable> searchResult = new LinkedList<>();

    // Добавление объектов в список поиска
    public void add(Searchable search) {
        searching.add(search);
    }

    // Поиск объектов по заданной строке
    public String search(String result) {
        int count2 = 0;
        // Сброс результатов предыдущего поиска
        searchResult.clear();
        // Переборка списка и заполнения списка результата поиска
        for (int i = 0; i < searching.size(); i++) {
            if (searching.get(i).searchTerm().contains(result)) {
                searchResult.add(searching.get(i));
                count2++;
            }
        }
        System.out.println("Найдено " + count2 + " совпадений");
        return searchResult.toString();
    }

    // Поиск наилучшего результата
    public Searchable searchMax(String search) throws BestResultNotFound {
        int count2 = 0;
        int index = 0;
        int index2 = 0;
        String object;
        Searchable result;
        result = null;
        // Переборка массива и поиск наилучшего совпадения
        for (int i = 0; i < searching.size(); i++) {
            int count = 0;
            object = searching.get(i).searchTerm();
            index = object.indexOf(search, index2);
            while (index != -1) {
                count++;
                index2 = index + search.length();
                index = object.indexOf(search, index2);
            }
            if (count > count2) {
                result = searching.get(i);
                count2 = count;
            }
        }
        if (result == null) {
            throw new BestResultNotFound("Для запроса " + search + " не нашлось лучшего результата");
        } else {
            return result;
        }
    }
}

