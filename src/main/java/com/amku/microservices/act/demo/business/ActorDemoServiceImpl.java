package com.amku.microservices.act.demo.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.amku.microservices.act.demo.data.entity.Actor;
import com.amku.microservices.act.demo.data.repository.ActorDemoRepository;

@Service
public class ActorDemoServiceImpl implements ActorDemoService {

	@Autowired
	private ActorDemoRepository repository;

	public ActorDemoServiceImpl() {
	}

	@Override
	public Page<Actor> getAllActor(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	@Override
	public Actor getActorById(Integer id) {
		Optional<Actor> actor = this.repository.findById(id);
		return actor.orElseThrow();
	}

	public ActorDemoRepository getRepository() {
		return repository;
	}

	public void setRepository(ActorDemoRepository repository) {
		this.repository = repository;
	}

}
