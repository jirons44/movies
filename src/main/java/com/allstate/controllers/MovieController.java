package com.allstate.controllers;

import com.allstate.entities.Movie;
import com.allstate.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(path = {"", "/"},
                    method = RequestMethod.GET)
    public Page<Movie> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return movieService.findAll(page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Movie show(@PathVariable int id) {
        return movieService.findOne(id);
    }

    @RequestMapping(path = {"", "/"},
            method = RequestMethod.POST)
    public Movie create(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        movieService.destroy(id);
    }

//    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
//    public Movie update(@PathVariable int id, @RequestBody Movie movie) {
//        return movieService.update(id, movie);
//    }
}
