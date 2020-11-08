package com.soldemom.part2_6;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

/**
 * Created by kkang
 * 깡샘의 안드로이드 프로그래밍 - 루비페이퍼
 * 위의 교제에 담겨져 있는 코드로 설명 및 활용 방법은 교제를 확인해 주세요.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{

    TextView bellTextView;
    TextView labelTextView;
    CheckBox repeatCheckView;
    CheckBox vibrateCheckView;
    Switch switchView;
    Button btnNext;

    float initX;
    long initTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bellTextView = findViewById(R.id.bell_name);
        labelTextView =findViewById(R.id.label);
        repeatCheckView=findViewById(R.id.repeatCheck);
        vibrateCheckView=findViewById(R.id.vibrate);
        switchView=findViewById(R.id.onOff);

        bellTextView.setOnClickListener(this);
        labelTextView.setOnClickListener(this);

        repeatCheckView.setOnCheckedChangeListener(this);
        vibrateCheckView.setOnCheckedChangeListener(this);
        switchView.setOnCheckedChangeListener(this);

        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NextActivity.class));
            }
        });



    }

    @Override
    public void onClick(View v) {
        if (v==bellTextView) {
            showToast("bell text click event...");
        } else if (v==labelTextView) {
            showToast("label text click event...");
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView == repeatCheckView) {
            showToast("repeat checkbox is " + isChecked);
        } else if (buttonView == vibrateCheckView) {
            showToast("vibrate checkbox is " + isChecked);
        } else if (buttonView == switchView) {
            showToast("switch is " + isChecked);
        }

    }

    public void showToast(String message) {
        Toast toast = Toast.makeText(this,message,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            initX = event.getRawX();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            float diffX = initX - event.getRawX();

            if (diffX > 30) {
                showToast("화면을 왼쪽으로 밀었습니다.");
            } else if (diffX < -30) {
                showToast("화면을 오른쪽으로 밀었습니다.");
            }

        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - initTime> 3000) { //float는 기본값이 0이라서
                showToast("종료하려면 한 번 더 누르세요" + initTime);
                initTime = System.currentTimeMillis();
            } else {
                finish();
            }
        }

        return true;
    }
}