package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import models.Event;

@RestController
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	
	public EventService() {
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public Iterable<Event> getEvents() {
		return eventRepository.findAll();
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.POST)
	public String createEvent(@RequestBody Event event) {
		if(event != null)
			eventRepository.save(event);
		return "saved";
	}

}
