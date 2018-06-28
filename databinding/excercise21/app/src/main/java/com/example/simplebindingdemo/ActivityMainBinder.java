package com.example.simplebindingdemo;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ActivityMainBinder {
    @BindingAdapter("personList")
    public static void setPersonList(RecyclerView view, List<Person> list){
        if(list == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = view.getLayoutManager();
        if(layoutManager == null) {
            view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        }
        PersonAdapter adapter = (PersonAdapter) view.getAdapter();
        if(adapter == null) {
            adapter = new PersonAdapter(view.getContext());
            view.setAdapter(adapter);
        }
        adapter.update(list);
    }


}
