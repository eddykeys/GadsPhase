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
import com.eddyonkeys.GadsProject.Model.Skill;

import java.util.ArrayList;

public class SkillRecyclerViewAdapter extends RecyclerView.Adapter<SkillRecyclerViewAdapter.MySkillViewHolder>{

    private ArrayList<Skill> skillList;
    private Context mContext;

    public SkillRecyclerViewAdapter(ArrayList<Skill> skillList, Context context) {
        this.skillList = skillList;
        mContext = context;
    }

    @NonNull
    @Override
    public MySkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_item, parent, false);
        return new MySkillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillRecyclerViewAdapter.MySkillViewHolder holder, int position) {
//      adding model skill position
        final Skill skills = skillList.get(position);
        holder.skillName.setText(skills.getName());
        holder.skillScore.setText(skills.getScore());
        holder.skillCountry.setText(skills.getCountry());
        Glide.with(mContext).load(skills.getBadgeUrl()).into(holder.skillImage);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MySkillViewHolder extends RecyclerView.ViewHolder {
        ImageView skillImage;
        TextView skillName, skillScore, skillCountry;
        public MySkillViewHolder(@NonNull View itemView) {
            super(itemView);
            skillImage = itemView.findViewById(R.id.img_skill);
            skillName =  itemView.findViewById(R.id.skill_name);
            skillScore =  itemView.findViewById(R.id.skill_score);
            skillCountry =  itemView.findViewById(R.id.skill_country);
        }
    }
}
