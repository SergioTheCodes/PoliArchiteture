package com.eventhub.eventhub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eventhub.eventhub.models.dto.response.ArtistData;
import com.eventhub.eventhub.models.dto.response.EventData;

@Service
public class EventSearchServiceImpl implements IEventSearchService {

    
    @Override
    public List<EventData> getEventsByArtistName(String artistName) {
        
        return null;
    }

    @Override
    public ArtistData geArtistDataByName(String artistName) {
        
        return null;
    }
    
}