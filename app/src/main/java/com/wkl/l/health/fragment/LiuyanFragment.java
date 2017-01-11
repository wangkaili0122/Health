package com.wkl.l.health.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wkl.l.health.activities.R;

/**
 * Created by L on 2016/11/19.
 */

public class LiuyanFragment extends Fragment {
    private Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
       activity= getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_liuyan_id,null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
