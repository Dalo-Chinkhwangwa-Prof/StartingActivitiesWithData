package com.example.multiactivityapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {

    public static String Akey = "ACTIVITY_A";

    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        String fromMain = getIntent().getStringExtra(Akey);

        myTextView = findViewById(R.id.textView);
        myTextView.setText("Activity A: " + fromMain.toUpperCase());

    }

}
