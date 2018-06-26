package com.example.simplebindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

// import com.example.simplebindingdemo.databinding.ActivityMainBinding;
import com.example.simplebindingdemo.databinding.ActivityMainBinding;
import com.example.simplebindingdemo.databinding.ExpressionsBinding;
import com.example.simplebindingdemo.databinding.ItemViewBinding;
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

        binding.list.setLayoutManager(new LinearLayoutManager(this));
        binding.list.setAdapter(new DataSourceAdaper(getLayoutInflater()));

        initShopItems(binding);
    }

    private void initShopItems(ActivityMainBinding binding)
    {
        ExpressionsBinding raspberryBinding = ExpressionsBinding.inflate(getLayoutInflater(), binding.menu, false);
        raspberryBinding.setItem(new MenuItem(true, "raspberry", "$0.99", 2));
        binding.menu.addView(raspberryBinding.getRoot());

        ExpressionsBinding vanillaSpecialBinding = ExpressionsBinding.inflate(getLayoutInflater(), binding.menu, false);
        vanillaSpecialBinding.setItem(new MenuItem(false, "vanilla", "$2.99", 2));
        binding.menu.addView(vanillaSpecialBinding.getRoot());
    }

    private class DataSourceAdaper extends RecyclerView.Adapter<ViewHolder>{
        private LayoutInflater layoutInflater;

        public DataSourceAdaper(LayoutInflater layoutInflater) {
            this.layoutInflater = layoutInflater;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ItemViewBinding binding = ItemViewBinding.inflate(layoutInflater, parent, false);
            return new ViewHolder(binding.getRoot());
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            DataSource dataSource = DataSource.get("Item Binding" + position);
            ItemViewBinding binding = DataBindingUtil.getBinding(holder.itemView);
            binding.setDataSource(dataSource);
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
