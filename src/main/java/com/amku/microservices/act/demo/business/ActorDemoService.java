package com.amku.microservices.act.demo.business;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.amku.microservices.act.demo.data.entity.Actor;

public interface ActorDemoService {

	public Page<Actor> getAllActor(Pageable pageable);

	public Actor getActorById(Integer id);

}
