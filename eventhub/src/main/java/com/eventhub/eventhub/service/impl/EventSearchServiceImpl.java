package com.eventhub.eventhub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventhub.eventhub.models.dto.request.ClientService;
import com.eventhub.eventhub.models.dto.response.ArtistData;
import com.eventhub.eventhub.models.dto.response.EventData;
import com.eventhub.eventhub.service.IEventSearchService;

@Service
public class EventSearchServiceImpl implements IEventSearchService {

	
	@Autowired
	private ClientService clientService;
    
    @Override
    public List<EventData> getEventsByArtistName(String artistName) {        
        return this.clientService.getEventsByArtistName(artistName);
    }

    @Override
    public ArtistData geArtistDataByName(String artistName) {        
        return this.clientService.getArtistsByName(artistName);
    }
    
    
    
}