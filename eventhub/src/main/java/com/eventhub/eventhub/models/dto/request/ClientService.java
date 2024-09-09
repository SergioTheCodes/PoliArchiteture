package com.eventhub.eventhub.models.dto.request;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Collections;

import com.eventhub.eventhub.models.dto.response.EventData;

public class ClientService {
    private final String BaseUrl = "https://rest.bandsintown.com";
    private final String appId = "13722599";
    public List<EventData> getEventsByArtistName(String artistName){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BaseUrl + "/artists/" + artistName)).build();
        client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println).join();
        return null;
    }

    public List<EventData> getArtistInfoByArtistName(String artistName){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BaseUrl + "/artists" + artistName + "/events")).build();
        client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println).join();
        return null;
    }


	public List<EventData> getArtistsByName(String artistName) {
		List<EventData> response = new ArrayList<>();
		try {

			UriComponentsBuilder builder = UriComponentsBuilder
					.fromUriString("https://rest.bandsintown.com")
					.queryParam("app_id", "13722599");
			UriComponents uriComponent = builder.build().encode();
			
			List<EventData> result = WebClient.create().get().uri(uriComponent.toUri() + "/artists" + artistName + "/events")
					.accept(MediaType.APPLICATION_JSON)
					.retrieve().bodyToMono(new ParameterizedTypeReference<List<EventData>>() {
					}).block();
			
			return response;
		} catch (Exception e) {
			System.out.println("Creation resource warning {} " +  e.getMessage());
			System.out.println("Failed " + Collections.emptyList());
			return response;
		}

	}
    
}
