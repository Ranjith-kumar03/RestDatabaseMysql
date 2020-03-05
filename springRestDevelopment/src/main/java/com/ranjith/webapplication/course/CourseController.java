package com.ranjith.webapplication.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ranjith.webapplication.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseData;
	
	@GetMapping("/topics/{id}/courses")
	public List<Course> getCourses(@PathVariable String id)
	{
		return courseData.getCourses(id);
	}
	@RequestMapping("/topics/{topicid}/courses/{id}")
	public Course getCourse(@PathVariable String id)
	{
		return courseData.getCourse(id);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicid}/courses")
	public Course addTopic(@RequestBody Course course,@PathVariable String topicid)
	{  course.setTopic(new Topic(topicid,"",""));
		return courseData.addCourse(course);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicid}/courses/{id}")
	public Course updateTopic(@RequestBody Course course,@PathVariable String topicid,@PathVariable String id)
	{
		 course.setTopic(new Topic(topicid,"",""));
		return courseData.updateCourse(id,course);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicid}/courses/{id}")
	public Course deleteCourse(@PathVariable String id)
	{
		return courseData.deleteCourse(id);
	}
}
