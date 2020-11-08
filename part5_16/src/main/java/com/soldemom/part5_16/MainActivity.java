package com.soldemom.part5_16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
//
//        Handler handler = new Handler();
//
//        // 개발자 스레드에서 뷰와 관련된 작업이 필요하면
//        // Handler의 post()메서드를 호출해 UI스레드에게 작업을 의뢰한다.

        Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what == 1) {
                    textView.setText(String.valueOf(msg.arg1));
                } else if (msg.what == 2) {
                    textView.setText((String) msg.obj);
                }
            }
        };




    }
}

