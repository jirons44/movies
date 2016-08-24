package com.allstate.services;

import com.allstate.entities.Movie;
import com.allstate.entities.Studio;
import com.allstate.repositories.IStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudioService {

    private IStudioRepository repository;

    @Autowired
    public void setRepository(IStudioRepository repository) {
        this.repository = repository;
    }

    public Page<Studio> findAll(int pageNumber) {

        PageRequest pr = new PageRequest(pageNumber, 3);
        return this.repository.findAll(pr);
    }

    public Page<Movie> findMovies(int id, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return repository.findAllMoviesByStudioId(id, pr);
    }

    public Studio findOne(int id) {
        return this.repository.findOne(id);
    }

    public Studio createStudio(Studio studio){
        return this.repository.save(studio);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

    public Studio update(int id, Studio s) {
        Studio studio = this.repository.findOne(id);
        studio.setName(s.getName());
        studio.setEst(s.getEst());
        return this.repository.save(studio);
    }

}
