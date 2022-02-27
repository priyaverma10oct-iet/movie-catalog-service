package com.movie.catalog.moviecatalogservice.controller;

import com.movie.catalog.moviecatalogservice.model.Movie;
import com.movie.catalog.moviecatalogservice.specification.FilterType;
import com.movie.catalog.moviecatalogservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.saveMovie(movie), HttpStatus.CREATED);
    }

    @PutMapping("/movie")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.updateMovie(movie), HttpStatus.OK);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/movies/spec")
    public ResponseEntity<List<Movie>> getMoviesByFilter(@RequestParam(value = "type") FilterType type,
                                                          @RequestParam(value = "value") int value) {
        return new ResponseEntity<>(movieService.getMoviesBySpec(type, value), HttpStatus.OK);
    }

}

