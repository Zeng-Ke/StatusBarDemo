package com.zk.statusbar.statusbardemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * author: ZK.
 * date:   On 2017/8/5.
 * 半透明纯色状态栏
 */
public class ColorTranslucentBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_bar);
        BarUtil.setStatusBar(this, Color.MAGENTA, 120);

    }


}
