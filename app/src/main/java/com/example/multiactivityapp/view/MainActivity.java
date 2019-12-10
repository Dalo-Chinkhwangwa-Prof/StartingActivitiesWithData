package com.example.multiactivityapp.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.multiactivityapp.R;
import com.example.multiactivityapp.util.Constants;

public class MainActivity extends AppCompatActivity {

    /*
     Storage Options in android
        - SharedPreferences (Only stores primitive data types(string, int, bool etc))
        - Internal Storage
        - External Storage(Ejectable storage, phone storage external to application)
        - Databases(Cloud etc)
    */

    private int buttonPressCount = 0;

    private int REQUEST_COD_A = 707;
    private int REQUEST_COD_B = 708;
    private int REQUEST_COD_C = 709;

    private int rCode = 0;

    public static String resultKey = "my_result";

    private TextView messageTextView;
    private TextView appNameTextView;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageTextView = findViewById(R.id.message_textview);
        appNameTextView = findViewById(R.id.app_name_textview);
        updateCount();

        sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        buttonPressCount = sharedPreferences.getInt(resultKey, 0);
        updateCount();

    }

    private void updateCount() {
        appNameTextView.setText("Count : " + buttonPressCount);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        buttonPressCount = savedInstanceState.getInt(resultKey);
        updateCount();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("TAG_X", "onSaveInstanceState");
        outState.putInt(resultKey, buttonPressCount);

    }

    public void buttonClick(View view) {
        Intent intent = null;

        switch (view.getId()) {

            case R.id.activity_a_button:
                intent = new Intent(this, ActivityA.class);//Explicit Intent
                intent.putExtra(ActivityA.Akey, "From Main Activity");
                rCode = REQUEST_COD_A;
                buttonPressCount++;
                break;

            case R.id.activity_b_button:
                intent = new Intent(this, ActivityB.class);
                rCode = REQUEST_COD_B;
                buttonPressCount++;
                break;
            case R.id.activity_c_button:
                intent = new Intent(this, ActivityC.class);
                rCode = REQUEST_COD_C;
                buttonPressCount++;
                break;
        }
        if (intent != null)
            startActivityForResult(intent, rCode);
//            startActivity(intent);

        updateCount();

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor spEditor = sharedPreferences.edit();

        spEditor.putInt(resultKey, buttonPressCount);
        spEditor.apply();
        spEditor.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG_X", "onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == REQUEST_COD_A) {
            String message = data.getStringExtra(resultKey);
            messageTextView.setText("Activity A: " + message);
        } else if (resultCode == AppCompatActivity.RESULT_OK && requestCode == REQUEST_COD_B) {
            String message = data.getStringExtra(resultKey);
            messageTextView.setText("Activity B: " + message);
        } else if (resultCode == AppCompatActivity.RESULT_OK && requestCode == REQUEST_COD_C) {
            String message = data.getStringExtra(resultKey);
            messageTextView.setText("Activity C: " + message);
        }

    }
}
