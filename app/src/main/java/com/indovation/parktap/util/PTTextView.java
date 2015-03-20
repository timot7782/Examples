package com.indovation.parktap.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.indovation.parktap.R;


/**
 * Created by Timothy on 3/19/2015.
 */
public class PTTextView extends TextView {

    public PTTextView(Context context) {
        super(context);
    }

    public PTTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(context,attrs);
    }

    public PTTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttributes(context,attrs);
    }

    private void parseAttributes(Context context, AttributeSet attrs) {
        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.PTTextView);

        //The value 0 is a default, but shouldn't ever be used since the attr is an enum
        int typeface = values.getInt(R.styleable.PTTextView_typeface, 0);

        setTypeface(PTHelper.getFontFaceFromAssets(context, typeface));

        values.recycle();
    }
}
