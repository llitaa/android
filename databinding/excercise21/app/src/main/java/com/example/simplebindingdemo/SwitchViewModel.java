package com.example.simplebindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import java.util.Observable;

public class SwitchViewModel extends BaseObservable {
    @Bindable
    public final ObservableBoolean lightsOn = new ObservableBoolean();
    @Bindable
    public final ObservableBoolean isOpen = new ObservableBoolean();
    @Bindable
    public final ObservableBoolean isReady = new ObservableBoolean();
}
