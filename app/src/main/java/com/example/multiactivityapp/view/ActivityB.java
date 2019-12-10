package com.example.multiactivityapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.multiactivityapp.R;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Intent dataIntent = new Intent();
        dataIntent.putExtra(MainActivity.resultKey, "Why hello..");
        setResult(AppCompatActivity.RESULT_OK,dataIntent);
        finish();

    }
}
