package org.aztec.spring.client.demo2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.aztec.spring.client.demo2.entity.User;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper{

	@Select(value = { "select * from app_user" })
	public List<User> findAll();
}
