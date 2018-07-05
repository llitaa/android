package com.example.simplebindingdemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.databinding.DataBindingUtil;
import android.widget.TextView;

import com.example.simplebindingdemo.databinding.DataViewBinding;

public class DataView extends LinearLayout {
    private DataViewBinding binding;

    public DataView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        binding = DataBindingUtil.getBinding(this);
//        binding = DataViewBinding.bind(this);
        DataSource dataSource = DataSource.get("Data View");
        binding.setDataSource(dataSource);
        // Apply gradient
        TextView tw = (TextView) binding.textViewWithGradient;
        LinearGradient ls = new LinearGradient(0,0, 0, tw.getTextSize(), Color.GREEN, Color.RED, Shader.TileMode.REPEAT);
        tw.getPaint().setShader(ls);
        tw.setTextSize(40);

    }
}
