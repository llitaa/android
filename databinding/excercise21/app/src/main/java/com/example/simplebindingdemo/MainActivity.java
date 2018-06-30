package com.example.simplebindingdemo;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// import com.example.simplebindingdemo.databinding.ActivityMainBinding;
import com.example.simplebindingdemo.databinding.ActivityMainBinding;
import com.example.simplebindingdemo.databinding.ExpressionsBinding;
import com.example.simplebindingdemo.databinding.ItemViewBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// import com.example.simplebindingdemo.databinding.DataBindingUtils;

//impoty android.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public String imageUrl = "https://www.w3schools.com/images/w3schools_green.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate layout
    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    // Get data
    DataSource dataSource = DataSource.get("Data from parent");
    DataSource includeSource = DataSource.get("Included Source");
    // Set binding
        binding.setDataSource(dataSource);
        binding.setIncludeSource(includeSource);

        binding.setImageUrl(imageUrl);
        binding.setNumber(100);

        binding.list.setLayoutManager(new LinearLayoutManager(this));
        binding.list.setAdapter(new DataSourceAdaper(getLayoutInflater()));

    initShopItems(binding);

        binding.setListeners(new Listeners(binding));

        this.binding = binding;
}

    @Override
    protected void onResume() {
        super.onResume();
        binding.setEmployeesList(getDefaultEmployees());
    }

    private List<Person> getDefaultEmployees() {
        List<Person> res = Arrays.asList(
                new Person("John Doe", Person.Classification.EMPLOYEE),
                new Person("Bob Dilan", Person.Classification.EMPLOYEE),
                new Person("Romy Allan", Person.Classification.VENDOR),
                new Person("The Carver", Person.Classification.CONTRACTOR));

        return res;
    }

    private void initShopItems(ActivityMainBinding binding) {
        ExpressionsBinding raspberryBinding = ExpressionsBinding.inflate(getLayoutInflater(), binding.menu, false);
        raspberryBinding.setItem(new MenuItem(true, "raspberry", "$0.99", 2));
        binding.menu.addView(raspberryBinding.getRoot());

        ExpressionsBinding vanillaSpecialBinding = ExpressionsBinding.inflate(getLayoutInflater(), binding.menu, false);
        vanillaSpecialBinding.setItem(new MenuItem(false, "vanilla", "$2.99", 2));
        binding.menu.addView(vanillaSpecialBinding.getRoot());
    }

    public class DataSourceAdaper extends RecyclerView.Adapter<ViewHolder> {
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
            return 3;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class Listeners implements View.OnClickListener {

        private ActivityMainBinding binding;

        public Listeners(ActivityMainBinding bnd) {
            this.binding = bnd;
        }

        @Override
        public void onClick(View v) {
            int number = binding.getNumber();
            List<Person> employees = new ArrayList<>(binding.getEmployeesList());
            if (v.getId() == R.id.addEmployeesButton) {
                binding.setNumber(++number);
                String ind = Integer.toString(number);
                String name = "Name " + ind;
                employees.add(new Person(name, Person.Classification.VENDOR));
                binding.setEmployeesList(employees);
            } else if (v.getId() == R.id.removeEmployeesButton) {
                if (number > 0) {
                    binding.setNumber(--number);
                }
                employees.remove(employees.size() - 1);
                binding.setEmployeesList(employees);
            }

            // Toast.makeText(v.getContext(), "Button Pressed", Toast.LENGTH_SHORT).show();
        }
    }

}
