package com.soldemom.part4_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

public class SpannableText extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable_text);


        text = findViewById(R.id.tv);

        String data = "복수초 \n img \n 이른 봄 설산에서 만나는 복수초는 모든 야생화 찍사들의 로망이 아닐까 싶다.";


        // img라는 문자열의 시작 위치
        int start = data.indexOf("img");

        if (start >-1) {
            //img 문자열의 끝 위치
            int end = start + "img".length();

            //이미지 획득

        }



    }
}