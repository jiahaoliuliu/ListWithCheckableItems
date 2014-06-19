package com.jiahaoliuliu.listwithcheckableitems;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jiahaoliuliu.listwithcheckableitems.model.Country;

public class SimpleAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater layoutInflater;
	private List<Country> countries;
	
	public SimpleAdapter(Context context, List<Country> countries) {
		this.context = context;
		layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.countries = countries;
	}

	@Override
	public int getCount() {
		return countries.size();
	}

	@Override
	public Object getItem(int position) {
		return countries.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Not use view holder for now
		View itemView = layoutInflater.inflate(R.layout.list_item_layout, parent, false);
		TextView countryNameTextView = (TextView)itemView.findViewById(R.id.countryNameTextView);
		TextView capitalNameTextView = (TextView)itemView.findViewById(R.id.capitalNameTextView);

		Country country = countries.get(position);
		countryNameTextView.setText(country.getCountry());
		capitalNameTextView.setText(country.getCapital());

		return itemView;
	}
}
