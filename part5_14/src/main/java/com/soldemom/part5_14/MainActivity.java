package com.soldemom.part5_14;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv;

    ArrayList<String> datas;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recycler_view);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery("select location from tb_data where category='0'",null);

        datas = new ArrayList<>();

        while (cursor.moveToNext()) {
            datas.add(cursor.getString(0));
        }
        db.close();


        //Adapter 적용으로 ListView 구성
        adapter = new MyAdapter(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView text1 = v.findViewById(android.R.id.text1);
                String category = text1.getText().toString();

                //Extra 데이터를 넘기면서 Intent 발생
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("category",category);
                startActivityForResult(intent, 10);



            }
        });
        adapter.datas = datas;
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == Activity.RESULT_OK) {
            //DetailActivity가 넘긴 데이터 획득
            String category = data.getStringExtra("category");
            String location = data.getStringExtra("location");
            Toast.makeText(this, category + ", " + location, Toast.LENGTH_SHORT).show();
        }


    }
}
