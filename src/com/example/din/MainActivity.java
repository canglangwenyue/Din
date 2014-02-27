package com.example.din;

import java.util.UUID;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
		
	LocationListener locationListener = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		LocationListener locationListener = new LocationListener() {
			
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
		
		
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000, 0,locationListener);  //定时刷新
	    /*Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	    
	    String latitude = Double.toString(location.getLatitude());//经度
	    String longitude = Double.toString(location.getLongitude());//纬度
	    Toast.makeText(this, latitude+longitude, Toast.LENGTH_LONG).show();*/
	     
	    
	     
	   //获取用户手机机器吗（防止软件被破解的常用方法）需获取READ_PHONE_STATE权限
		final TelephonyManager tm = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
		final String tmDevice, tmSerial, androidId;
		tmDevice = "" + tm.getDeviceId();
		tmSerial = "" + tm.getSimSerialNumber();
		androidId = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
		UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());			String uniqueId = deviceUuid.toString();
		TextView text = (TextView)findViewById(R.id.textView1);
			
		text.setText(uniqueId);
		
	}

	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}


}
