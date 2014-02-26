package com.example.din;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LocationListener mLocationListener = null;
		
		
		
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
mLocationListener = new LocationListener() {
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				if (location!=null) {
					String strlog = String.format("我当前的位置信息:\r\n" +
							"纬度:%f\r\n" +
							"经度:%f",
							 location.getLatitude(),location.getLongitude());
					 Toast.makeText(MainActivity.this, strlog, Toast.LENGTH_SHORT).show();
				}
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000, 0,mLocationListener);  
	     Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	     if(location!=null)  {
	     double latitude = location.getLatitude();     //经度   
	     double longitude = location.getLongitude(); //纬度   
	     double altitude =  location.getAltitude();     //海拔  
	     
	    // String ls = String.valueOf(latitude);
	     //String lo = String.valueOf(longitude);

	    // Log.v("tag", "latitude " + latitude + "  longitude:" + longitude + " altitude:" + altitude);
	     //Toast.makeText(this, ls+lo, Toast.LENGTH_LONG).show();
	     }
	     finish();
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
