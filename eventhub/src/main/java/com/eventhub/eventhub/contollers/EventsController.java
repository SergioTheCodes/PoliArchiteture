package com.eventhub.eventhub.contollers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventhub.eventhub.models.dto.response.ArtistData;
import com.eventhub.eventhub.models.dto.response.EventData;
import com.eventhub.eventhub.service.IEventSearchService;

@RestController
@RequestMapping(value = "/artist")
public class EventsController {
	
	@Autowired
	private IEventSearchService eventSearchService;
	
	
	@GetMapping("/all/{artistName}")
	public List<EventData> validateEventsByArtist(@PathVariable String artistName){
		return this.eventSearchService.getEventsByArtistName(artistName);
	}
	
	@GetMapping("/artistData/{artistName}")
	public ArtistData validateArtistByName(@PathVariable String artistName){
		return this.eventSearchService.geArtistDataByName(artistName);
	}
	

}
