package com.movie.catalog.moviecatalogservice.repository;

import com.movie.catalog.moviecatalogservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer>, JpaSpecificationExecutor<Movie>{

}
