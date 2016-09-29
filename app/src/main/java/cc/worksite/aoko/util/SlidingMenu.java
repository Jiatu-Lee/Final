package cc.worksite.aoko.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;

import cc.worksite.aoko.R;


/**
 * Created by Lee on 2016/7/29 0029.
 */
public class SlidingMenu extends HorizontalScrollView {
    // 屏幕宽度
    private int mScreenWidth;
    //单位：dp
    private int mMenuPadding = 80;
    // 菜单的宽度
    private int mMenuWidth;
    private int mHalfMenuWidth;
    private ViewGroup menu;
    private ViewGroup content;
    private boolean once;
    private boolean isOpen;

    public SlidingMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public SlidingMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mScreenWidth = dm.widthPixels;

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.SlidingMenu, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.SlidingMenu_rightPadding:
                    mMenuPadding = a.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(
                                    TypedValue.COMPLEX_UNIT_DIP, 80f,
                                    getResources().getDisplayMetrics()));
                    break;
            }
        }
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /**
         * 显示的设置一个宽度
         */
        if (!once) {
            LinearLayout wrapper = (LinearLayout) getChildAt(0);
            content = (ViewGroup) wrapper.getChildAt(0);
            menu = (ViewGroup) wrapper.getChildAt(1);
            // dp to px
            mMenuPadding = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, mMenuPadding, getResources().getDisplayMetrics());

            mMenuWidth = mScreenWidth - mMenuPadding;
            mHalfMenuWidth = mMenuWidth / 2;
            menu.getLayoutParams().width = mMenuWidth;
            content.getLayoutParams().width = mScreenWidth;

        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            // 将菜单隐藏
            this.scrollTo(0, mMenuWidth);
            once = true;
        }
    }

    /**
     * @param l    代表left,也就是触摸点相对左上角的偏移量。
     * @param t    代表top,也就是触摸点相对左上角的偏移量。
     * @param oldl oldl就是滑动前的偏移量。
     * @param oldt oldt也是滑动前的偏移量。
     */
    @Override

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        float scale = l * 1.0f / mMenuWidth;
        float contentScale = 1 - 0.3f * scale;
        float menuScale = 0.8f + scale * 0.2f;


        ViewHelper.setScaleX(menu, menuScale);
        ViewHelper.setScaleY(menu, menuScale);
        ViewHelper.setAlpha(menu, 0.95f + 0.05f * (1 - scale));
        ViewHelper.setTranslationX(menu, 0);

        ViewHelper.setPivotX(content, content.getWidth());
        ViewHelper.setPivotY(content, content.getHeight() / 2);
        ViewHelper.setScaleX(content, contentScale);
        ViewHelper.setScaleY(content, contentScale);


    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            // Up时，进行判断，如果显示区域大于菜单宽度一半则完全显示，否则隐藏
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                if (scrollX > mHalfMenuWidth) {
                    this.smoothScrollTo(mMenuWidth, 0);
                    isOpen = false;
                } else {
                    this.smoothScrollTo(0, mMenuWidth);
                    isOpen = true;
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 打开菜单
     */
    public void openMenu() {
        if (isOpen)
            return;
        this.smoothScrollTo(mMenuWidth, 0);
        isOpen = true;
    }


    /**
     * 关闭菜单
     */
    public void closeMenu() {
        if (isOpen) {
            this.smoothScrollTo(0, mMenuWidth);
            isOpen = false;
        }
    }


    /**
     * 切换菜单状态
     */
    public void toggle() {
        if (isOpen) {
            closeMenu();
        } else {
            openMenu();
        }
    }

}