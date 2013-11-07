package com.example.raikkonen.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestClient {

	private String host;

	public RestClient(String host) {
		this.host = host;
	}

	public String get(URI uri) throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(new HttpGet(uri));
		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		String line = "";
		StringBuffer output = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			output.append(line);
		}

		return output.toString();
	}

	public String get(String endpoint) throws URISyntaxException, IOException {
		URIBuilder builder = new URIBuilder().setScheme("http").setHost(host).setPath(endpoint);
		return get(builder.build());
	}

	public String get(String endpoint, Map<String, String> parameters) throws URISyntaxException, IOException {
		URIBuilder builder = new URIBuilder().setScheme("http").setHost(host).setPath(endpoint);

		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			builder.addParameter(entry.getKey(), entry.getValue());
		}

		return get(builder.build());
	}
}
