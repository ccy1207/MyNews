package com.example.administrator.mynews.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/20.
 */
public class TitleTextView extends TextView {
    public TitleTextView(Context context) {
        super(context);
    }

    public TitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
