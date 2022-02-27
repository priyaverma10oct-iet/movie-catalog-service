package com.movie.catalog.moviecatalogservice.exception;

public class MovieDuplicatedException extends RuntimeException {
    public MovieDuplicatedException(String msg){
        super(msg);
    }

}
