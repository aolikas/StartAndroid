package com.example.simpleactivityresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mText;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = findViewById(R.id.tv_name);
        mButton = findViewById(R.id.btn_name);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, NameActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data == null) {return;}
        String name = data.getStringExtra("name");
        mText.setText("You name is " + name);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
