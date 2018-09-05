package com.zc.swipemenurecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aitsuki.swipe.SwipeItemLayout;
import com.zc.swipemenurecyclerview.R;
import com.zc.swipemenurecyclerview.entity.Type;
import com.zc.swipemenurecyclerview.listener.ItemTouchListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zc on 2018/9/5.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private ItemTouchListener itemTouchListener;
    private List<Integer> mData;

    public MyAdapter(ItemTouchListener itemTouchListener, List<Integer> mData) {
        this.itemTouchListener = itemTouchListener;
        this.mData = mData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rv, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;
        itemHolder.tvContent.setText("item " + mData.get(position));
        itemHolder.swipeLayout.setSwipeEnable(getItemViewType(position) != Type.DISABLE_SWIPE_MENU);
        if (itemTouchListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemTouchListener.onItemClick(itemHolder.tvContent.getText().toString());
                }
            });

            if (itemHolder.rightMenu != null) {
                itemHolder.rightMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemTouchListener.onRightMenuClick("right " + itemHolder.getAdapterPosition());
                        itemHolder.swipeLayout.close();
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.right_menu)
        TextView rightMenu;
        @Bind(R.id.tv_content)
        TextView tvContent;
        @Bind(R.id.swipe_layout)
        SwipeItemLayout swipeLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
