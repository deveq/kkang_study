package com.soldemom.part3_mission;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView nameView;
    TextView phoneView;
    TextView emailView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        nameView = findViewById(R.id.result_name);
        phoneView = findViewById(R.id.result_phone);
        emailView = findViewById(R.id.result_email);

        DBHelper helper = new DBHelper(this);

        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from tb_contact order by _id desc limit 1",null);

        while (cursor.moveToNext()) {
            nameView.setText(cursor.getString(1));
            phoneView.setText(cursor.getString(2));
            emailView.setText(cursor.getString(3));
        }

        db.close();


    }
}