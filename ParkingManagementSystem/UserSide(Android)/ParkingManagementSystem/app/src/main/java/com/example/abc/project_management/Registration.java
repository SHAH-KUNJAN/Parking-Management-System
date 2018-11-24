package com.example.abc.project_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registration extends AppCompatActivity {

    private static final String TAG = "Registration ";
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    Button b1;
    TextView txtLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ed1=(EditText) findViewById(R.id.et1);
        ed2=(EditText) findViewById(R.id.et2);
        ed3=(EditText) findViewById(R.id.et3);
        ed4=(EditText) findViewById(R.id.et4);
        ed5=(EditText) findViewById(R.id.et5);
        ed6=(EditText) findViewById(R.id.et6);
        ed7=(EditText) findViewById(R.id.et7);

        txtLogin=(TextView) findViewById(R.id.txtLogin);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this,LoginActivity.class));
            }
        });

        b1=(Button)findViewById(R.id.btnSignUp);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });



    }
    public void signup()
    {
        String emailid=ed1.getText().toString().trim();
        String username=ed2.getText().toString().trim();
        String password=ed3.getText().toString().trim();
        String mobileno=ed4.getText().toString().trim();
        String licence=ed5.getText().toString().trim();
        String firstname=ed6.getText().toString().trim();
        String lastname=ed7.getText().toString().trim();



        UserDetails user = new UserDetails(emailid,password,Long.parseLong(mobileno),licence,firstname,lastname);

        Call<ResponseBody> call =RetrofitClient
                .getInstance()
                .getApi()
                .add(user);


        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


               // Log.i(TAG, "onResponse: " + response);

                  if(response.isSuccessful()){
                      try {
                          String s=response.body().string();
                          startActivity(new Intent(Registration.this,LoginActivity.class));
                         // Toast.makeText(Registration.this,s,Toast.LENGTH_SHORT).show();
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                    /*  try {
                          JSONObject jsonObject=new JSONObject(response.body().string());
                          Toast.makeText(Registration.this,jsonObject.toString(),Toast.LENGTH_SHORT).show();
                      } catch (IOException e) {
                          e.printStackTrace();
                      } catch (JSONException e) {
                          e.printStackTrace();
                      }*/
                       // Toast.makeText(Registration.this, response.body() != null ? response.body().toString() : null, Toast.LENGTH_SHORT).show();
                    }else{
                        Log.i("jojowqwq",response.errorBody().toString());
                        Toast.makeText(Registration.this, response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                      try {
                          Log.i(TAG, "onResponse: " + response.errorBody().string());
                      } catch (IOException e) {
                          e.printStackTrace();
                      }
                  }

                /*try {
                    if(response.isSuccessful())
                    ResponseBody s = response.body();
                    Log.v("Response ",s.);
                    JSONObject jsonObject=new JSONObject(s);

                    Toast.makeText(Registration.this,jsonObject.toString(),Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Toast.makeText(Registration.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
