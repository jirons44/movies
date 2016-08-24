package com.allstate.controllers;

import com.allstate.entities.Movie;
import com.allstate.entities.Studio;
import com.allstate.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/studios")
public class StudioController {

    private StudioService studioService;

    @Autowired
    public void setStudioService(StudioService studioService) {
        this.studioService = studioService;
    }

    @RequestMapping(path = {"/{id}/movies"},
            method = RequestMethod.GET)
    public Page<Movie> movies(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return studioService.findMovies(id, page);
    }

    @RequestMapping(path = {"", "/"},
            method = RequestMethod.GET)
    public Page<Studio> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return studioService.findAll(page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Studio show(@PathVariable int id) {
        return studioService.findOne(id);
    }

    @RequestMapping(path = {"", "/"},
            method = RequestMethod.POST)
    public Studio create(@RequestBody Studio studio) {
        return studioService.createStudio(studio);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        studioService.destroy(id);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
    public Studio update(@PathVariable int id, @RequestBody Studio studio) {
        return studioService.update(id, studio);
    }
}
