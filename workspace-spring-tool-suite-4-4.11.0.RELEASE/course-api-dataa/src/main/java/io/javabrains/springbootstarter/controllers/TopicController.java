package io.javabrains.springbootstarter.controllers;

import java.util.List;
import java.util.Optional;


import io.javabrains.springbootstarter.entities.Topic;
import io.javabrains.springbootstarter.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {
	
	
	@Autowired
	private TopicService topicService;
	
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return (List<Topic>) topicService.getAllTopics();
	}

	
	
	@GetMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable int id) {
		return topicService.getTopic(id);
	}
	
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic); 
	}
	
	@PutMapping("/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,  @PathVariable int id) {
		topicService.updateTopic(id, topic); 
	}
	
	
	@DeleteMapping("/topics/{id}")
	public void deleteTopic(@PathVariable int id) {
		 topicService.deleteTopic(id);
	}

}
