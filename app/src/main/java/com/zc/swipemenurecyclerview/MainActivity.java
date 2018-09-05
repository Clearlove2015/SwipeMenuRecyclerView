package com.zc.swipemenurecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.aitsuki.swipe.SwipeMenuRecyclerView;
import com.zc.swipemenurecyclerview.adapter.MyAdapter;
import com.zc.swipemenurecyclerview.listener.ItemTouchListener;
import com.zc.swipemenurecyclerview.util.InitDataUtil;
import com.zc.swipemenurecyclerview.util.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * https://github.com/AItsuki/SwipeMenuRecyclerView
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rv)
    SwipeMenuRecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRV();
    }

    public void initRV(){
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(itemTouchListener,InitDataUtil.getFData()));
    }

    ItemTouchListener itemTouchListener = new ItemTouchListener() {
        @Override
        public void onItemClick(String str) {
            ToastUtil.show(MainActivity.this,str);
        }

        @Override
        public void onLeftMenuClick(String str) {
            ToastUtil.show(MainActivity.this,str);
        }

        @Override
        public void onRightMenuClick(String str) {
            ToastUtil.show(MainActivity.this,str);
        }
    };

}
