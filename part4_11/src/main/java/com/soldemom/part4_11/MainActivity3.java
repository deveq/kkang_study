package com.soldemom.part4_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{

    WebView webView;
    Button lineBtn;
    Button barBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        webView = findViewById(R.id.web_view);
        barBtn = findViewById(R.id.barBtn);
        lineBtn = findViewById(R.id.lineBtn);

        barBtn.setOnClickListener(this);
        lineBtn.setOnClickListener(this);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/test.html");

        webView.addJavascriptInterface(new JavascriptTest(), "android");
        webView.setWebViewClient(new MyWebClient());
        webView.setWebChromeClient(new MyWebChrome());





    }

    @Override
    public void onClick(View v) {
        if(v == lineBtn) {
            webView.loadUrl("javascript:lineChart()");
        } else if (v == barBtn) {
            webView.loadUrl("javascript:barChart()");
        }

    }

    class JavascriptTest {

        @JavascriptInterface
        public String getChartData() {

            StringBuffer buffer = new StringBuffer();
            buffer.append("[");
            for(int i =0; i<14; i++) {
                buffer.append("["+i+","+Math.sin(i)+"]");
                Log.d("kkang",i+","+Math.sin(i));
                if(i<13) buffer.append(",");
            }
            buffer.append("]");
            return buffer.toString();
        }


    }


    class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Toast.makeText(MainActivity3.this,url,Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    class MyWebChrome extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {

            Toast.makeText(MainActivity3.this,message,Toast.LENGTH_SHORT).show();
            result.confirm();
            return true;


        }
    }
}