package com.example.abc.project_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TimePicker;

public class TimepickerClass extends AppCompatActivity {

    String btn;
    TimePicker tp;
    int Hour,Minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        tp=(TimePicker)findViewById(R.id.timepick);



        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                btn=getIntent().getExtras().getString("btn");
                Hour=hourOfDay;
                Minute=minute;
               String timereply;
                switch(btn)
                {
                    case "time1":
                        timereply=Hour+":"+Minute;
                        Intent data = new Intent();
                        data.putExtra("time1",timereply);
                        setResult(RESULT_OK,data);
                        finish();
                    case  "time2":
                        timereply=Hour+":"+Minute;
                        Intent data1 = new Intent();
                        data1.putExtra("time2",timereply);
                        setResult(RESULT_OK,data1);
                        finish();
                }


            }
        });


    }
}
