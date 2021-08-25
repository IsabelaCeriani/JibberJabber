package io.javabrains.springbootstarter.services;

import java.util.ArrayList;

import java.util.List;

import io.javabrains.springbootstarter.entities.Course;
import io.javabrains.springbootstarter.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	
	@Autowired
	private CourseRepository courseRepository;



	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public CourseService() {
	}

	public List<Course> getAllCourses(int topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
		
	}
	
	
	public Course getCourse(int id) {
		return courseRepository.findById(id).get() ;
	}


	public void addCourse(Course course) {
		courseRepository.save(course);
	}


	public void updateCourse(Course course) {

		courseRepository.save(course);
	}


	public void deleteCourse(int id) {
		courseRepository.deleteById(id); 
	}

}
