package com.javatechie.redis.entity;

import java.io.Serializable;
import jakarta.persistence.Id;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Person")
public class PersonValkey implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Id
    private int id;
    
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonValkey(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public PersonValkey() {
		
	}

	@Override
	public String toString() {
		return "PersonValkey [id=" + id + ", name=" + name + "]";
	}
    
}