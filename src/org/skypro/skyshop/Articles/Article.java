package org.skypro.skyshop.Articles;

import org.skypro.skyshop.Searching.Searchable;
import org.skypro.skyshop.Searching.SearchableComparator;

import java.util.Objects;

public final class Article extends SearchableComparator implements Searchable {
    public final String titleProduct;
    public final String descriptionProduct;

    public Article(String titleProduct, String descriptionProduct) {
        this.titleProduct = titleProduct;
        this.descriptionProduct = descriptionProduct;
    }

    public String getTitle() {
        return titleProduct;
    }
    @Override
    public String toString() {
        return titleProduct + ":\n" + descriptionProduct;
    }

    @Override
    public String searchTerm() {
        return this.titleProduct + ": " + this.descriptionProduct;
    }

    @Override
    public String contentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Article article = (Article) obj;
        return Objects.equals(titleProduct, article.titleProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleProduct);
    }
}
