package com.soldemom.part3_mission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editEmail;
    EditText editPhone;
    EditText editName;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.edit_email);
        editPhone = findViewById(R.id.edit_phone);
        editName = findViewById(R.id.edit_name);
        btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        if(v == btnAdd) {
            String name = editName.getText().toString();
            String phone = editPhone.getText().toString();
            String email = editEmail.getText().toString();

            if (name == null || name.equals("")) {
                Toast.makeText(this,"이름이 입력되지 않았습니다.",Toast.LENGTH_SHORT).show();

            } else {
                DBHelper helper = new DBHelper(this);
                SQLiteDatabase db = helper.getWritableDatabase();
//                ContentValues value = new ContentValues();
//                value.put("name",name);
//                value.put("phone",phone);
//                value.put("email",email);
//                db.insert("tb_contact",null,value);

                db.execSQL("insert into tb_contact (name, phone, email) values(?,?,?)",new String[]{name,phone,email});
                db.close();

                Toast.makeText(this,"새로운 주소록이 등록되었습니다.",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this,ResultActivity.class);
                startActivity(intent);

            }


        }


    }
}
