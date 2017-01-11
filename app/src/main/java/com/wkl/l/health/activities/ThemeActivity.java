package com.wkl.l.health.activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;


import com.wkl.l.health.fragment.BingliFragment;
import com.wkl.l.health.fragment.DownFragment;
import com.wkl.l.health.fragment.LiuyanFragment;
import com.wkl.l.health.fragment.UpFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/11/14.
 */

public class ThemeActivity extends AppCompatActivity {
    private RadioGroup group;
    private List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        linked();
    }
    private void initView(){
         group=(RadioGroup) findViewById(R.id.group_id);
       Fragment fragment1= new BingliFragment();
        Fragment fragment2= new DownFragment();
        Fragment fragment3= new UpFragment();
        Fragment fragment4= new LiuyanFragment();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
      getFragmentManager().beginTransaction().replace(R.id.base_fragment_id,fragments.get(0)).commit();
    }
    private void linked(){
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                for (int j=0;j<group.getChildCount();j++){
                    if (group.getChildAt(j).getId()==i){
                        getFragmentManager().beginTransaction().replace(R.id.base_fragment_id,fragments.get(j)).commit();
                    }
                }
            }
        });
    }
}
