package com.example.qwer;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Level_5 extends AppCompatActivity {
    LinearLayout tvRed, tvYel, tvGree;
    private boolean a = false;
    Button click, btncatch;
    private int counter = 0;
    Dialog dialog;
    ImageView imageView;
    public int count = 0;
    final  int []progressPoints={
            R.id.point1,
            R.id.point2,
            R.id.point3,
            R.id.point4,
            R.id.point5,
            R.id.point6,
            R.id.point7,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_5);
        tvGree = (LinearLayout) findViewById(R.id.LinGreen);
        tvRed = (LinearLayout) findViewById(R.id.LinRed);
        tvYel = (LinearLayout) findViewById(R.id.LinYellow);
        click = (Button) findViewById(R.id.clickkkk);
        btncatch = (Button) findViewById(R.id.btncatch);
       imageView =(ImageView)findViewById(R.id.imageView10);

        Window w = getWindow();
        Button b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level_5.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        TextView tv = findViewById(R.id.textView);
        tv.setText(R.string.levelushaka5);
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
                    Intent intent = new Intent(Level_5.this, Level_5.class);
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

    public void CLICK(View view) {
        if (!a) {
            click.setText("STOP");
            a = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (a) {
                        counter++;
                        switch (counter) {
                            case 1:
                                tvGree.setBackgroundColor(getResources().getColor(R.color.grenn));
                                tvYel.setBackgroundColor(getResources().getColor(R.color.grey));
                                tvRed.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 2:
                                tvYel.setBackgroundColor(getResources().getColor(R.color.yellow));
                                tvRed.setBackgroundColor(getResources().getColor(R.color.grey));
                                tvGree.setBackgroundColor(getResources().getColor(R.color.grey));
                                break;
                            case 3:
                                tvRed.setBackgroundColor(getResources().getColor(R.color.red));
                                tvGree.setBackgroundColor(getResources().getColor(R.color.grey));
                                tvYel.setBackgroundColor(getResources().getColor(R.color.grey));
                                counter=0;
                                break;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();

                        }

                    }

                }
            }).start();

        } else {
            a = false;
            click.setText("START");}
            btncatch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


            if (counter==1) {
                imageView.setImageResource(R.drawable.img_true);
            } else {
                imageView.setImageResource(R.drawable.img_wrong);

            }

            if(counter==1){
                if(count<7){
                    count=count+1;
                }
                for (int b=0;b<7;b++){
                    TextView qwe=findViewById(progressPoints[b]);
                    qwe.setBackgroundResource(R.drawable.style_points1);
                }
                for(int b=0;b<count;b++){
                    TextView qwe =findViewById(progressPoints[b]);
                    qwe.setBackgroundResource(R.drawable.style_points12);
                    counter=0;
                }
            }else{//права больше левой
                if (count>0){// больше нкля
                    if(count>=1){
                        count=0;
                    }else{

                    }
                }

                for (int b=0;b<6;b++){
                    TextView qwe=findViewById(progressPoints[b]);
                    qwe.setBackgroundResource(R.drawable.style_points1);
                }
                for(int b=0;b<count;b++){
                    TextView qwe =findViewById(progressPoints[b]);
                    qwe.setBackgroundResource(R.drawable.style_points12);
                }

            } if (count==7){
                Intent intent= new Intent(Level_5.this, GameLevels.class);
                startActivity(intent);

            }else{

            }
    }
});
        }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        a = false;
    }

}
