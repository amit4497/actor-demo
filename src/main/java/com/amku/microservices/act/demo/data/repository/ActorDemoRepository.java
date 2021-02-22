package com.amku.microservices.act.demo.data.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.amku.microservices.act.demo.data.entity.Actor;

public interface ActorDemoRepository extends JpaRepository<Actor, Integer> {

}
