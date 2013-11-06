package com.example.raikkonen;

import java.util.Locale;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagerAdapter extends FragmentPagerAdapter {
	private Context context;

	public MainPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		this.context = context;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment fragment = null;

		switch (position) {
		case 0:
			fragment = new EventListFragment();
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
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		String title = null;
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			title = context.getString(R.string.title_section1).toUpperCase(l);
			break;
		case 1:
			title = context.getString(R.string.title_section2).toUpperCase(l);
			break;
		case 2:
			title = context.getString(R.string.title_section3).toUpperCase(l);
			break;
		}
		return title;
	}

}
