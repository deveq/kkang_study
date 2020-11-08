package com.soldemom.part3_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import io.realm.Realm;

public class RealmReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db);

        TextView titleView = findViewById(R.id.read_db_title);
        TextView contentView = findViewById(R.id.read_db_content);

        //넘어온 title 문자열 추출
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        Realm mRealm = Realm.getDefaultInstance();
        MemoVo vo = mRealm.where(MemoVo.class).equalTo("title",title).findFirst();
        titleView.setText(vo.title);
        contentView.setText(vo.content);

    }

}