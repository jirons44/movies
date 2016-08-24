package com.allstate.controllers;

import com.allstate.entities.Actor;
import com.allstate.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/actors")
public class ActorController {

    private ActorService service;

    @Autowired
    public void setActorService(ActorService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"},
            method = RequestMethod.GET)
    public Page<Actor> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return service.findAll(page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Actor show(@PathVariable int id) {
        return service.findOne(id);
    }

    @RequestMapping(path = {"", "/"},
            method = RequestMethod.POST)
    public Actor create(@RequestBody Actor actor) {
        return service.createActor(actor);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        service.destroy(id);
    }

}
