package com.soldemom.part4_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    String[] dates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.main_list);

        //arrayAdapter를 사용한 방법
//        dates = getResources().getStringArray(R.array.location);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                R.layout.main_item,R.id.main_item_name, dates);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(this);

        ArrayList<HashMap<String,String>> datas = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        map.put("name","류현진");
        map.put("content","화이팅");
        datas.add(map);

        map = new HashMap<>();
        map.put("name","오승환");
        map.put("content","짝짝");
        datas.add(map);

        SimpleAdapter adapter = new SimpleAdapter(this,
                datas,
                android.R.layout.simple_list_item_2,
                new String[]{"name","content"},
                new int[]{android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this, dates[position],Toast.LENGTH_SHORT).show();

    }

}
