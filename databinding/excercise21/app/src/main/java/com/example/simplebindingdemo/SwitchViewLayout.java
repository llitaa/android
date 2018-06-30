package com.example.simplebindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.example.simplebindingdemo.databinding.DataViewBinding;
import com.example.simplebindingdemo.databinding.SwitchViewBinding;

public class SwitchViewLayout extends RelativeLayout {

    private SwitchViewBinding binding;
    public SwitchViewModel switchViewModel;

    public SwitchViewLayout(Context context, AttributeSet attrs) {
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
        switchViewModel = new SwitchViewModel();
        binding.setSwitchViewModel(switchViewModel);
        binding.setListeners(this);
    }

    public void onLightsChanged(View view, boolean isChecked) {
        switchViewModel.lightsOn.set(isChecked);
    }

    public void onIsOpenChanged(CompoundButton view, boolean isChecked) {
        switchViewModel.isOpen.set(isChecked);
    }

    public void onReadyChanged(CompoundButton view, boolean isChecked) {
        switchViewModel.isReady.set(isChecked);
    }

}
