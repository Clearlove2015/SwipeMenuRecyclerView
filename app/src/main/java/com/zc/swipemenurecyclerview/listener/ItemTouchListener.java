package com.zc.swipemenurecyclerview.listener;

/**
 * Created by AItsuki on 2017/7/11.
 * ItemTouchListener
 */
public interface ItemTouchListener {
    void onItemClick(String str);

    void onLeftMenuClick(String str);

    void onRightMenuClick(String str);
}
