package com.example.parking;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewParking extends Activity{
	String locationname,price,slotno,locationid;
	Button btnpay,btncan;
	TextView txt1,txt2,txt3;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewparking);
		btnpay = (Button)findViewById(R.id.btnpay);
		btncan = (Button)findViewById(R.id.btncan);
		txt1=(TextView)findViewById(R.id.txt1);
		txt2=(TextView)findViewById(R.id.txt2);
		txt3=(TextView)findViewById(R.id.txt3);
		 Intent i=getIntent();
		 locationname = i.getExtras().getString("locationname");
		
		 price = i.getExtras().getString("price");
		
		 locationid = i.getExtras().getString("locationid");
		 slotno = i.getExtras().getString("slotno");
		 txt1.setText("LocationName:"+locationname);
		 txt2.setText("Slotno:"+slotno);
		 txt3.setText("Price:"+price);
		 
		btnpay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(ViewParking.this, Payment.class);
				startActivity(intent);
			}
		});
		
		btncan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new Reset().execute();
			}
		});
	
	}
	class Reset extends AsyncTask<Void, Void, Void>
	{

		
		String out="";
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			Intent intent = new Intent(ViewParking.this,user1.class);
			startActivity(intent);
			
			
		}
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub

			try {
				
				URL url = new URL("http://192.168.43.249/Reset.php?locationid=" + locationid  + "&slotno="+ slotno);
				
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
			
			
			Toast.makeText(getApplicationContext(), out, Toast.LENGTH_LONG).show();
		}
	
	}
}
