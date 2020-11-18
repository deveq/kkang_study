package com.soldemom.part9_25.retrofit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.soldemom.part9_25.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView itemTitleView;
    public TextView itemTimeView;
    public TextView itemDescView;
    public ImageView itemImageView;

    public ItemViewHolder(View view) {
        super(view);
        itemTitleView=view.findViewById(R.id.lab3_item_title);
        itemTimeView=view.findViewById(R.id.lab3_item_time);
        itemDescView=view.findViewById(R.id.lab3_item_desc);
        itemImageView=view.findViewById(R.id.lab3_item_image);
    }
}