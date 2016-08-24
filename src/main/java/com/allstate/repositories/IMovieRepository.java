package com.allstate.repositories;

import com.allstate.entities.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IMovieRepository extends PagingAndSortingRepository<Movie, Integer> {
}
