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

public class Registration extends Activity {
	
	
	EditText edtFname,edtEmail,edtPwd,edtCno,edtVeh;
	Button btnReg,btncan;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.registration);
		
		edtFname = (EditText)findViewById(R.id.edtFname);
		edtEmail = (EditText)findViewById(R.id.edtEmail);
		edtCno= (EditText)findViewById(R.id.edtCno);
		edtPwd = (EditText)findViewById(R.id.edtPwd);
		edtVeh = (EditText)findViewById(R.id.edtVeh);		
		btnReg = (Button) findViewById(R.id.btnReg);
		btncan = (Button) findViewById(R.id.btncan);
		btnReg.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				if(android.util.Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches())
				{
			
					 if(edtCno.length() == 10) {
						 if(edtVeh.length() > 1) {
							 if(edtPwd.length() > 5) {
						 
						 new SignUpProc().execute();	
							Intent intent = new Intent(Registration.this, User.class);
							startActivity(intent);
						 }
						 else{
								edtPwd.setError("password is too short");
								 }
					                    }
						 else {
							 edtVeh.setError("number is too short");}
						 }
					 else{
					edtCno.setError("Wrong Mobile Number");
					 }
					 }
				else
				{edtEmail.setError("Not Valid Email ID");}
		
			
			}
		});
	btncan.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		Intent intent = new Intent(Registration.this,MainActivity.class);
		startActivity(intent);
		}
	});
	}

	
	class SignUpProc extends AsyncTask<Void, Void, Void>
	{

		String Fname,email,cno,pwd,vno;
		String out="";
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
			Fname = edtFname.getText().toString();
			email = edtEmail.getText().toString();
			cno= edtCno.getText().toString();
			vno=edtVeh.getText().toString();
			pwd= edtPwd.getText().toString();
			
		}
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub

			try {
				
				URL url = new URL("http://192.168.43.249/SignUp.php?fname=" + Fname + "&email="+ email + "&cno=" + cno +"&vno=" + vno + "&pwd=" + pwd );
				
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
