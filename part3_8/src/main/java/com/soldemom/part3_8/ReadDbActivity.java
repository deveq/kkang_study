package com.soldemom.part3_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ReadDbActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db);

//        Intent intent = getIntent();
//        String title = intent.getStringExtra("title");
//        String content = intent.getStringExtra("content");

        tvTitle = findViewById(R.id.read_db_title);
        tvContent = findViewById(R.id.read_db_content);

//        tvTitle.setText(title);
//        tvContent.setText(content);
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from tb_memo",null);
        while (cursor.moveToNext()) {
            tvTitle.setText(cursor.getString(0));
            tvContent.setText(cursor.getString(1));

        }





    }
}