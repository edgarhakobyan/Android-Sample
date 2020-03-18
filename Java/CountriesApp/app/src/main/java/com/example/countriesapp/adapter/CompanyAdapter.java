package com.example.countriesapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countriesapp.R;
import com.example.countriesapp.model.Info;

import java.util.ArrayList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {
    private ArrayList<Info> companiesList;

    public CompanyAdapter(ArrayList<Info> companiesList) {
        this.companiesList = companiesList;
    }

    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_company, parent, false);

        return new CompanyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        holder.companyTextView.setText(companiesList.get(position).getCompany().getName());
    }

    @Override
    public int getItemCount() {
        return companiesList.size();
    }

    class CompanyViewHolder extends RecyclerView.ViewHolder {
        private TextView companyTextView;

        CompanyViewHolder(@NonNull View itemView) {
            super(itemView);

            companyTextView = itemView.findViewById(R.id.tv_company_name);
        }
    }
}
