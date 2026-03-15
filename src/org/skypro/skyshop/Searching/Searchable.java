package org.skypro.skyshop.Searching;

public interface Searchable {
    String searchTerm();

    String contentType();

    default String getStringRepresentation() {
        return "Имя: " + searchTerm() + "\nТип: " + contentType();
    }
    String getTitle();

}
