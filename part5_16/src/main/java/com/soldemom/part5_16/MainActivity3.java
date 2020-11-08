package com.soldemom.part5_16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button startView;
    Button pauseView;

    boolean isFirst = true;

    MyAsyncTask asyncTask;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv = findViewById(R.id.tv3);
        startView = findViewById(R.id.start_view3);
        pauseView = findViewById(R.id.pause_view3);

        startView.setOnClickListener(this);
        pauseView.setOnClickListener(this);

        asyncTask = new MyAsyncTask(tv);


    }

    @Override
    public void onClick(View v) {
        if (v==startView) {
            //만약 첫 동작이면
            if (isFirst) {
                asyncTask.isRun = true;
                //Async Task를 실행(execute)시킴
                asyncTask.execute();
                isFirst = false;
            } else {
                //만약 첫 동작이 아니라면 execute 없이 isRun만 true로
                asyncTask.isRun = true;
            }
        } else if (v == pauseView) {
            asyncTask.isRun = false;
        }
    }
}


class MyAsyncTask extends AsyncTask<Void, Integer, String> {

    boolean loopFlag = true;
    boolean isRun = false;

    private TextView tv;

    public MyAsyncTask(TextView tv) {
        this.tv = tv;
    }


    @Override
    protected String doInBackground(Void... voids) {
        int count = 10;

        while (loopFlag) {
            SystemClock.sleep(1000);

            if (isRun) {
                count--;
                publishProgress(count);
                if (count ==0) {
                    loopFlag = false;
                }
            }
        }
        return "finish";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        tv.setText(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        tv.setText(s);
    }
}