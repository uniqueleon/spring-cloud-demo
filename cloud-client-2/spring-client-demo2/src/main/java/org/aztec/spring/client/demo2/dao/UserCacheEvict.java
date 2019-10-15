package org.aztec.spring.client.demo2.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class UserCacheEvict implements UserCacheDataEvictor {
	
	@PersistenceContext
	private EntityManager em;

	public void evictAllCache() {
		System.out.println(em);
	}

}
