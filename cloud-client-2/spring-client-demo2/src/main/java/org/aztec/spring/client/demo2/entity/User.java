package org.aztec.spring.client.demo2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.aztec.spring.client.demo2.entity.listener.UserEntityListener;

@Entity
@EntityListeners(value = { UserEntityListener.class })
@Table(name="app_user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4604626768610552121L;

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
