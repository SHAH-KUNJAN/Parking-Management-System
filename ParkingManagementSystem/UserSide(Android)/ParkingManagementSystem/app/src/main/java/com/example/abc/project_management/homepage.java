package com.example.abc.project_management;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class homepage extends AppCompatActivity {

    ImageButton b1,b2,b3,b4,b5,b6,b7,b8;
    Button btn;
    boolean abc=true;
    int cost=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        b1=(ImageButton) findViewById(R.id.imgbtn1);
        b2=(ImageButton) findViewById(R.id.imgbtn2);
        b3=(ImageButton) findViewById(R.id.imgbtn3);
        b4=(ImageButton) findViewById(R.id.imgbtn4);
        b5=(ImageButton) findViewById(R.id.imgbtn5);
        b6=(ImageButton) findViewById(R.id.imgbtn6);
        b7=(ImageButton) findViewById(R.id.imgbtn7);
        b8=(ImageButton) findViewById(R.id.imgbtn8);

        btn=(Button) findViewById(R.id.btnpay);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(abc){
                    b1.setBackground(getDrawable(R.drawable.ic_parking));
                    abc=false;
                    cost+=10;
                    btn.setVisibility(View.VISIBLE);
                    btn.setText("PAY "+cost);
                    Toast.makeText(getApplicationContext(), "your slot no 1 is booked", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    b1.setBackground(getDrawable(R.drawable.ic_noparking));
                    abc=true;
                    cost-=10;
                    btn.setText("PAY "+cost);
                    Toast.makeText(getApplicationContext(), "your slot no 1 is Canceled", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b2.setBackground(getDrawable(R.drawable.ic_parking));
                cost+=10;
                btn.setVisibility(View.VISIBLE);
                btn.setText("PAY "+cost);
                Toast.makeText(getApplicationContext(),"your slot no 2 is booked",Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b3.setBackground(getDrawable(R.drawable.ic_parking));
                cost+=10;
                btn.setVisibility(View.VISIBLE);
                btn.setText("PAY "+cost);
                Toast.makeText(getApplicationContext(),"your slot no 3 is booked",Toast.LENGTH_SHORT).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b4.setBackground(getDrawable(R.drawable.ic_parking));
                cost+=10;
                btn.setVisibility(View.VISIBLE);
                btn.setText("PAY "+cost);
                Toast.makeText(getApplicationContext(),"your slot no 4 is booked",Toast.LENGTH_SHORT).show();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b5.setBackground(getDrawable(R.drawable.ic_parking));
                cost+=10;
                btn.setVisibility(View.VISIBLE);
                btn.setText("PAY "+cost);
                Toast.makeText(getApplicationContext(),"your slot no 5 is booked",Toast.LENGTH_SHORT).show();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b6.setBackground(getDrawable(R.drawable.ic_parking));
                cost+=10;
                btn.setVisibility(View.VISIBLE);
                btn.setText("PAY "+cost);
                Toast.makeText(getApplicationContext(),"your slot no 6 is booked",Toast.LENGTH_SHORT).show();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b7.setBackground(getDrawable(R.drawable.ic_parking));
                cost+=10;
                btn.setVisibility(View.VISIBLE);
                btn.setText("PAY "+cost);
                Toast.makeText(getApplicationContext(),"your slot no 7 is booked",Toast.LENGTH_SHORT).show();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b8.setBackground(getDrawable(R.drawable.ic_parking));
                cost+=10;
                btn.setVisibility(View.VISIBLE);
                btn.setText("PAY "+cost);
                Toast.makeText(getApplicationContext(),"your slot no 8 is booked",Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setVisibility(View.VISIBLE);
                btn.setText("PAY "+cost);
                Toast.makeText(getApplicationContext(),"PAY ONLINE",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
