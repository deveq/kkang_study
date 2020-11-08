package com.soldemom.part4_10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class DriverAdapter extends ArrayAdapter<DriveVO> {

    Context context;
    int redId;
    ArrayList<DriveVO> datas;

    public DriverAdapter(Context context, int redId, ArrayList<DriveVO> datas) {
        super(context,redId);
        this.context = context;
        this.redId = redId;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(redId,null);
            DriverHolder holder = new DriverHolder(convertView);
            convertView.setTag(holder);
        }

        DriverHolder holder = (DriverHolder)convertView.getTag();

        ImageView typeImageView = holder.typeImageView;
        TextView titleView = holder.titleView;
        TextView dateView = holder.dateView;
        ImageView menuImageView = holder.menuImageView;


        final DriveVO vo = datas.get(position);

        titleView.setText(vo.title);
        titleView.setText(vo.date);

        if (vo.type.equals("doc")) {
            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(
                    context.getResources(), R.drawable.ic_type_doc,null));

        } else if (vo.type.equals("file")) {
            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(
                    context.getResources(), R.drawable.ic_type_file,null));

        } else if (vo.type.equals("img")) {
            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(
                    context.getResources(), R.drawable.ic_type_image,null));

        }

        menuImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(context, vo.title+" menu click", Toast.LENGTH_SHORT);
                toast.show();
            }
        });



        return convertView;
//        return super.getView(position, convertView, parent);
    }
}
