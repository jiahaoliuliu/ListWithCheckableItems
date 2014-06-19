package com.jiahaoliuliu.listwithcheckableitems;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.jiahaoliuliu.listwithcheckableitems.model.Country;

public class SimpleAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater layoutInflater;
	private List<Country> countries;
	
	private int checkedPosition = -1;

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
	public View getView(final int position, View convertView, ViewGroup parent) {
		// Not use view holder for now
		View itemView = layoutInflater.inflate(R.layout.list_item_layout, parent, false);
		TextView countryNameTextView = (TextView)itemView.findViewById(R.id.countryNameTextView);
		TextView capitalNameTextView = (TextView)itemView.findViewById(R.id.capitalNameTextView);
		CheckBox selectionCheckBox = (CheckBox)itemView.findViewById(R.id.selectionCheckBox);
		
		Country country = countries.get(position);
		countryNameTextView.setText(country.getCountry());
		capitalNameTextView.setText(country.getCapital());

		selectionCheckBox.setChecked(position == checkedPosition);

		selectionCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					checkedPosition = position;
				} else {
					checkedPosition = -1;
				}
				notifyDataSetChanged();
			}
		});
		return itemView;
	}

	public int getCheckedPosition() {
		return checkedPosition;
	}

	public void setCheckedPosition(int checkedPosition) {
		this.checkedPosition = checkedPosition;
	}
}
