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

public class Level_6 extends AppCompatActivity {
    LinearLayout tvColor;
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
        setContentView(R.layout.activity_level_6);
        tvColor = (LinearLayout) findViewById(R.id.LayoutColor);

        click = (Button) findViewById(R.id.clickkkk);
        btncatch = (Button) findViewById(R.id.btncatch);
       imageView =(ImageView)findViewById(R.id.imageView10);

        Window w = getWindow();
        Button b1 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level_6.this, GameLevels.class);
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
                    Intent intent = new Intent(Level_6.this, Level_6.class);
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
                                tvColor.setBackgroundResource(R.drawable.stylenew_green);
                                break;
                            case 2:
                                tvColor.setBackgroundResource(R.drawable.stylenew_blue);
                                break;
                            case 3:
                                tvColor.setBackgroundResource(R.drawable.stylenew_grey);
                                break;
                            case 4:
                                tvColor.setBackgroundResource(R.drawable.stylenew_dark);
                                break;
                            case 5:
                                tvColor.setBackgroundResource(R.drawable.stylenew_yellow);
                                break;
                            case 6:
                                tvColor.setBackgroundResource(R.drawable.stylenew_white);
                                break;
                            case 7:
                                tvColor.setBackgroundResource(R.drawable.stylenew_pink);
                                break;
                            case 8:
                                tvColor.setBackgroundResource(R.drawable.stylenew_orange);
                                break;
                            case 9:
                                tvColor.setBackgroundResource(R.drawable.stylenew_red);
                                counter=0;
                                break;


                        }
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();


                        }

                    }

                }
            }).start();

        } else {
            click.setText("START");}
            btncatch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {






    }
});
        }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        a = false;
    }

}
