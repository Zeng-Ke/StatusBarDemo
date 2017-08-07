package com.zk.statusbar.statusbardemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zk.statusbar.statusbardemo.utils.BarUtil;
import com.zk.statusbar.statusbardemo.R;

/**
 * author: ZK.
 * date:   On 2017/8/5.
 */
public class DrawableBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_bar);

        BarUtil.setStatusBar(this,R.drawable.shape_status_bg,false); //当根部局添加了fifSystemWindow = true时，第三个参数为true，否则为false。
    }


}
