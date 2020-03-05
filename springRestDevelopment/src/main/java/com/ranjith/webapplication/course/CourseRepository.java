package com.ranjith.webapplication.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	List<Course> findByTopicId(String topicId);
	///findBy we can see findall or findby//Topic is a  class variable in the Course// Id is a variable inside Topic class so method name is findByTopicId()

}
