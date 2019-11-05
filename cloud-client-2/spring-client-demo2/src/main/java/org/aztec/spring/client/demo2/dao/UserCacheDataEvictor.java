package org.aztec.spring.client.demo2.dao;

public interface UserCacheDataEvictor {


	//@CacheEvict(value= "appUser")
	public void evictAllCache();
}
