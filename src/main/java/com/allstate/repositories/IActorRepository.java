package com.allstate.repositories;


import com.allstate.entities.Actor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IActorRepository extends PagingAndSortingRepository<Actor, Integer> {
}
