package com.zk.statusbar.statusbardemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zk.statusbar.statusbardemo.utils.BarUtil;
import com.zk.statusbar.statusbardemo.R;

/**
 * author: ZK.
 * date:   On 2017/8/5.
 * 透明状态栏
 *
 */
public class HideStatusBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);
        BarUtil.hideStatusBar(this);
    }
}
