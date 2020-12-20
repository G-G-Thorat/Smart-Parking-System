package com.example.parking;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnUserSys,btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        btnSignup= (Button) findViewById(R.id.btnSign);
        btnUserSys = (Button) findViewById(R.id.btnUser);
        
        btnSignup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Intent intent = new Intent(MainActivity.this, Registration.class);
				startActivity(intent);
			
			}
		});
        
 btnUserSys.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Intent intent = new Intent(MainActivity.this, User.class);
				startActivity(intent);
			}
		});
    }
    
}
