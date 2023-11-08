package com.illinois.cs465.doctorsorders; // Replace with your actual package name

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.illinois.cs465.doctorsorders.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout btnShowFirstLayout;
    private LinearLayout btnShowSecondLayout;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookevent); // Replace with your actual layout name

        firstLayout = findViewById(R.id.btnShowFirstLayout);
        btnShowSecondLayout = findViewById(R.id.btnShowSecondLayout);
    }

    public void showFirstLayout(View view) {
        btnShowFirstLayout.setVisibility(View.VISIBLE);
        btnShowSecondLayout.setVisibility(View.GONE);
    }

    public void showSecondLayout(View view) {
        secondLayout.setVisibility(View.VISIBLE);
        btnShowSecondLayout.setVisibility(View.GONE);
    }
}
