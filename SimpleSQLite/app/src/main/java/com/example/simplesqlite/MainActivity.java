package com.example.simplesqlite;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG_TAG = "myLogs";

    Button btnAdd, btnRead, btnClear, btnUpdate, btnDelete;
    EditText etId, etName, etEmail;

    DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnRead = findViewById(R.id.btn_read);
        btnClear = findViewById(R.id.btn_clear);
        btnUpdate = findViewById(R.id.btn_upd);
        btnDelete = findViewById(R.id.btn_del);

        btnAdd.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        etId = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);

        helper = new DbHelper(this);
    }

    @Override
    public void onClick(View v) {

        ContentValues cv = new ContentValues();

        String id = etId.getText().toString();
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase db = helper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btn_add:
                Log.d(LOG_TAG, "--- Insert in myTable ---");

                cv.put("name", name);
                cv.put("email", email);

                long rowId = db.insert("myTable", null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowId);
                break;

            case R.id.btn_read:
                Log.d(LOG_TAG, "--- Rows in myTable ---");

                Cursor c = db.query("myTable", null, null,
                                    null, null, null, null);

                if(c.moveToFirst()) {
                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("name");
                    int emailColIndex = c.getColumnIndex("email");

                    do {
                        Log.d(LOG_TAG,
                                "ID = " + c.getInt(idColIndex) +
                                 ", name = " + c.getString(nameColIndex) +
                                 ", email = " + c.getString(emailColIndex));
                    } while (c.moveToNext());
                } else {
                    Log.d(LOG_TAG, "0 rows");
                    c.close();
                    break;
                }
            case R.id.btn_clear:
                Log.d(LOG_TAG, "--- Clear myTable ---");

                int clearCount = db.delete("myTable", null, null);
                Log.d(LOG_TAG, "delete rows count = " + clearCount);
                break;

            case R.id.btn_upd:
                if(id.equalsIgnoreCase("")) {
                    break;
                }
                Log.d(LOG_TAG, "--- Update myTable ---");
                cv.put("name", name);
                cv.put("email", email);

                int updCount = db.update("myTable", cv, "id = ?",
                        new String[] {id});
                Log.d(LOG_TAG, "updated rows count = " + updCount);
                break;

            case R.id.btn_del:
                if(id.equalsIgnoreCase("")) {
                    break;
                }

                Log.d(LOG_TAG, "--- Delete myTable ---");
                int deleteCount = db.delete("myTable", "id = " + id, null);
                Log.d(LOG_TAG, "deleted rows count = " + deleteCount);
                break;
        }

        db.close();

    }
}
