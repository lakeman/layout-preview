package org.servalproject.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class LayoutPreview extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		try {
			this.setContentView(getIntent().getIntExtra("resource", 0));
		} catch (Exception e) {
			Log.e("BatPhone", e.toString(), e);
			Toast toast = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
			toast.show();
			finish();
		}
	}

}
