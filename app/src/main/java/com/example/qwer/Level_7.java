package com.example.qwer;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level_7 extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer sounds;
    LinearLayout tvColor;
    final Random random = new Random();
    public int numquestion;
    ImageView stvolImageView;

    private boolean a = false;
    Button tvSpin,tvShoot;
    private int counter = 0;
    Dialog dialog;
    ImageView imageView;
    public int count = 0;
    final  int []progressPoints={
            R.id.point1,
            R.id.point2,
            R.id.point3,
            R.id.point4,


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_7);
        tvColor = (LinearLayout) findViewById(R.id.LayoutColor);
        tvSpin =(Button) findViewById(R.id.btnSpinTheDrum);
        tvShoot =(Button) findViewById(R.id.btnPullTheTrigger);
        tvShoot.setOnClickListener(this);
        tvSpin.setOnClickListener(this);
        stvolImageView =(ImageView) findViewById(R.id.stvol);


        imageView =(ImageView)findViewById(R.id.imageView10);
        Button b1 = (Button) findViewById(R.id.button2);
        Window w = getWindow();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level_7.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        TextView tv = findViewById(R.id.textView);
        tv.setText(R.string.levelushaka6);
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog.setContentView(R.layout.previewforlvl4);//путь к макету
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон окна
        dialog.setCancelable(false);//нельзя закрыть кнопкой нозад
        TextView x = (TextView) dialog.findViewById(R.id.X);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level_7.this, Level_6.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                dialog.dismiss();
            }
        });
        Button x1 = (Button) dialog.findViewById(R.id.X1);
        x1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();

    }







    @Override
    protected void onDestroy() {
        super.onDestroy();
        a = false;
    }


    @Override
    public void onClick(View v) {
        numquestion = random.nextInt(2);
        switch (v.getId()){
            case R.id.btnSpinTheDrum:
                numquestion =random.nextInt(2);
                sounds=MediaPlayer.create(this, R.raw.tryyyy);
                sounds.start();
                break;
            case R.id.btnPullTheTrigger:
                if (numquestion==1){
                    sounds=MediaPlayer.create(this, R.raw.shoot);
                    sounds.start();
                   stvolImageView.setImageResource(R.drawable.wasted);
                    startMainActivity();
                    tvShoot.setEnabled(false);
                    tvSpin.setEnabled(false);






                }else{sounds=MediaPlayer.create(this, R.raw.fail);
                imageView.setImageResource(R.drawable.img_true);
                    if(count<4){
                        count=count+1;
                    }
                    for (int b=0;b<4;b++){
                        TextView qwe=findViewById(progressPoints[b]);
                        qwe.setBackgroundResource(R.drawable.style_points1);
                    }
                    for(int b=0;b<count;b++){
                        TextView qwe =findViewById(progressPoints[b]);
                        qwe.setBackgroundResource(R.drawable.style_points12);
                    }


                    }

                }

        }
    public void startMainActivity(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Level_7.this, GameLevels.class);
                startActivity(intent);

            }
        }).start();
    }

    }
