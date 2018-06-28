package com.example.simplebindingdemo;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class TextViewBindingAdapter {
    @BindingAdapter("numberText")
    public static void setText(TextView view, int number) {
        view.setText(String.valueOf(number));
    }
}
