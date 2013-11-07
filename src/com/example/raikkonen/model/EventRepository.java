package com.example.raikkonen.model;

import java.util.List;

public class EventRepository {

	private SennaClient client;

	public EventRepository(SennaClient client) {
		this.client = client;
	}

	public List<Event> find(double latitude, double longitude) {
		try {
			String location = Double.toString(latitude) + "," + Double.toString(longitude);
			String json = client.searchEvents("", location);
			return null;
		} catch (Exception e) {
			// not sure how we want to handle REST exceptions
			return null;
		}
	}
}
