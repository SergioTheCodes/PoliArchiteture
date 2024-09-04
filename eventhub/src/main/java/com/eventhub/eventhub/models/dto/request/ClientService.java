package com.eventhub.eventhub.models.dto.request;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

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
}
