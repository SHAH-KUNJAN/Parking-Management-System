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
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    EditText etxt1,etxt2;
    TextView txtsignup;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etxt1=(EditText) findViewById(R.id.etemail);
        etxt2=(EditText)findViewById(R.id.etpasswd);

        txtsignup=(TextView) findViewById(R.id.txtsignup);
        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,Registration.class));
            }
        });

        b1=(Button)findViewById(R.id.btnlogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
                //Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
               // startActivity(new Intent(LoginActivity.this,searchhome.class));
            }
        });

    }

    public void login()
    {
        final String useremailid=etxt1.getText().toString().trim();
        String password=etxt2.getText().toString().trim();

        LoginDetails lgdin = new LoginDetails(useremailid,password);

        Call<ResponseBody> call=RetrofitClient
                .getInstance()
                .getApi()
                .login(lgdin);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.isSuccessful()) {
                    try {
                        String s = response.body().string();

                       if (s.equalsIgnoreCase("Login"))
                        {
                            startActivity(new Intent(LoginActivity.this,searchhome.class).putExtra("UserName",useremailid));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Wrong UserId and Password ",Toast.LENGTH_SHORT).show();
                        }
                       // Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                   // Log.i("jojowqwq",response.errorBody().toString());
                    Toast.makeText(LoginActivity.this, response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                 }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
