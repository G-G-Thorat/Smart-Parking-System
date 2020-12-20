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
import android.widget.EditText;
import android.widget.Toast;

public class User extends Activity {
Button btnLogin,btncan;
EditText edtEmail,edtPwd;
String uid;


@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.user);
		
		 btnLogin= (Button) findViewById(R.id.btnLogin);
	        btncan = (Button)findViewById(R.id.btncan);
	        edtEmail = (EditText)findViewById(R.id.edtEmail);
	        edtPwd = (EditText)findViewById(R.id.edtPwd);
	        
	        btnLogin.setOnClickListener(new OnClickListener() {
				
	        
	        	@Override
	        	
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
	        		new verifylogin().execute();
	 
	        	}
			});
	        
	      btncan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(User.this,MainActivity.class);
				startActivity(intent);
			}
		});
	}

	class verifylogin extends AsyncTask<Void, Void, Void>
	{

		String email,pwd;
		String out="";				
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			email = edtEmail.getText().toString();
			pwd = edtPwd.getText().toString();
		
		}
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub

			try {
				
				URL url = new URL("http://192.168.43.249/test1.php?email="+ email + "&pass=" + pwd);
				
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
				
				  uid = out;	
				
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
			
			
			String ch = out.substring(0,out.length()-1);
			int temp = Integer.parseInt(ch +"");
			//Toast.makeText(User.this, ch , Toast.LENGTH_SHORT).show();	
	
			if(temp>0)
    		{					
    			Intent intent = new Intent(User.this, user1.class);
    			intent.putExtra("email", edtEmail.getText().toString());
        		intent.putExtra("temp",""+temp);
        		startActivity(intent);
    		}
    	
    	else
    	{
    		Toast.makeText(getApplicationContext(), "Invalid User:" , Toast.LENGTH_SHORT).show();
			    		
    	}
		
			//	Toast.makeText(User.this, temp , Toast.LENGTH_SHORT).show();
			
		
		}
	
	}
}
