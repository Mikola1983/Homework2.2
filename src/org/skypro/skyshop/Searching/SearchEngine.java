package org.skypro.skyshop.Searching;

import org.skypro.skyshop.Exceptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

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
        Set<Searchable> searchResult = searching.stream()
                // преобразуем в поток Searchable
                .flatMap(HashSet::stream)
                // фильтруем объекты по условию поиска
                .filter(product -> product.searchTerm().contains(result))
                // собираем в TreeSet
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
        int count2 = searchResult.size();
        System.out.println("Найдено " + count2 + " совпадений");
        return searchResult;
    }

    // Поиск наилучшего результата
    public Searchable searchMax(String search) throws BestResultNotFound {
        String query = search.toLowerCase();
        Optional<Searchable> result = searching.stream()
                .flatMap(HashSet::stream) // объединяем все HashSet в один поток
                .filter(product -> product != null && product.searchTerm() != null) // фильтруем null
                .max(Comparator.comparingInt(product -> {
                    String term = product.searchTerm().toLowerCase();
                    int count = 0;
                    int index = 0;
                    while ((index = term.indexOf(query, index)) != -1) {
                        count++;
                        index += query.length();
                    }
                    return count;
                }));
        return result.orElseThrow(() -> new BestResultNotFound("Для запроса '" + search + "' не нашлось лучшего результата"));
    }
}

