package com.example.simplebindingdemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.databinding.DataBindingUtil;
import android.widget.TextView;

import com.example.simplebindingdemo.databinding.DataViewBinding;

public class DataView extends LinearLayout {
    private DataViewBinding binding;
    private OnClickListener listener;
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

        Button button = (Button) binding.launchSecondActivityButton;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // MainActivity host = (MainActivity) v.getContext();
                MainActivity act = getActivity(v);
                if(act != null) {
                    act.launchSecondActivity();
                }
            }
        });
    }

    public static MainActivity getActivity(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (MainActivity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

}
