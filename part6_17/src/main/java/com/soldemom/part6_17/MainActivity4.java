package com.soldemom.part6_17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        RecyclerView rv = findViewById(R.id.recyclerView2);

        List<String> list = new ArrayList<>();

        for (int i = 0; i< 20; i++) {
            list.add("item=" +i);
        }

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(list));
        rv.addItemDecoration(new MyItemDeco());


    }

    private class MyAdapter extends RecyclerView.Adapter<MyVH> {

        List<String> list;

        public MyAdapter(List<String> list) {
            this.list = list;
        }


        @NonNull
        @Override
        public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(android.R.layout.simple_list_item_1,parent,false);
            return new MyVH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyVH holder, int position) {
            String text = list.get(position);
            holder.title.setText(text);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private class MyVH extends RecyclerView.ViewHolder {
        TextView title;
        public MyVH(View itemView) {
            super(itemView);
            title = itemView.findViewById(android.R.id.text1);
        }
    }

    private class MyItemDeco extends RecyclerView.ItemDecoration {


        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            int index = parent.getChildAdapterPosition(view) + 1;
            if (index % 3 == 0) {
                outRect.set(20,20,20,60);
            } else {
                outRect.set(20,20,20,20);
            }

            view.setBackgroundColor(0xFFECE9E9);
            ViewCompat.setElevation(view, 20.0f);
        }

        @Override
        public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDrawOver(c, parent, state);

            int width = parent.getWidth();
            int height = parent.getHeight();

            Drawable dr = ResourcesCompat.getDrawable(getResources(),R.drawable.android, null);
            int drWidth = dr.getIntrinsicWidth();
            int drHeight = dr.getIntrinsicHeight();

            int left = width/2 - drWidth/2;
            int top = height/2 - drHeight/2;
            c.drawBitmap(BitmapFactory.decodeResource(getResources(),
                    R.drawable.android), left, top, null);

        }


    }
}