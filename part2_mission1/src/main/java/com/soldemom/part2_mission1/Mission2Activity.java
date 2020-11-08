package com.soldemom.part2_mission1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class Mission2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission2);

        SQLiteDatabase db = openOrCreateDatabase("memodb",MODE_PRIVATE,null);

        // execSQL("쿼리문" , ?에 들어갈 객체의 배열)
        db.execSQL("insert into tb_memo (title, content) values(?,?)", new String[]{"제목","내용"});

        Cursor cursor = db.rawQuery("select * from tb_memo",null);
        while (cursor.moveToNext()){
            String text = cursor.getString(cursor.getColumnIndex("title"));
        }

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase dbb = helper.getReadableDatabase();


        SQLiteDatabase ddbb = openOrCreateDatabase("tb_memo",MODE_PRIVATE,null);

        ddbb.execSQL("insert into tb_memo (title, content) values(?,?)",new String[]{"제목","내용"});
        Cursor cursor22 = ddbb.rawQuery("select * from tb_memo",null);
        while (cursor22.moveToNext()) {
            String ttext = cursor22.getString(cursor22.getColumnIndex("title"));

        }

        DBHelper helper22 = new DBHelper(this);
        SQLiteDatabase dddbb = helper22.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put("name","kkang");
        values.put("phone","010000");
        ddbb.insert("USER_TB",null,values);
                //난 안드관련, flutter랑 kotlin, jetpack
        Cursor cucusor = ddbb.query("USER_TB",new String[]{"name","phone"},"ID=?",new String[]{"kkang"},null,null,null);


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("작성중인 내용을 저장하지 않고 나가시겠습니까?");
        builder.setPositiveButton("확인",dialogListener);
        builder.setNegativeButton("취소",null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();
        }
    };
}