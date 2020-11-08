package com.soldemom.part4_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity2 extends AppCompatActivity {

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView imageView = findViewById(R.id.imageView);
        registerForContextMenu(imageView);
    }



    //메뉴 구현
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        //만들었던 menu_lab2를 넣어서 inflate하면 이 액티비티에 메뉴가 적용이됨.
        inflater.inflate(R.menu.menu_lab2,menu);
        //여기까지만 해도 메뉴가 화면에 나옴


        //overflow menu의 아이템에 아이콘이 나오도록 하는 코드
        try {
            Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible",boolean.class);
            method.setAccessible(true);
            method.invoke(menu, true);


        } catch (Exception e) {
            e.printStackTrace();
        }


        MenuItem menuItem = menu.findItem(R.id.menu_main_search);
        searchView = (SearchView)menuItem.getActionView();
        searchView.setQueryHint(getResources().getString(R.string.query_hint));
        searchView.setOnQueryTextListener(queryTextListener);

        return true;
    }

    SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            //1. 유저가 입력한 내용을 지운다.
            searchView.setQuery("",false);
            // 2. 아이콘으로 다시 복귀하셈
            searchView.setIconified(true);

            showToast(query);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // register된 view를 long click했을때 나오는 ContextMenu의 아이템 추가
        menu.add(0,0,0,"서버전송");
        menu.add(0,1,0,"보관함에 보관");
        menu.add(0,2,0,"삭제");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case 0:
                showToast("서버 전송이 선택되었습니다.");
                break;
            case 1:
                showToast("보관함에 보관이 선택되었습니다.");
                break;
            case 2:
                showToast("삭제가 선택되었습니다.");
                break;
        }
        return true;
    }

    public void showToast(String query) {
        Toast.makeText(this,query,Toast.LENGTH_SHORT).show();
    }
}