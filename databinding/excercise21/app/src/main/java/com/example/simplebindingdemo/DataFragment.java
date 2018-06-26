package com.example.simplebindingdemo;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplebindingdemo.databinding.FragmentDataBinding;

public class DataFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        inflater.inflate(R.layout.fragment_data, container, false);
        FragmentDataBinding binding = FragmentDataBinding.inflate(inflater);

        DataSource dataSource = DataSource.get("Fragment Binding");
        binding.setDataSource(dataSource);
        return binding.getRoot();
    }
}
