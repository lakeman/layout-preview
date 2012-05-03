package org.servalproject.test;

import java.lang.reflect.Field;

import org.servalproject.test.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LayoutList extends ListActivity {
	ArrayAdapter<Resource> adapter;

	private class Resource {
		int id;
		String name;

		private Resource(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		adapter = new ArrayAdapter<Resource>(this,
				android.R.layout.simple_list_item_1);
		Field fields[] = R.layout.class.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				adapter.add(new Resource(fields[i].getInt(null), fields[i]
						.getName()));
			} catch (Exception e) {
				Log.e("BatPhone", e.toString(), e);
			}
		}
		this.setListAdapter(adapter);

		ListView lv = getListView();

		// TODO Long click listener for more options, eg text message
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Resource r = adapter.getItem(position);
				Intent intent = new Intent(LayoutList.this, LayoutPreview.class);
				intent.putExtra("resource", r.id);
				startActivity(intent);
			}
		});
	}

}
