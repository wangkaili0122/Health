package com.wkl.l.health.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wkl.l.health.activities.BingliActivity;
import com.wkl.l.health.activities.R;

/**
 * Created by L on 2016/11/19.
 */

public class UpFragment extends Fragment {
    private Activity activity;
    private  TextView patientId;
    private  TextView patientName;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        activity=getActivity();
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_up,null);
        patientId=(TextView) view.findViewById(R.id.patientId_id);
        patientName=(TextView) view.findViewById(R.id.patientName_id);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Intent intent=new Intent(activity, );
//        intent.putExtra("patientId",patientId.getText().toString());
//        intent.putExtra("patientName",patientName.getText().toString());
//        startActivityForResult(intent,1);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
