package io.javabrains.springbootstarter.controllers;

import java.util.List;

import io.javabrains.springbootstarter.services.CourseService;
import io.javabrains.springbootstarter.entities.Course;
import io.javabrains.springbootstarter.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {
	
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id); 
	}
	
	
	@GetMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course); 
	}
	
	@PutMapping("/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course); 
	}
	
	
	@DeleteMapping("/topics/{topicId}/courses/{courseId}")
	public void deleteCourse (@PathVariable String id) {
		 courseService.deleteCourse(id);
	}

}
