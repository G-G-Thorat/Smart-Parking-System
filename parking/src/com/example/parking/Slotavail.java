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
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Slotavail extends Activity {
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	  ArrayList<String> idAL = new ArrayList<String>();
	  ArrayList<String> locationidAL = new ArrayList<String>();
      ArrayList<String> slotnoAL = new ArrayList<String>();
      ArrayList<String> statusAL = new ArrayList<String>();
      String id,locationid,slotno,status,price,uid;
      String rowid;
      String locationname;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.slotavail);
		b1 = (Button) findViewById(R.id.btn1);
		b2 = (Button) findViewById(R.id.btn2);
		b3 = (Button) findViewById(R.id.btn3);
		b4 = (Button) findViewById(R.id.btn4);
		b5 = (Button) findViewById(R.id.btn5);
		b6 = (Button) findViewById(R.id.btn6);
		b7 = (Button) findViewById(R.id.btn7);
		b8 = (Button) findViewById(R.id.btn8);
		b9 = (Button) findViewById(R.id.btn9);
		b10 = (Button) findViewById(R.id.btn10);
		
		b1.setVisibility(View.GONE);
		b2.setVisibility(View.GONE);
		b3.setVisibility(View.GONE);
		b4.setVisibility(View.GONE);
		b5.setVisibility(View.GONE);
		b6.setVisibility(View.GONE);
		b7.setVisibility(View.GONE);
		b8.setVisibility(View.GONE);
		b9.setVisibility(View.GONE);
		b10.setVisibility(View.GONE);
		
		Intent i=getIntent();
		
		String idslot = i.getExtras().getString("idslot");
		 uid = i.getExtras().getString("uid");
		String[] temp= idslot.split(":");
		int noslot = Integer.parseInt(temp[0]);
		locationid=temp[1];
		locationname=temp[3];
		price = temp[2];
		
		if(noslot==1)
		{
			b1.setVisibility(View.VISIBLE);
		}
		if(noslot==2)
		{
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.VISIBLE);
		}
		if(noslot==3)
		{
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.VISIBLE);
			b3.setVisibility(View.VISIBLE);
		}
		if(noslot==4)	
		{
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.VISIBLE);
			b3.setVisibility(View.VISIBLE);
			b4.setVisibility(View.VISIBLE);
		}
		if(noslot==5)
		{
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.VISIBLE);
			b3.setVisibility(View.VISIBLE);
			b4.setVisibility(View.VISIBLE);
			b5.setVisibility(View.VISIBLE);
		}
		if(noslot==6)
		{
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.VISIBLE);
			b3.setVisibility(View.VISIBLE);
			b4.setVisibility(View.VISIBLE);
			b5.setVisibility(View.VISIBLE);
			b6.setVisibility(View.VISIBLE);
		}
		
		if(noslot==7)
		{
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.VISIBLE);
			b3.setVisibility(View.VISIBLE);
			b4.setVisibility(View.VISIBLE);
			b5.setVisibility(View.VISIBLE);
			b6.setVisibility(View.VISIBLE);
			b7.setVisibility(View.VISIBLE);
		}
		if(noslot==8)
		{
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.VISIBLE);
			b3.setVisibility(View.VISIBLE);
			b4.setVisibility(View.VISIBLE);
			b5.setVisibility(View.VISIBLE);
			b6.setVisibility(View.VISIBLE);
			b7.setVisibility(View.VISIBLE);
			b8.setVisibility(View.VISIBLE);

		}
		if(noslot==9)
		{
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.VISIBLE);
			b3.setVisibility(View.VISIBLE);
			b4.setVisibility(View.VISIBLE);
			b5.setVisibility(View.VISIBLE);
			b6.setVisibility(View.VISIBLE);
			b7.setVisibility(View.VISIBLE);
			b8.setVisibility(View.VISIBLE);
			b9.setVisibility(View.VISIBLE);
		}
		if(noslot==10)
		{
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.VISIBLE);
			b3.setVisibility(View.VISIBLE);
			b4.setVisibility(View.VISIBLE);
			b5.setVisibility(View.VISIBLE);
			b6.setVisibility(View.VISIBLE);
			b7.setVisibility(View.VISIBLE);
			b8.setVisibility(View.VISIBLE);
			b9.setVisibility(View.VISIBLE);
			b10.setVisibility(View.VISIBLE);
		}
		new Fetchslot().execute();
		
		
		//Toast.makeText(Slotavail.this, slotno, Toast.LENGTH_LONG).show();
		//Toast.makeText(Slotavail.this, uid, Toast.LENGTH_LONG).show();
		   
		
		
		b1.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			rowid = idAL.get(0);
			new Updatestatus().execute();
			b1.setEnabled(false);
			
			Intent intent = new Intent(Slotavail.this, Payment.class);
			intent.putExtra("locationid",locationid);
			intent.putExtra("slotno","1");
			intent.putExtra("price",price);
			intent.putExtra("uid",uid);
			intent.putExtra("locationname",locationname);
			
			 //Toast.makeText(Slotavail.this, locationname, Toast.LENGTH_LONG).show();
			    
		startActivity(intent);
		
			}
		});
		
		
		b2.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			rowid = idAL.get(1);
			new Updatestatus().execute();
			b2.setEnabled(false);
			Intent intent = new Intent(Slotavail.this, Payment.class);
			intent.putExtra("locationid",locationid);
			intent.putExtra("locationname",locationname);
			intent.putExtra("slotno","2");
			intent.putExtra("price",price);
			intent.putExtra("uid",uid);
			startActivity(intent);
			}
		});
		b3.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			rowid = idAL.get(2);
			new Updatestatus().execute();
			b3.setEnabled(false);
			Intent intent = new Intent(Slotavail.this, Payment.class);
			intent.putExtra("locationname",locationname);
			intent.putExtra("locationid",locationid);
			intent.putExtra("slotno","3");
			intent.putExtra("price",price);
			intent.putExtra("uid",uid);
			startActivity(intent);
			}
		});
		b4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			rowid = idAL.get(3);
			new Updatestatus().execute();
			b4.setEnabled(false);
			Intent intent = new Intent(Slotavail.this, Payment.class);
			intent.putExtra("locationname",locationname);
			intent.putExtra("locationid",locationid);
			intent.putExtra("slotno","4");
			intent.putExtra("price",price);
			intent.putExtra("uid",uid);
			startActivity(intent);
			}
		});
		b5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			rowid = idAL.get(4);
			new Updatestatus().execute();
			b5.setEnabled(false);
			Intent intent = new Intent(Slotavail.this, Payment.class);
			intent.putExtra("locationname",locationname);
			intent.putExtra("locationid",locationid);
			intent.putExtra("slotno","5");
			intent.putExtra("price",price);
			intent.putExtra("uid",uid);
			startActivity(intent);
			}
		});
		b6.setOnClickListener(new OnClickListener() {			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			rowid = idAL.get(5);
			new Updatestatus().execute();
			b6.setEnabled(false);
			Intent intent = new Intent(Slotavail.this, Payment.class);
			intent.putExtra("locationname",locationname);
			intent.putExtra("locationid",locationid);
			intent.putExtra("slotno","6");
			intent.putExtra("price",price);
			intent.putExtra("uid",uid);
			startActivity(intent);
			}
		});
		b7.setOnClickListener(new OnClickListener() {
			
	@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			rowid = idAL.get(6);
			new Updatestatus().execute();
			b7.setEnabled(false);
			Intent intent = new Intent(Slotavail.this, Payment.class);
			intent.putExtra("locationname",locationname);
			intent.putExtra("locationid",locationid);
			intent.putExtra("slotno","7");
			intent.putExtra("price",price);
			intent.putExtra("uid",uid);
			startActivity(intent);
			}
		});
		b8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			rowid = idAL.get(7);
			new Updatestatus().execute();
			b8.setEnabled(false);
			Intent intent = new Intent(Slotavail.this, Payment.class);
			intent.putExtra("locationname",locationname);
			intent.putExtra("locationid",locationid);
			intent.putExtra("slotno","8");
			intent.putExtra("price",price);
			intent.putExtra("uid",uid);
			startActivity(intent);
			}
		});
		b9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Slotavail.this, Payment.class);
				intent.putExtra("locationname",locationname);
				intent.putExtra("locationid",locationid);
				intent.putExtra("slotno","9");
				intent.putExtra("price",price);
				intent.putExtra("uid",uid);
				startActivity(intent);
			rowid = idAL.get(8);
			new Updatestatus().execute();
			b9.setEnabled(false);
			
			}
		});
		b10.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Slotavail.this, Payment.class);
				intent.putExtra("locationname",locationname);
				intent.putExtra("locationid",locationid);
				intent.putExtra("slotno","10");
				intent.putExtra("price",price);
				intent.putExtra("uid",uid);
				startActivity(intent);
			
			rowid = idAL.get(9);
			new Updatestatus().execute();
			b10.setEnabled(false);
			
			}
		});
		
		
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
				
				URL url = new URL("http://192.168.43.249/Slotinfo.php?id=" + id + "&locationid="+ locationid + "&slotno=" + slotno + "&status=" + status);
								
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
                   
                    //data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
                    idAL.add(id2);
                   	locationidAL.add(locationid2);
	            	slotnoAL.add(slotno2);
	                statusAL.add(status2);
	               

	                
	              
	     
                  }  
                //out.setText(data);  
                /*Toast.makeText(Slotavail.this, statusAL.size()+":"+statusAL.get(0), Toast.LENGTH_LONG).show();*/
                
              //  Toast.makeText(Slotavail.this, statusAL.size()+":"+statusAL.get(0), Toast.LENGTH_LONG).show();
                
                
                
                if(statusAL.size()==1){
                	if(statusAL.get(0).equals("0"))
                	{
                		b1.setEnabled(true);
                	}
                	else
                	{
                		b1.setEnabled(false);
                	}
                }
                
                if(statusAL.size()==2)
                {
                	if(statusAL.get(0).equals("0"))
                	{
                		b1.setEnabled(true);
                	}
                	else
                	{
                		b1.setEnabled(false);
                	}
                	
                	if(statusAL.get(1).equals("0"))
                	{
                		b2.setEnabled(true);
                	}
                	else
                	{
                		b2.setEnabled(false);
                	}
                }
                
                
                if(statusAL.size()==3)
                {
                	if(statusAL.get(0).equals("0"))
                	{
                		b1.setEnabled(true);
                	}
                	else
                	{
                		b1.setEnabled(false);
                	}
                	if(statusAL.get(1).equals("0"))
                	{
                		b2.setEnabled(true);
                	}
                	else
                	{
                		b2.setEnabled(false);
                	}
                	if(statusAL.get(2).equals("0"))
                	{
                		b3.setEnabled(true);
                	}
                	else
                	{
                		b3.setEnabled(false);
                	}
                }
                if(statusAL.size()==4)
                {
                	if(statusAL.get(0).equals("0"))
                	{
                		b1.setEnabled(true);
                	}
                	else
                	{
                		b1.setEnabled(false);
                	}
                	if(statusAL.get(1).equals("0"))
                	{
                		b2.setEnabled(true);
                	}
                	else
                	{
                		b2.setEnabled(false);
                	}
                	if(statusAL.get(2).equals("0"))
                	{
                		b3.setEnabled(true);
                	}
                	else
                	{
                		b3.setEnabled(false);
                	}
                	if(statusAL.get(3).equals("0"))
                	{
                		b4.setEnabled(true);
                	}
                	else
                	{
                		b4.setEnabled(false);
                	}
                }
                if(statusAL.size()==5)
                {
                	if(statusAL.get(0).equals("0"))
                	{
                		b1.setEnabled(true);
                	}
                	else
                	{
                		b1.setEnabled(false);
                	}
                	if(statusAL.get(1).equals("0"))
                	{
                		b2.setEnabled(true);
                	}
                	else
                	{
                		b2.setEnabled(false);
                	}
                	if(statusAL.get(2).equals("0"))
                	{
                		b3.setEnabled(true);
                	}
                	else
                	{
                		b3.setEnabled(false);
                	}
                	if(statusAL.get(3).equals("0"))
                	{
                		b4.setEnabled(true);
                	}
                	else
                	{
                		b4.setEnabled(false);
                	}
                	if(statusAL.get(4).equals("0"))
                	{
                		b5.setEnabled(true);
                	}
                	else
                	{
                		b5.setEnabled(false);
                	}
                }
                if(statusAL.size()==6)
                {
                	if(statusAL.get(0).equals("0"))
                	{
                		b1.setEnabled(true);
                	}
                	else
                	{
                		b1.setEnabled(false);
                	}
                	if(statusAL.get(1).equals("0"))
                	{
                		b2.setEnabled(true);
                	}
                	else
                	{
                		b2.setEnabled(false);
                	}
                	if(statusAL.get(2).equals("0"))
                	{
                		b3.setEnabled(true);
                	}
                	else
                	{
                		b3.setEnabled(false);
                	}
                	if(statusAL.get(3).equals("0"))
                	{
                		b4.setEnabled(true);
                	}
                	else
                	{
                		b4.setEnabled(false);
                	}
                	if(statusAL.get(4).equals("0"))
                	{
                		b5.setEnabled(true);
                	}
                	else
                	{
                		b5.setEnabled(false);
                	}
                	if(statusAL.get(5).equals("0"))
                	{
                		b6.setEnabled(true);
                	}
                	else
                	{
                		b6.setEnabled(false);
                	}
                
                }
                if(statusAL.size()==7)
                {
                	if(statusAL.get(0).equals("0"))
                	{
                		b1.setEnabled(true);
                	}
                	else
                	{
                		b1.setEnabled(false);
                	}
                	if(statusAL.get(1).equals("0"))
                	{
                		b2.setEnabled(true);
                	}
                	else
                	{
                		b2.setEnabled(false);
                	}
                	if(statusAL.get(2).equals("0"))
                	{
                		b3.setEnabled(true);
                	}
                	else
                	{
                		b3.setEnabled(false);
                	}
                	if(statusAL.get(3).equals("0"))
                	{
                		b4.setEnabled(true);
                	}
                	else
                	{
                		b4.setEnabled(false);
                	}
                	if(statusAL.get(4).equals("0"))
                	{
                		b5.setEnabled(true);
                	}
                	else
                	{
                		b5.setEnabled(false);
                	}
                	if(statusAL.get(5).equals("0"))
                	{
                		b6.setEnabled(true);
                	}
                	else
                	{
                		b6.setEnabled(false);
                	}
                	if(statusAL.get(6).equals("0"))
                	{
                		b7.setEnabled(true);
                	}
                	else
                	{
                		b7.setEnabled(false);
                	}
                
                }

                if(statusAL.size()==8)
                {
                	if(statusAL.get(0).equals("0"))
                	{
                		b1.setEnabled(true);
                	}
                	else
                	{
                		b1.setEnabled(false);
                	}
                	if(statusAL.get(1).equals("0"))
                	{
                		b2.setEnabled(true);
                	}
                	else
                	{
                		b2.setEnabled(false);
                	}
                	if(statusAL.get(2).equals("0"))
                	{
                		b3.setEnabled(true);
                	}
                	else
                	{
                		b3.setEnabled(false);
                	}
                	if(statusAL.get(3).equals("0"))
                	{
                		b4.setEnabled(true);
                	}
                	else
                	{
                		b4.setEnabled(false);
                	}
                	if(statusAL.get(4).equals("0"))
                	{
                		b5.setEnabled(true);
                	}
                	else
                	{
                		b5.setEnabled(false);
                	}
                	if(statusAL.get(5).equals("0"))
                	{
                		b6.setEnabled(true);
                	}
                	else
                	{
                		b6.setEnabled(false);
                	}
                	if(statusAL.get(6).equals("0"))
                	{
                		b7.setEnabled(true);
                	}
                	else
                	{
                		b7.setEnabled(false);
                	}
                	if(statusAL.get(7).equals("0"))
                	{
                		b8.setEnabled(true);
                	}
                	else
                	{
                		b8.setEnabled(false);
                	}
                
                }
                
			 } catch (JSONException e) {e.printStackTrace();}  
			 
			
		                
		    /*            
		    try
		    {
			
		    Toast.makeText(MapAct.this, latti.size()+"", Toast.LENGTH_LONG).show();
		    }
		    catch(Exception e){
		    	 Toast.makeText(MapAct.this, "error", Toast.LENGTH_LONG).show();
		    }*/

		}
	}

	class Updatestatus extends AsyncTask<Void, Void, Void>
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
				
				URL url = new URL("http://192.168.43.249/Updatestatus.php?id=" + rowid );
				
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
			
			
			//Toast.makeText(getApplicationContext(), out, Toast.LENGTH_LONG).show();
		}
	
	}
}