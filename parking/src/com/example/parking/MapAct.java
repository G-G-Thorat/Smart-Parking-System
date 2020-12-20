package com.example.parking;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Dialog;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapAct extends FragmentActivity implements LocationListener{
	
	GoogleMap mGoogleMap;		
	String name;
	String uid;
	String location,nslot,longitude,latitude;
	double mLatitude=0;
	double mLongitude=0;
	
	  ArrayList<String> loc = new ArrayList<String>();
	  ArrayList<String> nslotAl = new ArrayList<String>();
      ArrayList<String> longi = new ArrayList<String>();
      ArrayList<String> latti = new ArrayList<String>();
      ArrayList<String> id1 = new ArrayList<String>();
      ArrayList<String> price = new ArrayList<String>();
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);	
		Intent i=getIntent();
		uid = i.getExtras().getString("uid");
		
		 new SignUpProc().execute();

		try
		{
			
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
        
        if(status!=ConnectionResult.SUCCESS){ 
        	int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this, requestCode);
            dialog.show();
            Toast.makeText(MapAct.this, "Select Nearest Area For Parking", Toast.LENGTH_LONG).show();
            

        }else { 
	    	SupportMapFragment fragment = ( SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);	    	

	    	mGoogleMap = fragment.getMap();
	    	mGoogleMap.setMyLocationEnabled(true);
	    	
	    	LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
	    	Criteria criteria = new Criteria();
	    	String provider = locationManager.getBestProvider(criteria, true);
            Location location = locationManager.getLastKnownLocation(provider);
            
            
            if(location!=null){
                    onLocationChanged(location);
            }
            locationManager.requestLocationUpdates(provider, 20000, 0, this);
        }
		}
catch (Exception e) {
	// TODO: handle exception
	//Toast.makeText(getApplicationContext(), e.printStackTrace(), Toast.LENGTH_LONG)
	Toast.makeText(getApplicationContext(), "ERROR:" + e.toString(), Toast.LENGTH_LONG).show();
}
		}
		
	
	@Override
	public void onLocationChanged(Location location) {
		mLatitude = location.getLatitude();
		mLongitude = location.getLongitude();
		LatLng latLng = new LatLng(mLatitude, mLongitude);
		
		mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
		mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
		
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
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}	

	class SignUpProc extends AsyncTask<Void, Void, Void>
	{

		
		String out="";
		String idslot;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
		
		}
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub

			try {
				
				URL url = new URL("http://192.168.43.249/sample.php?location=" + location + "&nslot="+ nslot + "&longitude=" + longitude + "&latitude=" + latitude);
				
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				
				InputStream is  = new BufferedInputStream(connection.getInputStream());
				
				int ch;
				do
				{
					ch = is.read();
					
					if(ch=='\n')
						break;
					out += (char)ch;
									
					
				}while(ch!=-1);
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			
			 try {  
                 // Create the root JSONObject from the JSON string.  
               JSONObject  jsonRootObject = new JSONObject(out);  

               //Get the instance of JSONArray that contains JSONObjects  
                JSONArray jsonArray = jsonRootObject.optJSONArray("aa");  
                 
                //Iterate the jsonArray and print the info of JSONObjects  
                for(int i=0; i < jsonArray.length(); i++){  
                    JSONObject jsonObject = jsonArray.getJSONObject(i);  
                    String id2 = jsonObject.optString("id").toString();
                    String noslot = jsonObject.optString("nslot").toString();
                    String loc1 = jsonObject.optString("location").toString();
                    String longi1 = jsonObject.optString("longitude").toString(); 
                    String latti1 = jsonObject.optString("latitude").toString();
                    String price1 = jsonObject.optString("price").toString();
                    //data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
                    id1.add(id2);
                   	loc.add(loc1);
	            	nslotAl.add(noslot);
	                longi.add(longi1);
	                latti.add(latti1);

	                price.add(price1);
	     
                  }  
                //out.setText(data);  
                
                
             } catch (JSONException e) {e.printStackTrace();}  
			 
			
		                
		    /*            
		    try
		    {
			
		    Toast.makeText(MapAct.this, latti.size()+"", Toast.LENGTH_LONG).show();
		    }
		    catch(Exception e){
		    	 Toast.makeText(MapAct.this, "error", Toast.LENGTH_LONG).show();
		    }*/
		    
		    
try{
		for(int i=0;i<latti.size();i++)
		{
		
		MarkerOptions markerOptions = new MarkerOptions();
               
        double lat = Double.parseDouble(latti.get(i));	            
                
        double lng = Double.parseDouble(longi.get(i));
        
         name = loc.get(i);
         String id3=id1.get(i);
         String price2=price.get(i);
        
        String nslots = nslotAl.get(i);
        
        LatLng latLng1 = new LatLng(lng, lat);
        
        markerOptions.position(latLng1);

       idslot=nslots+":"+id3+":"+price2+":"+name;
        markerOptions.title(nslots+":"+id3+":"+price2+":"+name);	            

        mGoogleMap.addMarker(markerOptions);
       // Toast.makeText(MapAct.this, lat+":"+lng, Toast.LENGTH_LONG).show();
       // Toast.makeText(MapAct.this, uid, Toast.LENGTH_LONG).show();
        mGoogleMap.setOnMarkerClickListener(new OnMarkerClickListener() {
			
			@Override
			public boolean onMarkerClick(Marker arg0) {
				// TODO Auto-generated method stub
			//	Toast.makeText(MapAct.this, arg0.getTitle(), Toast.LENGTH_LONG).show();
				Intent intent = new Intent(MapAct.this, Slotavail.class);
    			intent.putExtra("idslot",arg0.getTitle());
    			intent.putExtra("uid",uid);
    			
    	//		 Toast.makeText(MapAct.this, name, Toast.LENGTH_LONG).show();
   			  
    			
			startActivity(intent);
				return false;
			}
		});
    
		}
}catch(Exception ex){
	
}
	}
}
	
		
	
}
