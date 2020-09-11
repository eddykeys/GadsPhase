package com.eddyonkeys.GadsProject;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eddyonkeys.GadsProject.ApiProvider.ApiProvider;
import com.eddyonkeys.GadsProject.ApiProvider.ServiceBuilder;
import com.eddyonkeys.GadsProject.Model.Learner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class LearnerFragment extends Fragment {
    LearnerRecyclerViewAdapter adapter;
    RecyclerView recyclerLearner;
    Retrofit retrofit;
    View v;
    ProgressDialog progressDialog;
    ServiceBuilder serviceBuilder;
    Call<List<Learner>> call;
    List<Learner> learnerList;
    public LearnerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        retrofit = ApiProvider.getRetrofit();
        serviceBuilder = retrofit.create(ServiceBuilder.class);
        call = serviceBuilder.getAllLearner();
        call.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
                progressDialog.dismiss();
                generateDataLearner(response.body());
            }
            @Override
            public void onFailure(Call<List<Learner>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(requireContext(), "Error: " + t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataLearner(List<Learner> body) {
        recyclerLearner=v.findViewById(R.id.recycler_learner);
        adapter = new LearnerRecyclerViewAdapter(learnerList,this.getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerLearner.setLayoutManager(layoutManager);
        recyclerLearner.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_learner, container, false);

        // Inflate the layout for this fragment
        return v;
    }


}