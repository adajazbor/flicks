package com.ada.flicks.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ada on 9/29/16.
 */
public class Utils {

    public static final String FORMAT_DAY = "yyyy-MM-dd";
    public static final String GSON_DATE_FORMAT = "yyyy-MM-dd";

    public static <T> T parseJSON(String response,  Class<T> classOfT) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(GSON_DATE_FORMAT);
        Gson gson = gsonBuilder.create();
        return gson.fromJson(response, classOfT);
    }

    public static String formatDay(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dt = new SimpleDateFormat(FORMAT_DAY);
        return dt.format(date);
    }

    public static void setSpinnerItemByValue(Spinner spnr, String value) {
        if (value == null) {
            spnr.setSelection(0);
            return;
        }
        SpinnerAdapter adapter = (SpinnerAdapter) spnr.getAdapter();
        for (int position = 0; position < adapter.getCount(); position++) {
            if (value.equals(adapter.getItemId(position))) {
                spnr.setSelection(position);
                return;
            }
        }
    }

    // DeviceDimensionsHelper.getDisplayWidth(context) => (display width in pixels)
    public static int getDisplayWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    // DeviceDimensionsHelper.getDisplayHeight(context) => (display height in pixels)
    public static int getDisplayHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    // DeviceDimensionsHelper.convertDpToPixel(25f, context) => (25dp converted to pixels)
    public static float convertDpToPixel(float dp, Context context){
        Resources r = context.getResources();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }

    // DeviceDimensionsHelper.convertPixelsToDp(25f, context) => (25px converted to dp)
    public static float convertPixelsToDp(float px, Context context){
        Resources r = context.getResources();
        DisplayMetrics metrics = r.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }
}
