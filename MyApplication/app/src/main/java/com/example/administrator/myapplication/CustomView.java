package com.example.administrator.myapplication;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 9/30/2017.
 */

public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.setMeasuredDimension(parentWidth, parentWidth/2);

    }
}






