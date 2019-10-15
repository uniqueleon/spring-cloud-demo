package org.aztec.spring.client.demo2.entity.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.aztec.spring.client.demo2.dao.UserCacheDataEvictor;
import org.aztec.spring.client.demo2.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserEntityListener {
	@Autowired
	UserCacheDataEvictor repository;

	@PrePersist
	public void prePersist(Object source) {
		System.out.println(source);
	}
	
	@PostPersist
	public void afterPersist(Object source) {

		//repository.evictAllCache();
	}
	
	@PreRemove
	public void preRemove(Object source) {

		System.out.println(" pre remove: " + source);
	}

	@PostRemove
	public void afterRemove(Object source) {

		repository.evictAllCache();
	}

	@PreUpdate
	public void perUpdate(Object source) {
		System.out.println("pre update:" + source);
	}
	
	@PostUpdate
	public void afterUpdate(Object source) {
		repository.evictAllCache();
	}
	
	@PostLoad
	public void postLoad(Object source) {

		System.out.println("post load:" + source);
	}
}
