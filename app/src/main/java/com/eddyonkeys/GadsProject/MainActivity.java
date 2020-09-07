package com.eddyonkeys.GadsProject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPageAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add fragment here to

        mViewPageAdapter.AddFragment(new LearnerFragment(),"Learner Leaders");
        mViewPageAdapter.AddFragment(new SkillFragment(),"Skill IQ Leaders");
        mViewPager.setAdapter(mViewPageAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }
}