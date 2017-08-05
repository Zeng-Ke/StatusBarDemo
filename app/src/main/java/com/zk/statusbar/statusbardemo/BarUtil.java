package com.zk.statusbar.statusbardemo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * author: ZK.
 * date:   On 2017/8/5.
 */
public class BarUtil {


    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setStatusBar(Activity activity, @ColorInt int color, int alpha) {
        ViewGroup viewGroup = getContentView(activity);
        if (viewGroup != null) {
            int alphaColor = alpha == 0 ? color : calculateColor(color, alpha);
            viewGroup.addView(createStatusBarView(activity, alphaColor, 0, true));
        }

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setStatusBar(Activity activity, @DrawableRes int drawableId) {
        ViewGroup viewGroup = getContentView(activity);
        if (viewGroup != null)
            viewGroup.addView(createStatusBarView(activity, 0, drawableId, false));
    }


    private static ViewGroup getContentView(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ViewGroup decorView = (ViewGroup) window.getDecorView();
       // ViewGroup contentView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        return decorView;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setHintBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }


    private static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }


    private static View createStatusBarView(Context context, @ColorInt int color, int drawableId, boolean isColor) {
        View mStatusBarTintView = new View(context);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams
                (FrameLayout.LayoutParams.MATCH_PARENT, getStatusBarHeight(context));
        params.gravity = Gravity.TOP;
        mStatusBarTintView.setLayoutParams(params);
        if (isColor)
            mStatusBarTintView.setBackgroundColor(color);
        else mStatusBarTintView.setBackgroundResource(drawableId);
        return mStatusBarTintView;
    }


    @ColorInt
    private static int calculateColor(@ColorInt int color, int alpha) {
        float a = 1 - alpha / 255f;
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color & 0xff;
        red = (int) (red * a + 0.5);
        green = (int) (green * a + 0.5);
        blue = (int) (blue * a + 0.5);
        return 0xff << 24 | red << 16 | green << 8 | blue;
    }

}
