package com.example.raikkonen.model;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class EventRepository {

	private SennaClient client;

	public EventRepository(SennaClient client) {
		this.client = client;
	}

	public List<Event> find(double latitude, double longitude) {
		try {
			String location = Double.toString(latitude) + "," + Double.toString(longitude);
			String json = client.searchEvents("", location);
			return createListFromJson(json);
		} catch (Exception e) {
			// not sure how we want to handle REST exceptions
			// delaying that decision for now
			return null;
		}
	}

	private List<Event> createListFromJson(String json) {
		Type listType = new TypeToken<List<Event>>() {}.getType();
        return new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create().fromJson(json, listType);
	}
}
