package com.movie.catalog.moviecatalogservice.service;

import com.movie.catalog.moviecatalogservice.exception.MovieDuplicatedException;
import com.movie.catalog.moviecatalogservice.exception.MovieNotFoundException;
import com.movie.catalog.moviecatalogservice.model.Movie;
import com.movie.catalog.moviecatalogservice.repository.MovieDao;
import com.movie.catalog.moviecatalogservice.specification.FilterType;
import com.movie.catalog.moviecatalogservice.specification.MovieSpecification;
import com.movie.catalog.moviecatalogservice.specification.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieDao movieDao;

    public Movie saveMovie(Movie movie) {
        if (movieDao.existsById(movie.getMovieId())) {
            throw new MovieDuplicatedException(String.valueOf(movie.getMovieId()));
        }
        return movieDao.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        if (movieDao.existsById(movie.getMovieId())) {
            Movie dbMovie = movieDao.findById(movie.getMovieId()).get();
            if (movie.getName() != null) {
                dbMovie.setName(movie.getName());
            }
            if (movie.getYear() != null) {
                dbMovie.setYear(movie.getYear());
            }
            if (movie.getRating() != null) {
                dbMovie.setRating(movie.getRating());
            }
            return movieDao.save(dbMovie);
        }
        throw new MovieNotFoundException(String.valueOf(movie.getMovieId()));
    }

    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    public List<Movie> getMoviesBySpec(FilterType type, int value) {
        MovieSpecification spec = new MovieSpecification(new SearchCriteria(type.getName(), ":", value));
        return  movieDao.findAll(spec);
    }
}
