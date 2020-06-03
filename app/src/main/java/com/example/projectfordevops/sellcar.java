package com.example.projectfordevops;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;


public class sellcar extends Activity {

    ImageView imageView1;
    Spinner spinmodel, spinbrand, spincar, spingastype;
    Button btnadd;
    EditText edttitle,edtkm,edtnumber;

    ArrayList<String> arrayList_carbrand,arrayList_modelyear,arrayList_gastype;
    ArrayAdapter<String> arrayAdapter_carbrand,arrayAdapter_modelyear,arrayAdapter_gastype;

    ArrayList<String> arrayList_bmw,arrayList_audi,arrayList_mercedezbenz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellcar);

        spinmodel= (Spinner) findViewById(R.id.spinmodel);
        spinbrand=(Spinner)findViewById(R.id.spinbrand);
        spincar=(Spinner)findViewById(R.id.spincar);
        spingastype=(Spinner) findViewById(R.id.spingastype);

        btnadd=(Button) findViewById(R.id.btnadd);

        edttitle=(EditText)findViewById(R.id.edttitle);
        edtkm=(EditText)findViewById(R.id.edtkm);
        edtnumber=(EditText)findViewById(R.id.edtnumber);

        arrayList_modelyear=new ArrayList<>();
        arrayList_modelyear.add("2011");
        arrayList_modelyear.add("2012");
        arrayList_modelyear.add("2013");
        arrayList_modelyear.add("2014");
        arrayList_modelyear.add("2015");
        arrayList_modelyear.add("2016");
        arrayList_modelyear.add("2017");
        arrayList_modelyear.add("2018");
        arrayList_modelyear.add("2019");
        arrayList_modelyear.add("2020");

        arrayList_carbrand=new ArrayList<>();
        arrayList_carbrand.add("Bmw");
        arrayList_carbrand.add("Audi");
        arrayList_carbrand.add("Mercedez.Benz");

        arrayList_bmw=new ArrayList<>();
        arrayList_bmw.add("3 series");
        arrayList_bmw.add("5 series");
        arrayList_bmw.add("7 series");
        arrayList_bmw.add("RS 3");
        arrayList_bmw.add("RS 5");
        arrayList_bmw.add("RS 7");
        arrayList_bmw.add("X series");

        arrayList_audi=new ArrayList<>();
        arrayList_audi.add("A2");
        arrayList_audi.add("A3");
        arrayList_audi.add("A4");
        arrayList_audi.add("A5");
        arrayList_audi.add("Q3");
        arrayList_audi.add("Q5");
        arrayList_audi.add("Q7");

        arrayList_mercedezbenz=new ArrayList<>();
        arrayList_mercedezbenz.add("C class");
        arrayList_mercedezbenz.add("E class");
        arrayList_mercedezbenz.add("S class");
        arrayList_mercedezbenz.add("AMG Suv");
        arrayList_mercedezbenz.add("AMG Sedan");
        arrayList_mercedezbenz.add("G class");

        arrayList_gastype=new ArrayList<>();
        arrayList_gastype.add("petrol");
        arrayList_gastype.add("diesel");


        arrayAdapter_carbrand= new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrayList_carbrand);
        spinbrand.setAdapter(arrayAdapter_carbrand);

        arrayAdapter_modelyear=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrayList_modelyear);
        spinmodel.setAdapter(arrayAdapter_modelyear);

        arrayAdapter_gastype=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrayList_gastype);
        spingastype.setAdapter(arrayAdapter_gastype);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String nametitle=edttitle.getText().toString();
            String namekm=edtkm.getText().toString();
            String namenumber=edtnumber.getText().toString();

                    if (nametitle.matches("") || (namekm.matches(""))||(namenumber.matches(""))) {
                        Toast.makeText(sellcar.this, "Enter data ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent int12=new Intent(sellcar.this, view_car.class);
                        startActivity(int12);
                    }
            }
        });

        spinbrand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    arrayAdapter_carbrand=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrayList_bmw);
                }
                if(position==1)
                {
                    arrayAdapter_carbrand=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrayList_audi);
                }
                if(position==2)
                {
                    arrayAdapter_carbrand=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrayList_mercedezbenz);
                }
                 spincar.setAdapter(arrayAdapter_carbrand);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinmodel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spincar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spingastype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}