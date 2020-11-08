package com.soldemom.part5_16;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button startView;
    Button pauseView;
    boolean loopFlag = true;
    boolean isFirst = true;
    boolean isRun;

    MyThread thread = new MyThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        startView = findViewById(R.id.start_view);
        pauseView = findViewById(R.id.pause_view);
        tv = findViewById(R.id.tv);

        startView.setOnClickListener(this);
        pauseView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == startView) {
            if (isFirst) {
                isFirst = false;
                isRun = true;
                thread.start();
            } else {
                isRun = true;
            }
        } else if (v == pauseView) {
            isRun = false;
        }

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
                tv.setText(String.valueOf(msg.arg1));
            } else if (msg.what == 2) {
                tv.setText((String) msg.obj);
            }
        }
    };

    class MyThread extends Thread {
        @Override
        public void run() {
            try {
                int count = 10;
                while(loopFlag) {
                    Thread.sleep(1000);
                    if (isRun) {
                        count--;
                        Message message = new Message();
                        message.what = 1;
                        message.arg1 = count;
                        handler.sendMessage(message);

                        if (count == 0) {
                           //종료
                           message = new Message();
                           message.what = 1;
                           message.obj = "Finish";
                           handler.sendMessage(message);
                           loopFlag = false;
                        }
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}