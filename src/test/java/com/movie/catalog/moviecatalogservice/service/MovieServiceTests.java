package com.movie.catalog.moviecatalogservice.service;

import com.movie.catalog.moviecatalogservice.exception.MovieDuplicatedException;
import com.movie.catalog.moviecatalogservice.exception.MovieNotFoundException;
import com.movie.catalog.moviecatalogservice.model.Movie;
import com.movie.catalog.moviecatalogservice.repository.MovieDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServiceTests {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieDao mockMovieDao;

    private Movie movie;

    @BeforeEach
    public void init() {
        movie = new Movie(1, "Dil", 2000, 4);
    }

    @Test
    public void testSaveMovie() {
        Mockito.when(mockMovieDao.existsById(Mockito.any(Integer.class))).thenReturn(false);
        Mockito.when(mockMovieDao.save(movie)).thenReturn(movie);
        Assertions.assertEquals(movie,movieService.saveMovie(movie));
    }

    @Test
    public void testSaveMovie_DuplicateMovieException() {
        Mockito.when(mockMovieDao.existsById(Mockito.any(Integer.class))).thenReturn(true);
        Assertions.assertThrows(MovieDuplicatedException.class, ()-> movieService.saveMovie(movie));
    }

    @Test
    public void testUpdateMovie_MovieNotFoundException() {
        Mockito.when(mockMovieDao.existsById(Mockito.any(Integer.class))).thenReturn(false);
        Assertions.assertThrows(MovieNotFoundException.class, ()-> movieService.updateMovie(movie));
    }

    @Test
    public void testUpdateMovie() {
        Mockito.when(mockMovieDao.existsById(Mockito.any(Integer.class))).thenReturn(true);
        Mockito.when(mockMovieDao.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(movie));
        Mockito.when(mockMovieDao.save(movie)).thenReturn(movie);
        Assertions.assertNotNull(movieService.updateMovie(movie));
    }



}
