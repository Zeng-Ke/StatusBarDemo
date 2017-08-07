package com.zk.statusbar.statusbardemo.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.view.Gravity;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * author: ZK.
 * date:   On 2017/8/5.
 */
public class BarUtil {


    /**
     * 设置状态栏颜色
     *
     * @param activity
     * @param color
     * @param alpha
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setStatusBar(Activity activity, @ColorInt int color, int alpha, boolean fifSystemWindow) {
        ViewGroup viewGroup = getParentView(activity, fifSystemWindow);
        if (viewGroup != null) {
            int alphaColor = alpha == 0 ? color : calculateColor(color, alpha);
            viewGroup.addView(createStatusBarView(activity, alphaColor, 0, true), 0);
        }

    }

    /**
     * 设置状态栏图片
     *
     * @param activity
     * @param drawableId
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setStatusBar(Activity activity, @DrawableRes int drawableId, boolean fifSystemWindow) {
        ViewGroup viewGroup = getParentView(activity, fifSystemWindow);
        if (viewGroup != null)
            viewGroup.addView(createStatusBarView(activity, 0, drawableId, false), 0);
    }

    /**
     * 获取DecorView
     *
     * @param activity
     * @return
     */
    private static ViewGroup getParentView(Activity activity, boolean fifSystemWindow) {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ViewGroup parentView = null;
        if (fifSystemWindow)
            parentView = (ViewGroup) window.getDecorView();
        else
            parentView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        return parentView;
    }

    /**
     * 让状态栏透明
     *
     * @param activity
     */
    public static void setStatusBarTransparency(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void hideStatusBar(Activity activity) {
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


    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

    /**
     * 获取导航栏高度
     * <p>0代表不存在</p>
     *
     * @return 导航栏高度
     */
    public static int getNavBarHeight(Context context) {
        boolean hasMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
        if (!hasMenuKey && !hasBackKey) {
            Resources res = context.getResources();
            int resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android");
            return res.getDimensionPixelSize(resourceId);
        } else {
            return 0;
        }
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
