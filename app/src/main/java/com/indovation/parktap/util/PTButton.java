package com.indovation.parktap.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;

import com.indovation.parktap.R;


/**
 * Created by Timothy on 3/19/2015.
 */
public class PTButton extends Button {

    public PTButton(Context context) {
        super(context);
    }

    public PTButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            parseAttributes(context,attrs);
        }
    }

    public PTButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            parseAttributes(context,attrs);
        }
    }

    private void parseAttributes(Context context, AttributeSet attrs) {
        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.PTButton);

        //The value 0 is a default, but shouldn't ever be used since the attr is an enum
        int typeface = values.getInt(R.styleable.PTButton_typeface, 0);

        setTypeface(PTHelper.getFontFaceFromAssets(context, typeface));
        setBackgroundColor(getResources().getColor(R.color.main));
        values.recycle();
    }
}
