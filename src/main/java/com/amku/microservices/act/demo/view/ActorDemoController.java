package com.amku.microservices.act.demo.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amku.microservices.act.demo.business.ActorDemoService;
import com.amku.microservices.act.demo.data.entity.Actor;

@RestController
public class ActorDemoController {

	@Autowired
	private ActorDemoService service;

	@GetMapping("/actor")
	public Page<Actor> getAll(
			@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
			@RequestParam(value = "size", defaultValue = "20", required = false) Integer size) {
		return this.service.getAllActor(this.getPageable(page, size));
	}

	@GetMapping("/actor/{id}")
	public Actor getCustomer(@PathVariable("id") Integer id) {
		return this.service.getActorById(id);
	}

	protected Pageable getPageable(Integer page, Integer size) {
		return PageRequest.of(page, size, Sort.by("firstName").ascending().and(Sort.by("lastName").ascending()));
	}

	public ActorDemoService getService() {
		return service;
	}

	public void setService(ActorDemoService service) {
		this.service = service;
	}

}
