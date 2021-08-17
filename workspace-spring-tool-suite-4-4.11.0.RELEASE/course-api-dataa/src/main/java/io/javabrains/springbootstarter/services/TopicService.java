package io.javabrains.springbootstarter.services;

import java.util.List;

import io.javabrains.springbootstarter.entities.Topic;
import io.javabrains.springbootstarter.repositories.TopicRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	
//	@Autowired
	private TopicRepository topicRepository;

	public TopicService(TopicRepository topicRepository) {
		this.topicRepository = topicRepository;
	}

	public TopicService() {
	}

	public List<Topic> getAllTopics() {
		return (List<Topic>) topicRepository.findAll();
	}
	
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).get() ;
	}


	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}


	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}


	public void deleteTopic(String id) {
		topicRepository.deleteById(id); 
	}

}
