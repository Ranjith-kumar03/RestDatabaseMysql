package com.ranjith.webapplication.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicData;
	
	@GetMapping("/topics")
	public List<Topic> getTopics()
	{
		return topicData.getTopics();
	}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicData.getTopic(id);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public Topic addTopic(@RequestBody Topic topic)
	{
		return topicData.addTopic(topic);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public Topic updateTopic(@PathVariable String id,@RequestBody Topic topic)
	{
		return topicData.updateTopic(id,topic);
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public Topic deleteTopic(@PathVariable String id)
	{
		return topicData.deleteTopic(id);
	}
}
