package org.aztec.spring.client.demo2.dao;

import org.aztec.spring.client.demo2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
