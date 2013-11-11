package com.example.raikkonen;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raikkonen.model.Event;
import com.example.raikkonen.model.EventRepository;
import com.example.raikkonen.model.SennaClient;

public class EventListFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		SennaClient client = new SennaClient("http://senna.herokuap.com", this.getActivity());
		EventRepository repo = new EventRepository(client);
		List<Event> events = repo.find(getArguments().getDouble("latitude"), getArguments().getDouble("longitude"));

		return inflater.inflate(R.layout.fragment_event_list, container, false);
	}
}
