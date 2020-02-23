package com.example.qwer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levels);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void hru(View view) {
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }

    public void level1(View view) {
        try {
            Intent intent = new Intent(GameLevels.this, Level1.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }


    }

    public void qweasd(View view) {
        try {
            Intent intent = new Intent(GameLevels.this, Level2.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {

        }
    }

    public void lvl3(View view) {
        try {
            Intent intent = new Intent(GameLevels.this, Level_3.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {

        }
    }

    public void level4(View view) {
        try {
            Intent intent = new Intent(GameLevels.this, Level_4.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {

        }
    }

    public void lvl5(View view) {
        try {
            Intent intent = new Intent(GameLevels.this, Level_5.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {

        }
    }

    public void level_6(View view) {
        try {
            Intent intent = new Intent(GameLevels.this, Level_6.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {
        }
    }

    public void level7(View view) {
        try {
            Intent intent = new Intent(GameLevels.this, Level_7.class);
            startActivity(intent);
            finish();

        } catch (Exception e) {
        }

    }
}
