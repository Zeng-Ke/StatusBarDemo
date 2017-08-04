package com.zk.statusbar.statusbardemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blankj.utilcode.util.BarUtils;

public class ColorBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_bar);
        BarUtils.setStatusBarColor(this, Color.parseColor("#43d95d"),0);
    }
}
