package com.eddyonkeys.GadsProject;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

    public LearnerFragment() {

        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        ServiceBuilder serviceBuilder = retrofit.create(ServiceBuilder.class);
        Call<List<Learner>> call = serviceBuilder.getAllLearner();
        call.enqueue(new Callback<List<Learner>>() {
            @Override
            public void onResponse(Call<List<Learner>> call, Response<List<Learner>> response) {
                progressDialog.dismiss();
                generateLearnerList(response.body());
            }

            @Override
            public void onFailure(Call<List<Learner>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(requireContext(), "Error: " + t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_learner, container, false);
        // Inflate the layout for this fragment
        return v;
    }

    private void generateLearnerList(List<Learner> body) {
        recyclerLearner=v.findViewById(R.id.recycler_learner);
        adapter = new LearnerRecyclerViewAdapter();
        recyclerLearner.setAdapter(adapter);

    }
}