package com.soldemom.part2_mission1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.messenger_btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(this,R.string.ok_click,Toast.LENGTH_SHORT);
        toast.show();
    }
}
