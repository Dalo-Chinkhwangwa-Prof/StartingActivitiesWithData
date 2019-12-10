package com.example.multiactivityapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.multiactivityapp.R;

public class ActivityA extends AppCompatActivity {

    public static String Akey = "ACTIVITY_A";

    private TextView myTextView;


    private Button returnMessageButton;
    private EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        String fromMain = getIntent().getStringExtra(Akey);

        myTextView = findViewById(R.id.textView);
        myTextView.setText("Activity A: " + fromMain.toUpperCase());

        messageEditText = findViewById(R.id.activity_a_edittext);
        returnMessageButton = findViewById(R.id.activitya_msg_button);

        returnMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString().trim();
                Intent dataIntent = new Intent();
                dataIntent.putExtra(MainActivity.resultKey, message);
                setResult(AppCompatActivity.RESULT_OK, dataIntent);
                finish();
            }
        });
    }
}
