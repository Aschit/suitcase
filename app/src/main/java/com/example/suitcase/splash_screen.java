package com.example.suitcase;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.suitcase.databinding.ActivitySplashScreenBinding;

public class splash_screen extends AppCompatActivity {

    ActivitySplashScreenBinding binding;
   Animation animation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        binding= ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set animation in image and text view
        animation= AnimationUtils.loadAnimation(this,R.anim.animation);

         binding.logo.setAnimation(animation);
         binding.txtSplash.setAnimation(animation);


//        getSupportActionBar().hide();



         //splash method


        // create a thread method to sleep a splash screen


        Thread thread= new Thread(new Runnable() {

            @Override
            public void run() {

                // thread will sleep after 9 seconds

                try {
                    sleep(9000);

                    // After 9 seconds the thread will jump to the intent file which is login class.

                    Intent intent= new Intent(getApplicationContext(), login_page.class);
                    startActivity(intent);

                    // catch is used to remove the activity

                }catch (InterruptedException e){
                    e.printStackTrace();

                }

            }
        });

        // start the thread

        thread.start();

    }
}