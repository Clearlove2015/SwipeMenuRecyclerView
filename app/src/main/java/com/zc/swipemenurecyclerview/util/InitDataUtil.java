package com.zc.swipemenurecyclerview.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zc on 2018/9/5.
 */

public class InitDataUtil {

    public static List<Integer> getFData(){
        List<Integer> mData = new ArrayList<>();
        for (int i = 0;i<30;i++){
            mData.add(i);
        }
        return mData;
    }

}
