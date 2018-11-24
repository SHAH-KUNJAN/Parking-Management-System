package com.example.abc.project_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.abc.project_management.POJOs.Booking;
import com.example.abc.project_management.POJOs.ParkingOwner;
import com.example.abc.project_management.POJOs.SlotDetails;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class searchhome extends AppCompatActivity {
    private static final String TAG = "SearchHome";
    EditText stxt;
    Button sbtn,btnlogout,btncancel,btnextend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchhome);

        stxt=(EditText)findViewById(R.id.stxt);
        sbtn=(Button)findViewById(R.id.sbtn);
        btnlogout=(Button)findViewById(R.id.btnlogout);
        btncancel=(Button)findViewById(R.id.btncan);
        btnextend=(Button)findViewById(R.id.btnext);

        final String UserName = getIntent().getExtras().getString("UserName");

        btnextend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Extend Time Limit ",Toast.LENGTH_SHORT).show();
                //extendliit();

            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(searchhome.this,LoginActivity.class));
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"cancel slot ",Toast.LENGTH_SHORT).show();
               // cancelfun(UserName);
            }
        });

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               search(UserName);
            }
        });


    }

    private void extendliit() {
        String UserName = getIntent().getExtras().getString("UserName");
        this.startActivity(new Intent(searchhome.this,BookSlot.class).putExtra("Username",UserName).putExtra("Callfrom","ExtendTime"));

    }

    private void cancelfun(String UserName) {


        CancelDetail cancelDetail=new CancelDetail(UserName);
        Call<ResponseBody> call=RetrofitClient
                .getInstance()
                .getApi()
                .cancel(cancelDetail);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful())
                {
                    try {
                        String s= response.body().string();
                        Toast.makeText(getApplicationContext(),"your solt Canceled ",Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(searchhome.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void search(final String UserName) {

        String searchtxt=stxt.getText().toString().trim();
        Toast.makeText(getApplicationContext(),UserName,Toast.LENGTH_SHORT).show();

      //  final OrganizationName organizationName = new OrganizationName(searchtxt);

        Call<SlotDetails> call = RetrofitOwner
                .getInstance()
                .getApi()
                .homesearch(searchtxt);
        call.enqueue(new Callback<SlotDetails>() {
            @Override
            public void onResponse(Call<SlotDetails> call, Response<SlotDetails> response) {
                Log.i("ch","aav");
                if(response.code()==200 && response.isSuccessful()){
                    Log.i("okok","aav");
                    ParkingOwner owner = response.body().getOwner();
                    List<Booking> booking = response.body().getBooking();
                    Intent intent = new Intent(getApplicationContext(),gridpark.class);
                    intent.putExtra("slot",owner.getTotalslot());
                    intent.putExtra("UserName",UserName);
                    intent.putExtra("ownername",owner.getOrganisation());
                    intent.putExtra("bookedSlot", (Serializable) booking);
                    startActivity(intent);
                 /* startActivity(new Intent(searchhome.this,gridpark.class)
                          .putExtra("slot",owner.getTotalslot())
                          .putExtra("bookedSlot",(Serializable) booking)  );*/
                }
            }

            @Override
            public void onFailure(Call<SlotDetails> call, Throwable t) {

                Log.i(TAG, "onFailure: ",t);
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
