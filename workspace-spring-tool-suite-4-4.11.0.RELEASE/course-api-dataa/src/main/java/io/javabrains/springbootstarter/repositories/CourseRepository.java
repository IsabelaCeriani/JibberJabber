package io.javabrains.springbootstarter.repositories;

import java.util.List;

import io.javabrains.springbootstarter.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	
	List<Course> findByName(String name);

	Iterable<Course> findByTopicId(int topicId);





	

}
