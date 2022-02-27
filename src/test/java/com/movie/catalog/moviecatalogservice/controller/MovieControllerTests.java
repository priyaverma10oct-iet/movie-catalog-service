package com.movie.catalog.moviecatalogservice.controller;

import com.movie.catalog.moviecatalogservice.exception.MovieDuplicatedException;
import com.movie.catalog.moviecatalogservice.exception.MovieNotFoundException;
import com.movie.catalog.moviecatalogservice.model.Movie;
import com.movie.catalog.moviecatalogservice.repository.MovieDao;
import com.movie.catalog.moviecatalogservice.service.MovieService;
import com.movie.catalog.moviecatalogservice.specification.FilterType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MovieControllerTests {

    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieService mockMovieService;

    private Movie movie;

    @BeforeEach
    public void init() {
        movie = new Movie(1, "Dil", 2000, 4);
    }

    @Test
    public void testSaveMovie() {
        Mockito.when(mockMovieService.saveMovie(movie)).thenReturn(movie);
        Assertions.assertEquals(HttpStatus.CREATED,(movieController.saveMovie(movie)).getStatusCode());
    }

    @Test
    public void testUpdateMovie() {
        Mockito.when(mockMovieService.updateMovie(movie)).thenReturn(movie);
        Assertions.assertEquals(HttpStatus.OK,(movieController.updateMovie(movie)).getStatusCode());
    }

    @Test
    public void testGetMovies() {
        List<Movie> movieList = new ArrayList<>();
        Movie movieSample = new Movie(123, "MovieTest", 1992, 4);
        movieList.add(movieSample);
        movieList.add(movie);
        Mockito.when(mockMovieService.getAllMovies()).thenReturn(movieList);
        ResponseEntity<List<Movie>> response = movieController.getMovies();
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetMoviesByFilter_ByRating() {
        List<Movie> movieList = new ArrayList<>();
        Movie movieSample = new Movie(123, "MovieTest", 1992, 4);
        movieList.add(movieSample);
        movieList.add(movie);
        Mockito.when(mockMovieService.getMoviesBySpec(Mockito.any(FilterType.class), Mockito.anyInt())).thenReturn(movieList);
        ResponseEntity<List<Movie>> response = movieController.getMoviesByFilter(FilterType.RATING, 4);
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode());
        Assertions.assertEquals(2, response.getBody().size());

    }

}
