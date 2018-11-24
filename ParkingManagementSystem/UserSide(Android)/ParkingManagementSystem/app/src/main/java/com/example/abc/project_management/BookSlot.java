package com.example.abc.project_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookSlot extends AppCompatActivity {

    private static final String TAG = "bookSlot";
    private Button booked1, timebtn1, timebtn2;
    private RadioGroup radiogroup1;
    private RadioButton radiopay;
    private EditText Vtxt;
    private TextView time1, time2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_slot);

        Vtxt = (EditText) findViewById(R.id.Vtxt);
        booked1 = (Button) findViewById(R.id.booked1);
        timebtn1 = (Button) findViewById(R.id.timebtn1);
        timebtn2 = (Button) findViewById(R.id.timebtn2);
        radiogroup1 = (RadioGroup) findViewById(R.id.radiogroup1);
        time1 = (TextView) findViewById(R.id.time1);
        time2 = (TextView) findViewById(R.id.time2);


        timebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(getApplicationContext(),TimepickerClass.class).putExtra("btn","time1"));
                Intent intent = new Intent(getApplicationContext(), TimepickerClass.class);
                intent.putExtra("btn", "time1");
                startActivityForResult(intent, 1);


            }
        });


        timebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  startActivity(new Intent(getApplicationContext(),TimepickerClass.class).putExtra("btn","time2"));

                Intent intent = new Intent(getApplicationContext(), TimepickerClass.class);
                intent.putExtra("btn", "time2");
                startActivityForResult(intent, 2);
            }
        });


        booked1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int Id = radiogroup1.getCheckedRadioButtonId();
                radiopay = (RadioButton) findViewById(Id);


                String Vname = Vtxt.getText().toString();
                String Paymode = radiopay.getText().toString();
                String timeto = time1.getText().toString();
                String timefrom = time2.getText().toString();
                String UserName = getIntent().getExtras().getString("UserName");
                String Ownername = getIntent().getExtras().getString("ownername");
                int slotid = getIntent().getExtras().getInt("slotid");
              //  Toast.makeText(getApplicationContext(),UserName+"\n"+Ownername,Toast.LENGTH_SHORT).show();

                Log.i(TAG, "onClick: ");

                BookDetails bookDetails = new BookDetails(Vname, timeto, timefrom, slotid, UserName, Ownername);

                Call<ResponseBody> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .booking(bookDetails);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        if (response.isSuccessful())
                        {
                            try {
                                String s = response.body().string();
                                startActivity(new Intent(BookSlot.this,searchhome.class));

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        else {
                            // Log.i("jojowqwq",response.errorBody().toString());
                            Toast.makeText(BookSlot.this, response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(BookSlot.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        {
            if (requestCode == 1)
            {
                time1.setText(data.getStringExtra("time1"));
            }
            else
            {
                time2.setText(data.getStringExtra("time2"));
            }
        }
    }
}






