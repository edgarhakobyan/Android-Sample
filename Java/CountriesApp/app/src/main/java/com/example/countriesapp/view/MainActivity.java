package com.example.countriesapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.countriesapp.R;
import com.example.countriesapp.adapter.CompanyAdapter;
import com.example.countriesapp.model.Info;
import com.example.countriesapp.service.GetUserDataService;
import com.example.countriesapp.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Info> infos;
    private CompanyAdapter companyAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCountries();
    }

    private void getCountries() {
        GetUserDataService getUserDataService = RetrofitInstance.getService();
        Call<ArrayList<Info>> call = getUserDataService.getResults();

        call.enqueue(new Callback<ArrayList<Info>>() {
            @Override
            public void onResponse(Call<ArrayList<Info>> call, Response<ArrayList<Info>> response) {
                infos = response.body();
                if (infos != null) {
                    viewData();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Info>> call, Throwable t) {

            }
        });
    }

    private void viewData() {
        recyclerView = findViewById(R.id.rv_countries_list);
        companyAdapter = new CompanyAdapter(infos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(companyAdapter);
    }
}
