package com.jiahaoliuliu.listwithcheckableitems;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import com.jiahaoliuliu.listwithcheckableitems.model.Country;

public class MainActivity extends ListActivity {

	private List<Country> countries;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		countries = generateCountries();

		SimpleAdapter simpleAdapter = new SimpleAdapter(this, countries);
		setListAdapter(simpleAdapter);
	}
	
	private List<Country> generateCountries() {
		// Creates data
		List<Country> countries = new ArrayList<Country>();
		Country spain = new Country("Spain", "Madrid");
		countries.add(spain);
		
		Country italy = new Country("Italy", "Rome");
		countries.add(italy);
		
		Country sweden = new Country("Sweden", "Stockholm");
		countries.add(sweden);
		
		Country austria = new Country("Austria", "Vienna");
		countries.add(austria);
		
		Country belgium = new Country("Belgium", "Brussels");
		countries.add(belgium);
		
		Country croatia = new Country("Croatia", "Zagreb");
		countries.add(croatia);

		Country denmark = new Country("Denmark", "Copenhagen");
		countries.add(denmark);
		
		Country finland = new Country("Finland", "Helsinki");
		countries.add(finland);
		
		Country france = new Country("France", "Paris");
		countries.add(france);
		
		Country germany = new Country("Germany", "Berlin");
		countries.add(germany);
		
		Country greece = new Country("Greece", "Athens");
		countries.add(greece);

		return countries;
	}
}
