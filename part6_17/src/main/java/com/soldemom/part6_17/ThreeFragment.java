package com.soldemom.part6_17;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThreeFragment extends Fragment {

    RecyclerView rv;
    Context context;

    public ThreeFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_three, container,false);

        rv = view.findViewById(R.id.recyclerView);

        ArrayList<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("홍길자");
        list.add("홍길수");
        list.add("홍길순");
        list.add("홍미영");
        list.add("홍뿡뿡");
        list.add("홍꺅꺅");
        list.add("홍길동");
        list.add("홍길자");
        list.add("홍길수");
        list.add("홍길순");
        list.add("홍미영");
        list.add("홍뿡뿡");
        list.add("홍꺅꺅");


        RecyclerAdapter adapter = new RecyclerAdapter();
        adapter.setList(list);
        MyItemDecoration itemDecoration = new MyItemDecoration(context);
        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));





        return view;

    }
}
