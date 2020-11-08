package com.soldemom.part4_10;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DriverHolder {

    public ImageView typeImageView;
    public TextView titleView;
    public TextView dateView;
    public ImageView menuImageView;


    public DriverHolder(View root) {
        typeImageView = root.findViewById(R.id.custom_item_type_image);
        titleView = root.findViewById(R.id.custom_item_title);
        dateView = root.findViewById(R.id.custom_item_date);
        menuImageView = root.findViewById(R.id.custom_item_menu);
    }
}