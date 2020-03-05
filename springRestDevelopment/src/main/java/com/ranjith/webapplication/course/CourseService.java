package com.ranjith.webapplication.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
//	private List<Topic> topics=new ArrayList<>(Arrays.asList(
//	new Topic("JavaID", "Java", "Java Tough"),
//	new Topic("PythonID", "Python", "Python Tough"),
//	new Topic("SQLID", "SQL", "SQL Tough"),
//	new Topic("AndroidID", "Android", "Android Tough")));
	@Autowired
private CourseRepository courses_repo;
	
	public List<Course> getCourses(String topicId)
	{
		List<Course> courses_all=new ArrayList<>();
		
		
		courses_repo.findByTopicId(topicId).forEach(course->courses_all.add(course));
		
		
		return courses_all;
	}

	public Course getCourse(String id) {
		
		 //topics.stream().filter(topic-> topic.getId().equals(id)).findFirst().get();
		Optional<Course> res=courses_repo.findById(id);
		
		return res.get();
	}

	public Course addCourse(Course course) {
		courses_repo.save(course);
		
		return course;
	}

	public Course updateCourse(String id, Course course) {
	
		/*
		 * for(int i=0;i<topics.size();i++) { if(topics.get(i).getId().equals(id)) {
		 * topics.set(i, topi); } }
		 */
		courses_repo.save(course);
		return course;
	}

	public Course deleteCourse(String id) {
		/*
		 * Topic topice=topics.stream().filter(topic->
		 * topic.getId().equals(id)).findFirst().get(); for(int i=0;i<topics.size();i++)
		 * { if(topics.get(i).getId().equals(id)) { topics.remove(i); } }
		 */
		Optional<Course> res=courses_repo.findById(id);
		Course tp1=res.get();
		courses_repo.deleteById(id);
		
				
		return tp1; //topice;
	}

}
