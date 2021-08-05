package com.newsapp.simple.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.newsapp.simple.FetchedAdapter;
import com.newsapp.simple.R;
import com.newsapp.simple.api.ApiClient;
import com.newsapp.simple.api.ApiInterface;
import com.newsapp.simple.api.MainNews;
import com.newsapp.simple.api.ModelClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntertainmentFragment extends Fragment {

    String apiNews = "6fa171f4d05742f6bd1cb246539f50ad";
    List<ModelClass> modelClassList;
    FetchedAdapter fetchedAdapter;
    String country = "us";
    RecyclerView recyclerViewEntertainmentFragment;
    private String category = "entertainment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.entertainment_fragment, null);
        recyclerViewEntertainmentFragment = v.findViewById(R.id.recyclerViewEntertainmentFragment);
        modelClassList = new ArrayList<>();
        recyclerViewEntertainmentFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchedAdapter = new FetchedAdapter(getContext(), modelClassList);
        recyclerViewEntertainmentFragment.setAdapter(fetchedAdapter);

        findNews();

        return v;
    }

    private void findNews() {
        ApiClient.getApiClient().create(ApiInterface.class).getCategoryNews(country, category, 30, apiNews).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {

                if (response.isSuccessful()) {
                    modelClassList.addAll(response.body().getArticles());
                    fetchedAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });

    }
}
