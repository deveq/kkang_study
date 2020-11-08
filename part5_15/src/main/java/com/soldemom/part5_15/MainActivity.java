package com.soldemom.part5_15;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button goToDetailBtn;
    Button goToDialogBtn;
    RecyclerView rv;
    List<String> list = new ArrayList<String>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToDetailBtn = findViewById(R.id.go_detail_btn);
        goToDialogBtn = findViewById(R.id.go_dialog_btn);
        rv = findViewById(R.id.recycler_view);

        adapter = new MyAdapter();
        adapter.list = this.list;
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list.add("onCreate");

        goToDialogBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        });

        goToDetailBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        list.add("onStart..") ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        list.add("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        list.add("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        list.add("onStop");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        list.add("onSaveInstanceState");
        adapter.notifyDataSetChanged();

        outState.putString("data1","hello");
        outState.putInt("data2",100);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        list.add("onRestoreInstanceState");
        adapter.notifyDataSetChanged();


        String data1 = savedInstanceState.getString("data1");
        int data2 = savedInstanceState.getInt("data2");

        Toast.makeText(this,data1 + ", " + data2, Toast.LENGTH_SHORT).show();





    }
}
