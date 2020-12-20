package com.example.parking;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Payment extends Activity {

	Button btncan,btnpro;
	EditText edtarr,edtarr1,edtid;
	TextView txt1,txtpr,txt3;
	String locationname,slotno,locationid,price,uid;
	String arrdate,arrtime,Tid;
	String email;
	int RandomAttack;
	int mYear,mMonth,mDay;
	 static final int DATE_DIALOG_ID = 0;
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment);	
		 Calendar c=Calendar.getInstance();
	        mYear=c.get(Calendar.YEAR);
	        mMonth=c.get(Calendar.MONTH);
	        mDay=c.get(Calendar.DAY_OF_MONTH);
		
		 btncan= (Button) findViewById(R.id.btncan);
		 btnpro = (Button) findViewById(R.id.btnpro);
		 edtarr = (EditText)findViewById(R.id.edtarr);
		 edtid = (EditText)findViewById(R.id.edtid);
			 edtarr1 = (EditText)findViewById(R.id.edtarr1);
			 txt1=(TextView)findViewById(R.id.txt1);
			 txtpr=(TextView)findViewById(R.id.txtpr);
			txt3 = (TextView)findViewById(R.id.txt3);
			 
			 Intent i=getIntent();
			 locationname = i.getExtras().getString("locationname");
			
			 price = i.getExtras().getString("price");
					
			 slotno = i.getExtras().getString("slotno");
			 
			locationid = i.getExtras().getString("locationid");
			uid = i.getExtras().getString("uid");
			
			//Toast.makeText(Payment.this, uid, Toast.LENGTH_LONG).show();
			
			
			txtpr.setText("Price:"+price);
			 txt1.setText(locationname);
			 txt3.setText("User ID:"+uid);
			 
			for (int j=1;j<=1;j++)
			{
				RandomAttack = (int) Math.random()*20;
				
			}
			edtid.setText(RandomAttack);
			
			 edtarr.setOnClickListener(new OnClickListener() {
				   final long today = System.currentTimeMillis() - 1000;
				   Calendar c = Calendar.getInstance();
				 int mYear = c.get(Calendar.YEAR);
				 int mMonth = c.get(Calendar.MONTH);
				 int mDay = c.get(Calendar.DAY_OF_MONTH);	
			
				 
				 @Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
				DatePickerDialog.OnDateSetListener dpd = new OnDateSetListener() {              
			                @Override
			                public void onDateSet(DatePicker view, int year, int monthOfYear,
			                        int dayOfMonth) {

			                                                    
			                    if (c.getTimeInMillis() < today)
			                    {
			                        //Make them try again

			                       Toast.makeText(Payment.this, "Invalid date, please try again", Toast.LENGTH_LONG).show();
			                    }
			                    else
			                    {
			                        //success
			                    	int s=monthOfYear+1;                                    
				                    String a = dayOfMonth+"/"+s+"/"+year;                   
				                    edtarr.setText(""+a); 
			                    }
			                }
			            };

			         
			            DatePickerDialog d = new DatePickerDialog(Payment.this, dpd, mYear ,mMonth, mDay);
			            d.show();	 	
			            
				}
			});
			 edtarr1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Calendar mcurrentTime = Calendar.getInstance();
		            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
		            int minute = mcurrentTime.get(Calendar.MINUTE);
		            TimePickerDialog mTimePicker;
		            mTimePicker = new TimePickerDialog(Payment.this, new TimePickerDialog.OnTimeSetListener() {
		                @Override
		                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
		                    edtarr1.setText( selectedHour + ":" + selectedMinute);
		                }
		            }, hour, minute, true);//Yes 24 hour time
		            mTimePicker.setTitle("Select Time");
		            mTimePicker.show();
					
				}
			});
			 
			btnpro.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					if(edtid.length() > 0){
						new Pay().execute();
					}
				}
			}) ;
			btncan.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Payment.this, ViewParking.class);
					intent.putExtra("locationname",locationname);
					intent.putExtra("locationid",locationid);
					intent.putExtra("slotno",slotno);
					intent.putExtra("price",price);
					startActivity(intent);
				}
			});
	}

	
	class Pay extends AsyncTask<Void, Void, Void>
	{

		
		String out="";
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
		
			arrdate= edtarr.getText().toString();
			arrtime=edtarr1.getText().toString();
			 Tid= edtid.getText().toString();
			
		}
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub

			try {
				
				URL url = new URL("http://192.168.43.249/pay.php?price= "+ price +"&arrdate=" + arrdate + "&arrtime="+ arrtime + "&Tid=" + Tid+"&locationid="+locationid+"&slotno="+slotno + "&locationname=" +locationname + "&uid="+ uid);
				
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
			//Toast.makeText(Payment.this, arrdate+arrtime+Tid, Toast.LENGTH_LONG).show();
			
			AlertDialog alertDialog = new AlertDialog.Builder(Payment.this).create();
			alertDialog.setTitle("Success");
			alertDialog.setMessage("Your request has been proceded");
			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "DONE",
				new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					   Intent intent = new Intent(Payment.this, MapAct.class);
			            startActivity(intent);
					dialog.dismiss();
         
        }
    });
alertDialog.show();
			Toast.makeText(getApplicationContext(), out, Toast.LENGTH_LONG).show();
		}
	
	}

}

