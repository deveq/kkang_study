package com.soldemom.part4_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = findViewById(R.id.tv);

        String data = "복수초 \n img \n 이른 봄 설산에서 만나는 복수초는 모든 야생화 찍사들의 로망이 아닐까 싶다.";


        SpannableStringBuilder builder = new SpannableStringBuilder(data);



        // img라는 문자열의 시작 위치
        int start = data.indexOf("img");

        if (start >-1) {
            //img 문자열의 끝 위치
            int end = start + "img".length();

            //이미지 획득
            Drawable dr = ResourcesCompat.getDrawable(getResources(), R.drawable.img1, null);

            //이미지의 화면 출력정보 설정
            //만약 setBounds를 설정하지 않으면 크기가 0이 되어 이미지가 출력되지 않음.
            dr.setBounds(0, 0, dr.getIntrinsicWidth(), dr.getIntrinsicHeight());

            //ImageSpan 준비
            ImageSpan span = new ImageSpan(dr);

            //SpannableStringBuilder에 ImageSpan 적용
            builder.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        //복수초 문자열 시작 위치 획득
        start = data.indexOf("복수초");
        if (start > -1) {
            //문자열의 끝 위치 획득
            int end = start + "복수초".length();

            // bold 타입으로 StyleSpan 준비
            StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
            // 기본 크기보다 2배 크게 표현하는 Span 준비
            RelativeSizeSpan sizeSpan = new RelativeSizeSpan(2.0f);

            //Span 적용
            builder.setSpan(styleSpan,start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            builder.setSpan(sizeSpan,start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            text.setText(builder);

        }

    }



}


