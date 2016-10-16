package com.ada.flicks.utils;

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

    public static final String FORMAT_DAY = "m/d/yy";
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
}
