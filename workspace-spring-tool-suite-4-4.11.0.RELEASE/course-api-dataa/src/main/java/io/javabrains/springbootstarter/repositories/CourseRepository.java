package io.javabrains.springbootstarter.repositories;

import java.util.List;

import io.javabrains.springbootstarter.entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	
	public List<Course> findByName(String name);

	public Iterable<Course> findByTopicId(String topicId); 





	

}
