package io.javabrains.springbootstarter.services;

import java.util.Optional;

import io.javabrains.springbootstarter.entities.Topic;
import io.javabrains.springbootstarter.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
	@Autowired
	private TopicRepository topicRepository;

	public TopicService(TopicRepository topicRepository) {
		this.topicRepository = topicRepository;
	}

	public TopicService() {
	}

	public Iterable<Topic> getAllTopics() {
		return topicRepository.findAll();
	}
	
	
	public Optional<Topic> getTopic(int id) {
		return topicRepository.findById(id);
	}


	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}


	public void updateTopic(int id, Topic topic) {
		topicRepository.save(topic);
	}


	public void deleteTopic(int id) {
		topicRepository.deleteById(id); 
	}

}
