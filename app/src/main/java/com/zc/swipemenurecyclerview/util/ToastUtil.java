package com.zc.swipemenurecyclerview.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by AItsuki on 2017/3/17.
 */
public class ToastUtil {

    public static void show(Context context,String message) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
