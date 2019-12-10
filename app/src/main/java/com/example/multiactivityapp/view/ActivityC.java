package com.example.multiactivityapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.multiactivityapp.R;

public class ActivityC extends AppCompatActivity {


    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dataIntent = new Intent();
                dataIntent.putExtra(MainActivity.resultKey, "Can you \'C\' this?");
                setResult(AppCompatActivity.RESULT_OK,dataIntent);
                finish();
            }
        }, 2000);

    }
}
