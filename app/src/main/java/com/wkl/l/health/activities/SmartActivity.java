package com.wkl.l.health.activities;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by L on 2017/1/8.
 */

public class SmartActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_smart_result);
        Bundle bundle=getIntent().getExtras();
        int id= bundle.getInt("id");
        String name=bundle.getString("name");
        TextView nono=(TextView) findViewById(R.id.tv_nono_id);
        TextView nana=(TextView) findViewById(R.id.tv_nana_id);
        nono.setText(id+"");
        nana.setText(name);

    }

}
