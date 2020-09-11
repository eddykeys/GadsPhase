package com.eddyonkeys.GadsProject;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eddyonkeys.GadsProject.ApiProvider.ApiProvider;
import com.eddyonkeys.GadsProject.ApiProvider.ServiceBuilder;
import com.eddyonkeys.GadsProject.Model.Learner;
import com.eddyonkeys.GadsProject.Model.Skill;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class SkillFragment extends Fragment {

    SkillRecyclerViewAdapter mSkillRecyclerViewAdapter;
    RecyclerView recyclerSkill;
    Retrofit retrofit;
    ProgressDialog progressDialog;
    View v;
    ServiceBuilder mServiceBuilder;
    Call<List<Skill>> call;
    List<Skill> skillList;
    public SkillFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        retrofit = ApiProvider.getRetrofit();
        mServiceBuilder = retrofit.create(ServiceBuilder.class);
        call = mServiceBuilder.getAllSkill();
        call.enqueue(new Callback<List<Skill>>() {
            @Override
            public void onResponse(Call<List<Skill>> call, Response<List<Skill>> response) {
                progressDialog.dismiss();
                generateDataSkill(response.body());
            }

            @Override
            public void onFailure(Call<List<Skill>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(requireContext(), "Error: " + t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataSkill(List<Skill> body) {
        recyclerSkill=v.findViewById(R.id.recycler_skill);
        mSkillRecyclerViewAdapter = new SkillRecyclerViewAdapter(body,this.getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerSkill.setLayoutManager(layoutManager);
        recyclerSkill.setAdapter(mSkillRecyclerViewAdapter);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_skill, container, false);
        return v;
    }
}