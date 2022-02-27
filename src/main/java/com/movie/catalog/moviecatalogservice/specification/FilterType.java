package com.movie.catalog.moviecatalogservice.specification;

public enum FilterType {
    YEAR("year"), RATING("rating");
    private String name;

    FilterType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
