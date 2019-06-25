package com.example.activityresult;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity  implements View.OnClickListener {

    Button mRed, mGreen, mBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mRed = findViewById(R.id.btn_red);
        mGreen = findViewById(R.id.btn_green);
        mBlue = findViewById(R.id.btn_blue);

        mRed.setOnClickListener(this);
        mGreen.setOnClickListener(this);
        mBlue.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_red:
                intent.putExtra("color", Color.RED);
                break;
            case R.id.btn_green:
                intent.putExtra("color", Color.GREEN);
                break;
            case R.id.btn_blue:
                intent.putExtra("color", Color.BLUE);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
