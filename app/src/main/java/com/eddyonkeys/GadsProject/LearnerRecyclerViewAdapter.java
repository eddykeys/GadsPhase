package com.eddyonkeys.GadsProject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eddyonkeys.GadsProject.Model.Learner;

import java.util.ArrayList;

public class LearnerRecyclerViewAdapter extends RecyclerView.Adapter<LearnerRecyclerViewAdapter.MyLearnerViewHolder> {

//    member declarations
    private ArrayList<Learner> learnerList;
    private Context Context;


    public LearnerRecyclerViewAdapter(ArrayList<Learner> learnerList, Context context) {
        this.learnerList = learnerList;
        this.Context = context;
    }

    @NonNull
    @Override
    public MyLearnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //adding inflater of learner item to recycler adapter
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learner_item, parent, false);
        return new MyLearnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyLearnerViewHolder holder, int position) {
        // adding model learner position
       final Learner learners = learnerList.get(position);
       holder.learnerName.setText(learners.getName());
       holder.learnerHour.setText(learners.getHours());
       holder.learnerCountry.setText(learners.getCountry());
       Glide.with(Context).load(learners.getBadgeUrl()).into(holder.learnerImage);
    }

    @Override
    public int getItemCount() {
        return learnerList.size();
    }

    public static class MyLearnerViewHolder extends RecyclerView.ViewHolder {
//        member declaration for itemView
        ImageView learnerImage;
        TextView learnerName, learnerHour, learnerCountry;
        public MyLearnerViewHolder(@NonNull View itemView) {
            super(itemView);
//          linking to skill item
            learnerImage=itemView.findViewById(R.id.img_learner);
            learnerName=itemView.findViewById(R.id.learner_name);
            learnerHour=itemView.findViewById(R.id.learner_hours);
            learnerCountry=itemView.findViewById(R.id.learner_country);

        }
    }
}
