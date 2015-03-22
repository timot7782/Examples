package com.indovation.parktap.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.indovation.parktap.R;


/**
 * Created by Timothy on 3/19/2015.
 */
public class PTHelper {

    public static final int OPENSANS_BOLD = 0;
    public static final int OPENSANS_BOLD_ITALIC = 1;
    public static final int OPENSANS_EXTRA_BOLD = 2;
    public static final int OPENSANS_EXTRA_BOLD_ITALIC = 3;
    public static final int OPENSANS_ITALIC = 4;
    public static final int OPENSANS_LIGHT = 5;
    public static final int OPENSANS_LIGHT_ITALIC = 6;
    public static final int OPENSANS_REGULAR = 7;
    public static final int OPENSANS_SEMI_BOLD = 8;
    public static final int OPENSANS_SEMI_BOLD_ITALIC = 9;

    public static Typeface getFontFaceFromAssets(Context context, int whichFont) {

        switch(whichFont) {
            case OPENSANS_BOLD:
                //You can instantiate your typeface anywhere, I would suggest as a
                //singleton somewhere to avoid unnecessary copies
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Bold.ttf");

            case OPENSANS_BOLD_ITALIC:
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-BoldItalic.ttf");

            case OPENSANS_EXTRA_BOLD:
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-ExtraBold.ttf");

            case OPENSANS_EXTRA_BOLD_ITALIC:
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-ExtraBoldItalic.ttf");

            case OPENSANS_ITALIC:
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Italic.ttf");

            case OPENSANS_LIGHT:default:
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Light.ttf");

            case OPENSANS_LIGHT_ITALIC:
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-LightItalic.ttf");

            case OPENSANS_REGULAR:
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Regular.ttf");

            case OPENSANS_SEMI_BOLD:
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Semibold.ttf");

            case OPENSANS_SEMI_BOLD_ITALIC:
                return Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-SemiboldItalic.ttf");
        }
    }   //end getFontFaceFromAssets

    public static void showPTToast(Activity activity, String theText) {
        //TODO: replace the icon to parktap
        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());
        View layout = inflater.inflate(R.layout.toast_layout_root,null);

        Toast toast = new Toast(activity.getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        TextView text = (TextView) layout.findViewById(R.id.toast_text);
        text.setText(theText);
        toast.setView(layout);
        toast.show();
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }


}
