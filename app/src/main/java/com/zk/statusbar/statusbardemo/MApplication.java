package com.zk.statusbar.statusbardemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * author: ZK.
 * date:   On 2017/8/4.
 */
public class MApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
