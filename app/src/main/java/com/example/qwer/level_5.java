package com.example.qwer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qwer.R;

public class level_5 extends AppCompatActivity {
    LinearLayout tvRed, tvYel, tvGree;
    private boolean a = false;
    Button click;
    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_5);
        tvGree = (LinearLayout) findViewById(R.id.LinGreen);
        tvRed = (LinearLayout) findViewById(R.id.LinRed);
        tvYel = (LinearLayout) findViewById(R.id.LinYellow);
        click = (Button) findViewById(R.id.clickkkk);

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
            click.setText("START");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        a = false;
    }
}
