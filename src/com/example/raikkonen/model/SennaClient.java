package com.example.raikkonen.model;

import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;

public class SennaClient {

	private RestClient client;
	private Context context;

	public SennaClient(String host, Context context) {
		this.client = new RestClient(host);
		this.context = context;
	}

	public String getEvent(String id) throws Exception {
//		return client.get("events/" + id);

		AssetManager mgr = context.getAssets();
		InputStream stream = mgr.open("event.json");
		int size = stream.available();
        byte[] buffer = new byte[size];
        stream.read(buffer);
        stream.close();

		return new String(buffer);
	}

	public String searchEvents(String name, String location) throws Exception  {
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("name", name);
//		params.put("location", location);
//		return client.get("search", params);

		AssetManager mgr = context.getAssets();
		InputStream stream = mgr.open("events.json");
		int size = stream.available();
        byte[] buffer = new byte[size];
        stream.read(buffer);
        stream.close();

		return new String(buffer);
	}
}
