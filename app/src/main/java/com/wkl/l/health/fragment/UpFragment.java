package com.wkl.l.health.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wkl.l.health.activities.R;

/**
 * Created by L on 2016/11/19.
 */

public class UpFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        inflater.inflate(R.layout.fragment_liuyan_id,null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
