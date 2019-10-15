package org.aztec.spring.client.demo2.dao;

import org.springframework.cache.annotation.CacheEvict;
public interface UserCacheDataEvictor {


	@CacheEvict(value= "appUser")
	public void evictAllCache();
}
