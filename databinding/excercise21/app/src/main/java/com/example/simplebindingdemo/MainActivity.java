package com.example.simplebindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

// import com.example.simplebindingdemo.databinding.ActivityMainBinding;
import com.example.simplebindingdemo.databinding.ActivityMainBinding;
import com.example.simplebindingdemo.databinding.ExpressionsBinding;
// import com.example.simplebindingdemo.databinding.DataBindingUtils;

//impoty android.databinding.DataBindingUtil;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate layout
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // Get data
        DataSource dataSource = DataSource.get("Lol Kek");
        DataSource includeSource = DataSource.get("Included Source");
        // Set binding
        binding.setDataSource(dataSource);
        binding.setIncludeSource(includeSource);

        ExpressionsBinding raspberryBinding = ExpressionsBinding.inflate(getLayoutInflater(), binding.menu, false);
    }
}
