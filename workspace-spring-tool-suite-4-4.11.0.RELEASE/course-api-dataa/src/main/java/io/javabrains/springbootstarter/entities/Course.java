package io.javabrains.springbootstarter.entities;

import io.javabrains.springbootstarter.repositories.TopicRepository;
import io.javabrains.springbootstarter.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column
	private String name;

	@Column
	private String description;

	@ManyToOne
	private Topic topic;





	public Course(String name, String description, int topicId) {
		this.name = name;
		this.description = description;
		this.topic = new Topic("", "", topicId);

	}


	
	public Course() {

	}

	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
