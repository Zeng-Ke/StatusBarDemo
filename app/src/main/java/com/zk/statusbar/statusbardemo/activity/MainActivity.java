package com.zk.statusbar.statusbardemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zk.statusbar.statusbardemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void color_click(View view) {
        Intent intent = new Intent(this, ColorBarActivity.class);
        this.startActivity(intent);
    }

    public void tranclucent_click(View view) {
        Intent intent = new Intent(this, ColorTranslucentBarActivity.class);
        this.startActivity(intent);
    }

    public void drawable_click(View view) {
        Intent intent = new Intent(this, DrawableBarActivity.class);
        this.startActivity(intent);
    }

    public void transparency_click(View view) {
        Intent intent = new Intent(this, TransparentBarActivity.class);
        this.startActivity(intent);
    }

    public void hide_click(View view) {
        Intent intent = new Intent(this, HideStatusBarActivity.class);
        this.startActivity(intent);
    }


}

