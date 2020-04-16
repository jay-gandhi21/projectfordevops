package com.example.projectfordevops;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class view_car extends AppCompatActivity {
    Button btnimage,btnback;
    ImageView imageView1;
    TextView textview1,textview4;

    private static final int IMAGE3_PICK_CODE=1000;
    private static final int PERMISSION_CODE=1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_car);

        btnimage = (Button) findViewById(R.id.btnimage);
        btnback=(Button)findViewById(R.id.btnback);

        imageView1=(ImageView) findViewById(R.id.imageview1);

        btnimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED ){

                        String[] permissions={Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions, PERMISSION_CODE);

                    }else{
                        pickImageFromGallery();
                    }
                }else{
                    pickImageFromGallery();
                }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intant=new Intent(view_car.this,MainActivity.class);
                startActivity(intant);
            }
        });

    }
    private void pickImageFromGallery() {

        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE3_PICK_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallery();

                }else{
                    Toast.makeText(this,"Permission denied...!",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK  &&  requestCode==IMAGE3_PICK_CODE){
            imageView1.setImageURI(data.getData());
        }else {

        }
    }
}