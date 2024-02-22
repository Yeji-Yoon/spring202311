package com.choongang.exam02;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//인플레이션 XML -> 자바 객체로 변환

        Button button = findViewById(R.id.button); //<Button android:id="@+id/btton">
        Log.i("BUTTON",button.toString());

    }
}