package org.aztec.spring.client.demo2.dao;

import java.util.List;

import org.aztec.spring.client.demo2.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

	@Cacheable(value = "appUser",key="'findbyname_' + #root.args[0]")
	public List<User> findByName(@Param("name")String name);
	
}
