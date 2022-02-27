package com.movie.catalog.moviecatalogservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "movie_name")
    private String name;
    @Column(name = "movie_year")
    private Integer year;
    @Column(name = "movie_rating")
    private Integer rating;
}
