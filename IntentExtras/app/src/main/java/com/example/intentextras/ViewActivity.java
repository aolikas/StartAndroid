package com.example.intentextras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        textView = findViewById(R.id.tvView);

        Intent intent = getIntent();

        String fName = intent.getStringExtra("firstName");
        String lName = intent.getStringExtra("lastName");

        textView.setText("Name is: " + fName + " " + lName);
    }
}
