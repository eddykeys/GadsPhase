package com.eddyonkeys.GadsProject.ApiProvider;


import com.eddyonkeys.GadsProject.Model.Learner;
import com.eddyonkeys.GadsProject.Model.Skill;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceBuilder {

    @GET("api/hours")
    Call<List<Learner>> getAllLearner();

    @GET("api/skilliq")
    Call<List<Skill>> getAllSkill();
}
