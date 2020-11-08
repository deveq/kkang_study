package com.soldemom.part3_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etContent;
    EditText etTitle;
    Button btnAdd;
    DBHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etContent = findViewById(R.id.et_content);
        etTitle = findViewById(R.id.et_title);
        btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(this);

        helper = new DBHelper(this);
        db = helper.getWritableDatabase();


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,ReadDbActivity.class);
        String content = etContent.getText().toString();
        String title = etTitle.getText().toString();


//        intent.putExtra("title",title);
//        intent.putExtra("content",content);

        ContentValues values = new ContentValues();
        values.put("title",title);
        values.put("content",content);
//        db.insert("tb_memo",null,values);

        db.execSQL("insert into tb_memo (title, content) values(?,?)",new String[]{title,content});
        db.close();


        startActivity(intent);
    }
}
