package com.eventhub.eventhub.service;

import java.util.List;

import com.eventhub.eventhub.models.dto.response.ArtistData;
import com.eventhub.eventhub.models.dto.response.EventData;

public interface IEventSearchService {
   public List<EventData> getEventsByArtistName(String artistName);
   public ArtistData geArtistDataByName(String artistName);
}