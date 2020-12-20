package com.example.parking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class user1 extends Activity {

	Button btnlog;
	Button btnbook;
	Button btnmy,btnview;

	String uid;

	String email;
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user1);			
		
		 btnbook= (Button) findViewById(R.id.btnbook);
		btnlog = (Button) findViewById(R.id.btnlog);
		 btnmy= (Button) findViewById(R.id.btnmy);
		 btnview = (Button) findViewById(R.id.btnview);
		Intent intent = getIntent();
		 email = intent.getExtras().getString("email");
		 Intent i=getIntent();
		 uid = i.getExtras().getString("temp");
		 btnbook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		
				Intent intent = new  Intent(user1.this,MapAct.class);
				intent.putExtra("uid",uid);
				startActivity(intent);
				
			}
		});
		 btnview.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
			
					Intent intent = new  Intent(user1.this,ViewAct.class);
				intent.putExtra("uid",uid);
					startActivity(intent);
					
				}
			});
		 btnlog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
Intent intent = new Intent(user1.this,MainActivity.class);
startActivity(intent);
				
			}
		});
		 
		 btnmy.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					Intent intent = new Intent(user1.this, mydetails.class);
	    			intent.putExtra("email", email.toString());
				startActivity(intent);
				}
			});
		// Toast.makeText(user1.this, uid , Toast.LENGTH_SHORT).show();
	   }
	
	

}
