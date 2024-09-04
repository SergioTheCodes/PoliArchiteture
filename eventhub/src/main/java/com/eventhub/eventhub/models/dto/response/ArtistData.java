package com.eventhub.eventhub.models.dto.response;

import lombok.Data;

@Data
public class ArtistData {
    private int id;
    private String name;
    private String url;
    private String image_url;
    private String thumb_url;
    private String facebook_page_url;
    private String mbid;
    private int tracker_count;
    private int upcoming_event_count;
}
