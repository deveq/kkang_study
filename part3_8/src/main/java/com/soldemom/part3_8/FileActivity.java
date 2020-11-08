package com.soldemom.part3_8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileActivity extends AppCompatActivity implements View.OnClickListener{

    String text = "";
    File file;
    String filename = "myfile.txt";
    Button btn;
    TextView tvText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);



        FileWriter writer;

        String content = "눈누난나";
        File file;

        try {
            file = new File(getFilesDir(), filename);
            if(!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter(file,true);
            writer.write(content);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }





        tvText = findViewById(R.id.tvText);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        try {
            file = new File(getFilesDir(),filename);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuffer buffer = new StringBuffer();
            String line;
            while ((line=reader.readLine())!=null) {
                buffer.append(line);
            }
            reader.close();
            text = line.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tvText.setText(text);


    }
}