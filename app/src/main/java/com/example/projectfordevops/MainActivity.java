package com.example.projectfordevops;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button menubtn1,menubtn2,menubtn3,menubtn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menubtn1=(Button) findViewById(R.id.menubtn1);
        menubtn2=(Button)findViewById(R.id.menubtn2);
        menubtn3=(Button) findViewById(R.id.menubtn3);
        menubtn5=(Button) findViewById(R.id.menubtn5);

        menubtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menubtn1.isClickable();
                Toast.makeText(getBaseContext(), "1" , Toast.LENGTH_SHORT ).show();
                Intent intent1 = new Intent(MainActivity.this, sellcar.class);
                startActivity(intent1);
            }
        });
        menubtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, maintaience.class);
                startActivity(intent2);
            }
        });

        menubtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menubtn3.isClickable();
                Intent intent3=new Intent(MainActivity.this,about_cars.class);
                startActivity(intent3);
            }
        });

        menubtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menubtn5.isClickable();
                Intent intent5=new Intent(MainActivity.this,about_us.class);
                startActivity(intent5);

            }
        });
    }
   /* @Override
    public void onBackPressed(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are You Sure you want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
             builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {
                     dialogInterface.cancel();
                 }
             });
             AlertDialog alertDialog= builder.create();
             alertDialog.show();*/
    }


