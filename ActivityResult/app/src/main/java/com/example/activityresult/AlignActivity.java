package com.example.activityresult;

import android.app.ApplicationErrorReport;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class AlignActivity extends AppCompatActivity implements View.OnClickListener {

    Button mLeft, mCenter, mRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);

        mLeft = findViewById(R.id.btn_left);
        mCenter = findViewById(R.id.btn_center);
        mRight = findViewById(R.id.btn_right);

        mLeft.setOnClickListener(this);
        mCenter.setOnClickListener(this);
        mRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_left:
                intent.putExtra("alignment", Gravity.START);
                break;
            case R.id.btn_center:
                intent.putExtra("alignment", Gravity.CENTER);
                break;
            case R.id.btn_right:
                intent.putExtra("alignment", Gravity.END);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
