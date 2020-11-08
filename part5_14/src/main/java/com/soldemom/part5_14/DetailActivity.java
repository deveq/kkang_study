package com.soldemom.part5_14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<String> datas;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = getIntent();
        String category = intent.getStringExtra("category");

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select location from tb_data where category = ?",new String[]{category});


        datas = new ArrayList<>();

        while (cursor.moveToNext()) {
            String data = cursor.getString(0);
            datas.add(data);
        }
        MyAdapter adapter = new MyAdapter(this, new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView text1 = v.findViewById(android.R.id.text1);
                String text = text1.getText().toString();
                intent.putExtra("location",text);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        adapter.datas = datas;

        rv = findViewById(R.id.recycler_view);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));





    }
}