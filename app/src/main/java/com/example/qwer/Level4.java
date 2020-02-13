package com.example.qwer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Level4 extends AppCompatActivity {
    Dialog dialog;

    public int numquestion;

    public int count = 0;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Random random = new Random();
        final Array array = new Array();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);
        final Button btnRight = findViewById(R.id.btnRIGHT);
        final Button btnLeft = findViewById(R.id.btnLEFT);
        final ImageView imageView =findViewById(R.id.imageView10);
        final TextView tvQuestion = findViewById(R.id.question);

      /*  imgLeft.setClipToOutline(true);
        imgRight.setClipToOutline(true);*/
        final  int []progress={
                R.id.point1,
                R.id.point2,
                R.id.point3,
                R.id.point4,
                R.id.point5,
                R.id.point6,
                R.id.point7,
                R.id.point8,
                R.id.point9,
                R.id.point10,
                R.id.point11,
                R.id.point12,
                R.id.point13,
                R.id.point14,
                R.id.point15,

        };
        final Animation a = AnimationUtils.loadAnimation(Level4.this, R.anim.alfa);
        Window w = getWindow();
        Button b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level4.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        TextView tv = findViewById(R.id.textView);
        tv.setText(R.string.levelushaka4);
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
                    Intent intent = new Intent(Level4.this, Level5.class);
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
        //???????????????????????????????


        //???????????????????????????????
        numquestion = random.nextInt(40);
        tvQuestion.setText(array.forLevel4[numquestion]);

        btnRight.setOnTouchListener(new View.OnTouchListener() {//ckick no
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {//коснулся начало
                    btnLeft.setEnabled(false);
                    if (numquestion>28) {
                        imageView.setImageResource(R.drawable.img_true);
                    } else {
                        imageView.setImageResource(R.drawable.img_wrong);

                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {//отпустил
                    if(numquestion>28){
                        if(count<15){
                            count=count+1;
                        }
                        for (int b=0;b<10;b++){
                            TextView qwe=findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points1);
                        }
                        for(int b=0;b<count;b++){
                            TextView qwe =findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points12);
                        }
                    }else{//права больше левой
                        if (count>0){// больше нкля
                            if(count>=1){
                                count=0;
                            }else{

                            }
                            }

                        for (int b=0;b<14;b++){
                            TextView qwe=findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points1);
                        }
                        for(int b=0;b<count;b++){
                            TextView qwe =findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points12);
                        }

                    } if (count==15){
                        Intent intent= new Intent(Level4.this,Level5.class);
                        startActivity(intent);

                    }else{
                        numquestion = random.nextInt(40);
                        tvQuestion.setText(array.forLevel4[numquestion]);

                        /*tvQuestion.startAnimation(a);*/

                        imageView.startAnimation(a);

                        btnLeft.setEnabled(true);


                    }

                }
                return true;
            }
        });
        btnLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {//коснулся начало
                    btnRight.setEnabled(false);
                    if (numquestion<29) {
                        imageView.setImageResource(R.drawable.img_true);
                    } else {
                        imageView.setImageResource(R.drawable.img_wrong);

                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {//отпустил
                    if(numquestion<29){
                        if(count<15){
                            count=count+1;
                        }
                        for (int b=0;b<10;b++){
                            TextView qwe=findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points1);
                        }
                        for(int b=0;b<count;b++){
                            TextView qwe =findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points12);
                        }
                    }else{//права больше левой
                        if (count>0){// больше нкля
                            if(count>=1){
                                count=0;
                            }
                            else{}}

                        for (int b=0;b<14;b++){
                            TextView qwe=findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points1);
                        }
                        for(int b=0;b<count;b++){
                            TextView qwe =findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points12);
                        }

                    } if (count==15){
                        Intent intent= new Intent(Level4.this,Level5.class);
                        startActivity(intent);

                    }else{
                        numquestion = random.nextInt(40);
                        tvQuestion.setText(array.forLevel4[numquestion]);

                        /*tvQuestion.startAnimation(a);*/

                        imageView.startAnimation(a);

                        btnRight.setEnabled(true);


                    }

                }
                return true;
            }
        });

    }
}

