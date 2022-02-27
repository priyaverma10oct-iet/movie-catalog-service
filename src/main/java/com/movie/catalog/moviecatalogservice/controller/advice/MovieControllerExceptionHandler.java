package com.movie.catalog.moviecatalogservice.controller.advice;

import com.movie.catalog.moviecatalogservice.exception.MovieDuplicatedException;
import com.movie.catalog.moviecatalogservice.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MovieControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    private ResponseEntity<?> handleMovieNotFoundException(MovieNotFoundException exception) {
        String responseMessage = "The provided movie [" + exception.getMessage() + "] is nowhere to be found.";
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(responseMessage);
    }

    @ExceptionHandler(MovieDuplicatedException.class)
    private ResponseEntity<?> handleMovieDuplicatedException(MovieDuplicatedException exception) {
        String responseMessage = "The provided movie [" + exception.getMessage() + "] is already existing.";
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(responseMessage);
    }
}
