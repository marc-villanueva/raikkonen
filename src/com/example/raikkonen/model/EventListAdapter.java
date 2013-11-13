package com.example.raikkonen.model;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raikkonen.R;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

public class EventListAdapter extends ArrayAdapter<Event> {

	private List<Event> events;

	public EventListAdapter(Context context, int resource) {
		super(context, resource);
		// TODO Auto-generated constructor stub
	}

	public EventListAdapter(Context context, int resource, List<Event> events) {
	    super(context, resource, events);
	    this.events = events;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if (null == view) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			view = inflater.inflate(R.layout.fragment_event_list_item, null);
		}

		Event event = events.get(position);
		if (event != null) {
			ImageView imageView = (ImageView) view.findViewById(R.id.eventImage);
			TextView titleView = (TextView) view.findViewById(R.id.eventTitle);
			TextView dateView = (TextView) view.findViewById(R.id.eventDate);
			TextView descriptionView = (TextView) view.findViewById(R.id.eventDescription);

			UrlImageViewHelper.setUrlDrawable(imageView, event.getImage());
			titleView.setText(event.getName());

			SimpleDateFormat format = new SimpleDateFormat("EEE, MMM dd yyyy", Locale.US);
			String date = format.format(event.getStart());
			String end = format.format(event.getEnd());
			if (!date.equals(end)) {
				date += " - " + end;
			}
			dateView.setText(date);
			descriptionView.setText(event.getDescription());
		}
		return view;
	}


}
