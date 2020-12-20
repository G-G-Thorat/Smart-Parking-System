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

public class mydetails extends Activity{
	 String id,name,mail,cno1,vno1,pwd1;
	
	String email;
	
	TextView tvNm,tvEm,tvCn,tvPw,tvN;
	Button btnback;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.mydetails);
		
		tvNm = (TextView) findViewById(R.id.tvNm);
		tvEm = (TextView) findViewById(R.id.tvEm);
		tvCn = (TextView) findViewById(R.id.tvCn);
		tvPw = (TextView) findViewById(R.id.tvPw);
		tvN = (TextView) findViewById(R.id.tvN);
		btnback = (Button) findViewById(R.id.btnback);
		Intent intent = getIntent();
		
		email = intent.getExtras().getString("email");
		new Mydetails().execute();
		btnback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mydetails.this,user1.class);
				startActivity(intent);
			}
		});
		
	}
	
	class Mydetails extends AsyncTask<Void, Void, Void>
	{
		
		String out="";

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
		
		}
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub

			try {
				
				URL url = new URL("http://192.168.43.249/mydetails.php?email=" + email);
				
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
		out = out.substring(0,out.length()-1);
				String[] output = out.split(":");
			// Toast.makeText(mydetails.this, output[0]+output[1]+output[2]+output[3]+output[4], Toast.LENGTH_LONG).show();
		     tvNm.setText(output[0]);
             tvEm.setText(output[1]);
             tvCn.setText(output[2]);
             tvN.setText(output[3]);
             tvPw.setText(output[4]);
             
  
		   }
	}
}
