package com.allstate.services;

import com.allstate.entities.Movie;
import com.allstate.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

        private IMovieRepository repository;

        @Autowired
        public void setRepository(IMovieRepository repository) {
            this.repository = repository;
        }

        public Page<Movie> findAll(int pageNumber) {
            PageRequest pr = new PageRequest(pageNumber, 3);
            return this.repository.findAll(pr);
        }

        public Movie findOne(int id) {
            return this.repository.findOne(id);
        }

        public Movie createMovie(Movie movie){
            return this.repository.save(movie);
        }

        public void destroy(int id) {
            this.repository.delete(id);
        }

//        public Movie update(int id, Movie s) {
//            Movie movie = this.repository.findOne(id);
//            movie.setName(s.getName());
//            movie.setEst(s.getEst());
//            return this.repository.save(movie);
//        }
}
