package com.ranjith.webapplication.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
//	private List<Topic> topics=new ArrayList<>(Arrays.asList(
//	new Topic("JavaID", "Java", "Java Tough"),
//	new Topic("PythonID", "Python", "Python Tough"),
//	new Topic("SQLID", "SQL", "SQL Tough"),
//	new Topic("AndroidID", "Android", "Android Tough")));
	@Autowired
private TopicRepository topics_repo;
	
	public List<Topic> getTopics()
	{
		List<Topic> topics_all=new ArrayList<>();
		
		
		topics_repo.findAll().forEach(topic->topics_all.add(topic));
		
		
		return topics_all;
	}

	public Topic getTopic(String id) {
		
		 //topics.stream().filter(topic-> topic.getId().equals(id)).findFirst().get();
		Optional<Topic> res=topics_repo.findById(id);
		
		return res.get();
	}

	public Topic addTopic(Topic topic) {
		topics_repo.save(topic);
		
		return topic;
	}

	public Topic updateTopic(String id, Topic topic) {
	
		/*
		 * for(int i=0;i<topics.size();i++) { if(topics.get(i).getId().equals(id)) {
		 * topics.set(i, topi); } }
		 */
		topics_repo.save(topic);
		return topic;
	}

	public Topic deleteTopic(String id) {
		/*
		 * Topic topice=topics.stream().filter(topic->
		 * topic.getId().equals(id)).findFirst().get(); for(int i=0;i<topics.size();i++)
		 * { if(topics.get(i).getId().equals(id)) { topics.remove(i); } }
		 */
		Optional<Topic> res=topics_repo.findById(id);
		Topic tp1=res.get();
		topics_repo.deleteById(id);
		
				
		return tp1; //topice;
	}

}
