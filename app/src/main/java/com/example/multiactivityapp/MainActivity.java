package com.example.multiactivityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view) {
        Intent intent = null;

        switch (view.getId()) {

            case R.id.activity_a_button:
                intent = new Intent(this, ActivityA.class);//Explicit Intent
                intent.putExtra(ActivityA.Akey, "From Main Activity");
                break;

            case R.id.activity_b_button:
                intent = new Intent(this, ActivityB.class);
                break;
            case R.id.activity_c_button:
                intent = new Intent(this, ActivityC.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }


}
