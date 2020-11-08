package com.soldemom.part3_9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etWrite;
    Button btn_add;

    //퍼미션 부여 여부
    boolean fileReadPermission;
    boolean fileWritePermission;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_write);
        etWrite = findViewById(R.id.et_write);

        btn_add.setOnClickListener(this);

        //permission 체크
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
        PackageManager.PERMISSION_GRANTED) {
            fileReadPermission = true;
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            fileWritePermission = true;
        }

        //permission 부여 안 될 경우 permission 요청
        if (!fileReadPermission || !fileWritePermission) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    200);
        }
    }

    // permission 요청 결과 확인
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 200 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fileReadPermission = true;
            }
            if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                fileWritePermission = true;
            }
        }

    }

    @Override
    public void onClick(View v) {
        String content = etWrite.getText().toString();

        //permission이 부여되어있다면
        if (fileReadPermission && fileWritePermission) {
            FileWriter fileWriter;

            try {
                //외부 저장 공간 root 하위에 myApp이라는 폴더 경로 획득
                String dirPath = Environment.getExternalStorageDirectory()
                        .getAbsolutePath() + "/myApp";
                File dir = new File(dirPath);

                //폴더가 없으면 새로 만들어 준다.
                if (!dir.exists()) {
                    dir.mkdir();
                }

                //myApp 폴더 밑에 myfile.txt 파일 지정
                File file = new File(dir + "myfile.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }

                //file write
                fileWriter = new FileWriter(file,true);
                fileWriter.write(content);
                fileWriter.flush();
                fileWriter.close();

                //결과 확인을 위한 Activity 실행 클래스
                Intent intent = new Intent(this, ReadFileActivity.class);

                //FileReadActivity로 전환
                startActivity(intent);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else { // permission이 부여되어있지 않다면
            showToast("permission이 부여 되어있지 않아 실행할 수 없습니다.");
        }
    }

    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
