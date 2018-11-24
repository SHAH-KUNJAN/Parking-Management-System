package com.example.abc.project_management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView ivSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation splash = AnimationUtils.loadAnimation(this,R.anim.activity_splash_animation);
        ivSplash = (ImageView)findViewById(R.id.ivSplash);
        ivSplash.startAnimation(splash);
      //  final Intent intent;

       // intent=new Intent(this,LoginActivity.class);
        Thread timer=new Thread(){
            public void run(){
                try {
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    finish();
                }
            }
        };
        timer.start();
    }
}
