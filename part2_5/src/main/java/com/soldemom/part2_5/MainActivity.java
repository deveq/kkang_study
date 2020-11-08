package com.soldemom.part2_5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1;
    Button btn2;
    Button btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);









    }

    @Override
    public void onClick(View v) {


        if (v == btn1) {
//            Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
//            vib.vibrate(1000);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setItems(new String[]{"a", "b", "c"}, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });



        } else if (v == btn2) {
//            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);
//            ringtone.play();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_launcher_foreground);
            builder.setTitle("안녕");
            builder.setMessage("으 어깨아파");
            builder.setPositiveButton("확인",null);
            builder.setNegativeButton("취소",null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();



        } else if (v == btn3) {
//            MediaPlayer player = MediaPlayer.create(this,R.raw.fallbackring);
//            player.start();
            Toast t = new Toast(this);

            ImageView iv = new ImageView(getApplicationContext());
            iv.setImageResource(R.drawable.ic_launcher_foreground);
            iv.setMaxWidth(100);
            iv.setMaxHeight(100);

            t.setDuration(Toast.LENGTH_SHORT);
            t.setView(iv);
            t.show();

        }


    }
}
