package com.example.simpleactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mNameEdit;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        mNameEdit = findViewById(R.id.et_name);
        mButton = findViewById(R.id.btn_ok);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", mNameEdit.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
