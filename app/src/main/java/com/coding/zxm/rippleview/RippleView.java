package com.coding.zxm.rippleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ZhangXinmin on 2018/12/29.
 * Copyright (c) 2018 . All rights reserved.
 * Ripple effect.
 * 水波涟漪效果
 */
public class RippleView extends View {
    private static final String TAG = RippleView.class.getSimpleName();

    private Context mContext;
    private Paint mPaint;
    //center circle radius
    private float mCenterRadius;
    //ripple color
    private int mRippleColor;

    public RippleView(Context context) {
        this(context, null, 0);
    }

    public RippleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RippleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initParmasAndValues(context, attrs);
    }

    /**
     * dp to px
     */
    public static int dp2px(@NonNull Context context, @FloatRange(from = 0.0) float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px to dp
     */
    public static int px2dp(@NonNull Context context, @FloatRange(from = 0.0) float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * Value of sp to value of px.
     *
     * @param context context
     * @param spValue The value of sp.
     * @return value of px
     */
    public static int sp2px(@NonNull Context context, @FloatRange(from = 0.0) final float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * Value of px to value of sp.
     *
     * @param context context
     * @param pxValue The value of px.
     * @return value of sp
     */
    public static int px2sp(@NonNull Context context, @FloatRange(from = 0.0) final float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    private void initParmasAndValues(Context context, AttributeSet attrs) {
        mContext = context;
        if (attrs != null) {
            final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RippleView);

            //内部小圆半径
            mCenterRadius = typedArray.getDimensionPixelSize(R.styleable.RippleView_center_radius,
                    dp2px(mContext, 30));

            //ripple color
            mRippleColor = typedArray.getColor(R.styleable.RippleView_ripple_color, Color.BLUE);

            typedArray.recycle();
        }
    }
}
