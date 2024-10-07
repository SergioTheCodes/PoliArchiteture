package com.eventhub.eventhub.models.dto.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Collections;

import com.eventhub.eventhub.models.dto.response.ArtistData;
import com.eventhub.eventhub.models.dto.response.EventData;

@Service
public class ClientService {


	public List<EventData> getEventsByArtistName(String artistName) {
		List<EventData> result = new ArrayList<>();
		try {

			UriComponentsBuilder builder = UriComponentsBuilder
					.fromUriString("https://rest.bandsintown.com");
			UriComponents uriComponent = builder.build().encode();
			
			result = WebClient.create().get().uri(uriComponent.toUri() + "/artists/" + artistName + "/events?app_id=13722599")
					.accept(MediaType.APPLICATION_JSON)
					.retrieve().bodyToMono(new ParameterizedTypeReference<List<EventData>>() {
					}).block();
			System.out.println("result====> " + result.get(0));
			return result;
		} catch (Exception e) {
			System.out.println("Creation resource warning {} " +  e.getMessage());
			System.out.println("Failed " + Collections.emptyList());
			return result;
		}

	}
	
	public ArtistData getArtistsByName(String artistName) {
		ArtistData result = new ArtistData();
		try {

			UriComponentsBuilder builder = UriComponentsBuilder
					.fromUriString("https://rest.bandsintown.com");
					//.queryParam("app_id", "13722599");
			UriComponents uriComponent = builder.build().encode();
			
			result = WebClient.create().get().uri(uriComponent.toUri() + "/artists/" + artistName + "?app_id=13722599")
					.accept(MediaType.APPLICATION_JSON)
					.retrieve().bodyToMono(new ParameterizedTypeReference<ArtistData>() {
					}).block();
			System.out.println("result====> " + result);
			return result;
		} catch (Exception e) {
			System.out.println("Creation resource warning {} " +  e.getMessage());
			System.out.println("Failed " + Collections.emptyList());
			return result;
		}

	}
    
}
