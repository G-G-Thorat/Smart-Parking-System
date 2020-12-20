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

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class View extends Activity{
	String uid;
	Button btn1;
	ListView lstview;
	ArrayList<String> idAL = new ArrayList<String>();
	ArrayList<String> locationidAL = new ArrayList<String>();
    ArrayList<String> slotnoAL = new ArrayList<String>();
    ArrayList<String> statusAL = new ArrayList<String>();
    ArrayList<String> priceAL = new ArrayList<String>();
    ArrayList<String> locationAL = new ArrayList<String>();
    String id,locationid,slotno,status,price,location;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		try
		{
			super.onCreate(savedInstanceState);
		
		setContentView(R.layout.view);	
		
		}
		catch(Exception ex)
		{//
		
		}
		//Intent i=getIntent();
		 //uid = i.getExtras().getString("uid");
		//btn1 = (Button) findViewById(R.id.btn1);
		 //lstview = (ListView) findViewById( R.id.lstview ); 
		// new Fetchslot().execute();
			
	}
	class Fetchslot extends AsyncTask<Void, Void, Void>
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
				
				URL url = new URL("http://192.168.43.102/Slotinfo1.php?&locationid="+ locationid + "&slotno=" + slotno + "&status=" + status+ "&location=" + location+ "&price=" + price);
								
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
			  //Toast.makeText(Slotavail.this, locationid, Toast.LENGTH_LONG).show();
              
			
			 try {  
                 // Create the root JSONObject from the JSON string.  
               JSONObject  jsonRootObject = new JSONObject(out);  

               //Get the instance of JSONArray that contains JSONObjects  
                JSONArray jsonArray = jsonRootObject.optJSONArray("aa");  
                 
                //Iterate the jsonArray and print the info of JSONObjects  
                for(int i=0; i < jsonArray.length(); i++){  
                    JSONObject jsonObject = jsonArray.getJSONObject(i);  
                    String id2 = jsonObject.optString("id").toString();
                    
                    String locationid2 = jsonObject.optString("locationid").toString();
                    String status2 = jsonObject.optString("status").toString(); 
                    String slotno2 = jsonObject.optString("slotno").toString();
                    String location2 = jsonObject.optString("location").toString();
                    String price2 = jsonObject.optString("price").toString();
                    //data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
                    idAL.add(id2);
                   	locationidAL.add(locationid2);
	            	slotnoAL.add(slotno2);
	                statusAL.add(status2);
	                locationAL.add(location2);
	                priceAL.add(price2);
	                Toast.makeText(getApplicationContext(), id2+locationid2+location2+slotno2+status2 , Toast.LENGTH_LONG).show();	                priceAL.add(price2);
	                
                  } 
                
                ArrayAdapter<String> adapter =new ArrayAdapter<String>(View.this, android.R.layout.simple_list_item_1,slotnoAL);
                lstview.setAdapter(adapter);
                } 
			 catch (JSONException e) {
				 Toast.makeText(View.this, e.toString() , Toast.LENGTH_LONG).show();	                
             }  
			 
		}
	}
}
