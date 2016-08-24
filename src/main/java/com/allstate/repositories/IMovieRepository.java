package com.allstate.repositories;

import com.allstate.entities.Movie;
import com.allstate.enums.Rating;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IMovieRepository extends PagingAndSortingRepository<Movie, Integer> {
    public Movie findByName(String name);

    public List<Movie> findByRatingOrderByReleasedDesc(Rating rating);
}
