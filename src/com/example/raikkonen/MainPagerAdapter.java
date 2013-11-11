package com.example.raikkonen;

import java.util.Locale;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {
	private MainActivity activity;

	public MainPagerAdapter(FragmentManager fm, MainActivity activity) {
		super(fm);
		this.activity = activity;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = null;

		switch (position) {
		case 0:
			fragment = new EventListFragment();
			Bundle args = new Bundle();
			Location location = activity.getLocation();
			if (location != null) {
				args.putDouble("latitude", activity.getLocation().getLatitude());
				args.putDouble("longitude", activity.getLocation().getLongitude());
			}
			fragment.setArguments(args);
			break;
		case 1:
			fragment = new EventListFragment();
			break;
		case 2:
			fragment = new EventListFragment();
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		//return 3;
		return 1;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		String title = null;
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			title = activity.getString(R.string.title_section1).toUpperCase(l);
			break;
		case 1:
			title = activity.getString(R.string.title_section2).toUpperCase(l);
			break;
		case 2:
			title = activity.getString(R.string.title_section3).toUpperCase(l);
			break;
		}
		return title;
	}

}
