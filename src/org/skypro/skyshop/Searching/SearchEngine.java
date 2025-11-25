package org.skypro.skyshop.Searching;

import java.util.Arrays;

public class SearchEngine {
    int size;
    private Searchable searching[];
    private Searchable searchResult[];

    public SearchEngine(int size) {
        this.size = size;
        this.searching = new Searchable[size];
        this.searchResult = new Searchable[5];
    }

    // Добавление объектов в массив поиска
    public void add(Searchable search) {
        int count = 0;
        for (int i = 0; i < searching.length; i++) {
            if (searching[i] == null) {
                searching[i] = search;
                break;
            } else {
                count++;
            }
            if (count == searching.length) {
                break;
            }
        }
    }

    // Поиск объектов по заданной строке
    public String search(String result) {
        int count2 = 0;
        // Цикл для сброса результатов предыдущего поиска
        for (int i = 0; i < 5; i++) {
            searchResult[i] = null;
        }
        // Переборка массива и заполнения массива результата поиска
        for (int i = 0; i < searching.length; i++) {
            if (searching[i] == null) {
                continue;
            }
            if (searching[i].searchTerm().contains(result)) {
                searchResult[count2] = searching[i];
                count2++;
            }
            if (count2 == 5) {
                break;
            }
        }
        System.out.println("Найдено " + count2 + " совпадений");
        return Arrays.toString(searchResult);
    }

}

