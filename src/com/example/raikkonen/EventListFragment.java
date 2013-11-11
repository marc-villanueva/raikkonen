package com.example.raikkonen;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.example.raikkonen.model.Event;
import com.example.raikkonen.model.EventRepository;
import com.example.raikkonen.model.SennaClient;

public class EventListFragment extends ListFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SennaClient client = new SennaClient("http://senna.herokuap.com", this.getActivity());
		EventRepository repo = new EventRepository(client);
		List<Event> events = repo.find(getArguments().getDouble("latitude"), getArguments().getDouble("longitude"));

		ListAdapter myListAdapter = new ArrayAdapter<Event>(
		    getActivity(),
		    android.R.layout.simple_list_item_1,
		    events);

		setListAdapter(myListAdapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_event_list, container, false);
	}
}
