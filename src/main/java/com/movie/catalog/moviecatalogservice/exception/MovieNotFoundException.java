package com.movie.catalog.moviecatalogservice.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String msg){
        super(msg);
    }
}
