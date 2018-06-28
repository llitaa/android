package com.example.simplebindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.simplebindingdemo.databinding.EmployeeItemBinding;
import com.example.simplebindingdemo.databinding.ContractorItemBinding;
import com.example.simplebindingdemo.databinding.VendorItemBinding;


import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private List<Person> list = new ArrayList<>();

    public PersonAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    void update(List<Person> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).classification.ordinal();
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ViewDataBinding binding = null;
        switch (viewType) {
            case 0:
                binding = EmployeeItemBinding.inflate(inflater, viewGroup, false);
                break;
            case 1:
                binding = ContractorItemBinding.inflate(inflater, viewGroup, false);
                break;
            case 2:
                binding = VendorItemBinding.inflate(inflater, viewGroup, false);
                break;
        }
        return binding != null ?
                new ViewHolder(binding.getRoot()) : null;
    }

    @Override
    public void onBindViewHolder(PersonAdapter.ViewHolder viewHolder, int position) {
        Person person = list.get(position);
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                ((EmployeeItemBinding) viewHolder.getBinding()).setPerson(person);
                break;
            case 1:
                ((ContractorItemBinding) viewHolder.getBinding()).setPerson(person);
                break;
            case 2:
                ((VendorItemBinding) viewHolder.getBinding()).setPerson(person);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            return DataBindingUtil.getBinding(itemView);
        }
    }
}
