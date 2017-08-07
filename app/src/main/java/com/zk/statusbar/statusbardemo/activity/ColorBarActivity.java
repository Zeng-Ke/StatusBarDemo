package com.zk.statusbar.statusbardemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zk.statusbar.statusbardemo.R;
import com.zk.statusbar.statusbardemo.utils.BarUtil;


/**
 * author: ZK.
 * date:   On 2017/8/5.
 * 纯色状态栏
 */
public class ColorBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_bar);
        BarUtil.setStatusBar(this, Color.parseColor("#43d95d"),0,false);


    }


}
