package com.karucu.www.karucuapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

public class Launcher extends AppCompatActivity {
    private ImageView culogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launcher);
        getSupportActionBar().hide();



        logo culogoo=new logo();
        culogoo.start();

    }

    private class logo extends Thread{
        @Override
        public void run() {
            try {
                sleep(1000*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startActivity(new Intent(Launcher.this,MainActivity.class));
            Launcher.this.finish();
        }
    }
}
