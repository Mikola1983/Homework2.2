package org.skypro.skyshop.Articles;

import org.skypro.skyshop.Searching.Searchable;

public final class Article implements Searchable {
    public final String titleProduct;
    public final String descriptionProduct;

    public Article(String titleProduct, String descriptionProduct) {
        this.titleProduct = titleProduct;
        this.descriptionProduct = descriptionProduct;
    }

    @Override
    public String toString() {
        return titleProduct + ":\n" + descriptionProduct;
    }
    @Override
    public String searchTerm(){
        return this.titleProduct + ": " + this.descriptionProduct;
    }
    @Override
    public String contentType(){
        return "ARTICLE";
    }
}
