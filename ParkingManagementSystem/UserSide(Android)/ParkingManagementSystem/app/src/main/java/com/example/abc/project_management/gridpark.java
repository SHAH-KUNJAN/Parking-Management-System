package com.example.abc.project_management;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.abc.project_management.POJOs.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gridpark extends AppCompatActivity {

    private static final String TAG = "GridPark";
    GridView gv;
   // SparseBooleanArray images;
    HashMap<Integer,Boolean> images;
   // Button bpay;
    List<Booking> slot;
    private int numberOfSlot;
  //  Booking b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridpark);

      //  bpay= findViewById(R.id.btnpay);

        slot = new ArrayList<>();
        String UserName=getIntent().getExtras().getString("UserName");
        String ownername=getIntent().getExtras().getString("ownername");

        if(getIntent().getExtras()!=null) {
            try {
                slot = (List<Booking>) getIntent().getExtras().getSerializable("bookedSlot");
                  //Toast.makeText(getApplicationContext(), slot.get(i).getSlotid(), Toast.LENGTH_LONG).show();


            } catch (Exception e) {
                Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();
            }

            numberOfSlot = getIntent().getExtras().getInt("slot");
        }
        images = new HashMap<>();

        for (int i = 0; i < numberOfSlot; i++) {
            images.put(i,Boolean.FALSE);
        }
        for(Booking b : slot){
           // Log.i(TAG, "onCreate: " + b.getSlotid());
            images.put(b.getSlotid()-1,Boolean.TRUE);
        }

        gv = findViewById(R.id.grid1);

        adapterpark adapter=new adapterpark(this,images,UserName
                ,ownername);
        gv.setAdapter(adapter);
       // Log.i("hiiii","okokook");


    }
}
