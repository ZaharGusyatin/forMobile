package com.example.qwer;

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

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {
    Dialog dialog;
    Dialog dialog1;
    public int numLeft;//для левой картинки
    public int numRight;//для правой
    public int count = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Array array = new Array();
        final Random random = new Random();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        final ImageView imgLeft = findViewById(R.id.ImLEFT);
        final ImageView imgRight = findViewById(R.id.ImRIGHT);
        final TextView tvright = findViewById(R.id.textRIGHT);
        final TextView tvleft = findViewById(R.id.textLEFT);
        imgLeft.setClipToOutline(true);
        imgRight.setClipToOutline(true);
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
                R.id.point16,
                R.id.point17,
                R.id.point18,
                R.id.point19,
                R.id.point20,
        };
        final Animation a = AnimationUtils.loadAnimation(Level2.this, R.anim.alfa);
        Window w = getWindow();
        Button b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        TextView tv = findViewById(R.id.textView);
        tv.setText(R.string.lvl12345);
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog.setContentView(R.layout.preview_dialog_2);//путь к макету
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон окна
        dialog.setCancelable(false);//нельзя закрыть кнопкой нозад
        TextView x = (TextView) dialog.findViewById(R.id.X);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level2.this, GameLevels.class);
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
        /*dialog1 = new Dialog(this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog1.setContentView(R.layout.preview_dialog_end);//путь к макету
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон окна
        dialog1.setCancelable(false);//нельзя закрыть кнопкой нозад
        TextView xo = (TextView) dialog1.findViewById(R.id.X);
        xo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level2.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
                dialog1.dismiss();
            }
        });
        Button x12 = (Button) dialog1.findViewById(R.id.X1);
        x12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Level2.this,Level2.class);
                    startActivity(intent);
                    finish();}
                catch (Exception e) {

                }
                dialog1.dismiss();

            }
        });*/

        //???????????????????????????????
        numLeft = random.nextInt(10);
        imgLeft.setImageResource(array.ansvers[numLeft]);
        tvleft.setText(array.text1[numLeft]);
        numRight = random.nextInt(10);
        while (numRight == numLeft) {
            numRight = random.nextInt(10);//от 0 до 9 рандом
        }
        imgRight.setImageResource(array.ansvers[numRight]);
        tvright.setText(array.text1[numRight]);
        imgLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {//коснулся начало
                    imgRight.setEnabled(false);
                    if (numLeft < numRight) {
                        imgLeft.setImageResource(R.drawable.img_true);
                    } else {
                        imgLeft.setImageResource(R.drawable.img_wrong);

                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {//отпустил
                    if(numLeft<numRight){
                        if(count<20){
                            count=count+1;
                        }
                        for (int b=0;b<20;b++){
                            TextView qwe=findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points1);
                        }
                        for(int b=0;b<count;b++){
                            TextView qwe =findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points12);
                        }
                    }else{//права больше левой
                        if (count>0){// больше нкля
                            if(count==1){
                                count=0;
                            }
                        else{count=count-2;}}

                        for (int b=0;b<19;b++){
                            TextView qwe=findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points1);
                        }
                        for(int b=0;b<count;b++){
                            TextView qwe =findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points12);
                        }

                    } if (count==20){
                        Intent intent = new Intent(Level2.this,level3.class);
                        startActivity(intent);

                    }else{
                        numLeft = random.nextInt(10);
                        imgLeft.setImageResource(array.ansvers[numLeft]);
                        imgLeft.startAnimation(a);
                        tvleft.setText(array.text1[numLeft]);
                        numRight = random.nextInt(10);
                        while (numRight == numLeft) {
                            numRight = random.nextInt(10);//от 0 до 9 рандом
                        }
                        imgRight.setImageResource(array.ansvers[numRight]);
                        imgRight.startAnimation(a);
                        tvright.setText(array.text1[numRight]);
                        imgRight.setEnabled(true);


                    }

                }
                return true;
            }
        });
        imgRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {//коснулся начало
                    imgLeft.setEnabled(false);
                    if (numRight < numLeft) {
                        imgRight.setImageResource(R.drawable.img_true);
                    } else {
                        imgRight.setImageResource(R.drawable.img_wrong);

                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {//отпустил
                    if(numRight<numLeft){
                        if(count<20){
                            count=count+1;
                        }
                        for (int b=0;b<20;b++){
                            TextView qwe=findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points1);
                        }
                        for(int b=0;b<count;b++){
                            TextView qwe =findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points12);
                        }
                    }else{//права больше левой
                        if (count>0){// больше нкля
                            if(count==1){
                                count=0;
                            }
                            else{count=count-2;}}

                        for (int b=0;b<19;b++){
                            TextView qwe=findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points1);
                        }
                        for(int b=0;b<count;b++){
                            TextView qwe =findViewById(progress[b]);
                            qwe.setBackgroundResource(R.drawable.style_points12);
                        }

                    } if (count==20){
                        Intent intent = new Intent(Level2.this, level3.class);
                        startActivity(intent);

                    }else{
                        numLeft = random.nextInt(10);
                        imgLeft.setImageResource(array.ansvers[numLeft]);
                        imgLeft.startAnimation(a);
                        tvleft.setText(array.text1[numLeft]);
                        numRight = random.nextInt(10);
                        while (numRight == numLeft) {
                            numRight = random.nextInt(10);//от 0 до 9 рандом
                        }
                        imgRight.setImageResource(array.ansvers[numRight]);
                        imgRight.startAnimation(a);
                        tvright.setText(array.text1[numRight]);
                        imgLeft.setEnabled(true);


                    }

                }
                return true;
            }
        });


    }



        @Override
        public void onBackPressed () {
            try {
                Intent intent = new Intent(Level2.this, GameLevels.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {

            }

        }
    }

