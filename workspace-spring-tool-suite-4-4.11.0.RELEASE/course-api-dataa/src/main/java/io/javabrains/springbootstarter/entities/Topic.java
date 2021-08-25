package io.javabrains.springbootstarter.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Topic {

	@Id
	private int id;

	@Column
	private String name;

	@Column
	private String description;


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic(String name, String description, int id) {
		this.name = name;
		this.description = description;
		this.id = id;
	}
	
	public Topic() {
		
	}





}
