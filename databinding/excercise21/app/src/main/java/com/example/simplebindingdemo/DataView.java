package com.example.simplebindingdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.simplebindingdemo.databinding.DataViewBinding;

//public class DataView extends FrameLayout {
public class DataView extends LinearLayout {
    private DataViewBinding binding;

    public DataView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
//
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        binding = DataViewBinding.bind(this);
//        DataSource dataSource = DataSource.get("Data View");
//        binding.setDataSource(dataSource);
    }
}