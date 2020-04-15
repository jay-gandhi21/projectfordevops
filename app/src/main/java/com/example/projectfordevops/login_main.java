package com.example.projectfordevops;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class login_main extends AppCompatActivity {

    RelativeLayout relay1,relay2;
    Button btnlogin,btnguest;
    EditText edituname,editpwd;

    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            relay1.setVisibility(View.VISIBLE);
            relay2.setVisibility(View.VISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        relay1=(RelativeLayout) findViewById(R.id.relay1);
        relay2=(RelativeLayout) findViewById(R.id.relay2);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        btnguest=(Button)findViewById(R.id.btnguest);
        editpwd=(EditText)findViewById(R.id.editpwd);
        edituname=(EditText)findViewById(R.id.edituname);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                btnlogin.isClickable();
                String userInputuname = edituname.getText().toString();
                String userInputpassword = editpwd.getText().toString();
                if(userInputuname.contains("apple"))
                {
                    if (userInputpassword.contains("apple"))
                    {
                        Intent intent1 = new Intent(login_main.this, MainActivity.class);
                        startActivity(intent1);
                        Toast.makeText(getBaseContext(), "You are login as jay", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getBaseContext(), "password wrong", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(userInputuname.contains("orange"))
                {
                    if (userInputpassword.contains("orange"))
                    {
                        Intent intent2 = new Intent(login_main.this, MainActivity.class);
                        startActivity(intent2);
                        Toast.makeText(getBaseContext(), "You are login madar", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getBaseContext(), "password wrong", Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(getBaseContext(), "Wrong Credintials" , Toast.LENGTH_SHORT ).show();
                }
            }
        });
        btnguest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                btnguest.isClickable();
                Intent in = new Intent(login_main.this, MainActivity.class);
                startActivity(in);
                Toast.makeText(getBaseContext(), "You are login as Guest" , Toast.LENGTH_SHORT ).show();
            }
        });
        handler.postDelayed(runnable, 3000);

    }
}
