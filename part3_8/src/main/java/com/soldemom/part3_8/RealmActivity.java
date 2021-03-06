package com.soldemom.part3_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class RealmActivity extends AppCompatActivity implements View.OnClickListener{

    Realm mRealm;
    EditText titleView;
    EditText contentView;
    Button addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        titleView = findViewById(R.id.et_title);
        contentView = findViewById(R.id.et_content);
        addBtn = findViewById(R.id.btn_add);

        addBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        final String title = titleView.getText().toString();
        final String content = contentView.getText().toString();
        Realm.init(this);
        mRealm = Realm.getDefaultInstance();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MemoVo vo = realm.createObject(MemoVo.class);
                vo.title = title;
                vo.content = content;
            }
        });

        Intent intent = new Intent(RealmActivity.this, RealmReadActivity.class);
        intent.putExtra("title",title);
        startActivity(intent);

    }
}