package com.soldemom.part4_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.icon);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this,"HOME AS UP Click", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lab2,menu);

//        try {
//            Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible",
//                    boolean.class);
//            method.setAccessible(true);
//            method.invoke(menu, true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
        MenuItem menuItem = menu.findItem(R.id.menu_main_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint(getResources().getString(R.string.query_hint));
        searchView.setOnQueryTextListener(queryTextListener);


        return true;
    }

    //사용자 검색 이벤트 핸들러
    private SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
        //키보드에서 검색버튼을 눌린 순간의 이벤트
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        //검색어가 한 자 한 자 입력되는 순간마다.
        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };
}
