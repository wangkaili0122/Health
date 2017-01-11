package com.wkl.l.health.activities;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by L on 2016/12/8.
 */

public class BingliDetailsActivity extends AppCompatActivity {
    private int id;
    private String name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bingli_details);
        Bundle bundle=getIntent().getExtras();
        id= bundle.getInt("id");
        name=bundle.getString("name");
        String jioadu=bundle.getString("jiaodu");
        String xinlv=bundle.getString("xinlv");
        String xueya=bundle.getString("xueya");
        CardView cv_id =(CardView) findViewById(R.id.cv_id);
        Button btn_zhineng=(Button) findViewById(R.id.button4);
        Button btn_ok=(Button) findViewById(R.id.button5);
        TextView  cv_name_id=(TextView) cv_id.findViewById(R.id.cv_name_id);
        TextView tv_angle_id=(TextView) findViewById(R.id.tv_angle_id);
        TextView tv_bloodpress_id=(TextView) findViewById(R.id.tv_bloodpress_id);
        TextView tv_heartrate_id=(TextView) findViewById(R.id.tv_heartrate_id);
        cv_name_id.setText(name);
        tv_angle_id.setText(jioadu);
        tv_bloodpress_id.setText(xueya);
        tv_heartrate_id.setText(xinlv);
        btn_zhineng.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(BingliDetailsActivity.this,SmartActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("id",id);
                bundle.putString("name",name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btn_ok.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(BingliDetailsActivity.this).setTitle("提示信息")//设置对话框标题

                        .setMessage("确定已经确诊吗")//设置显示的内容

                        .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮
                            @Override
                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                Toast.makeText(BingliDetailsActivity.this," 发送成功", Toast.LENGTH_LONG).show();
                                finish();}

                        }).setNegativeButton("返回",new DialogInterface.OnClickListener() {//添加返回按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//响应事件
                        Log.i("alertdialog"," 已发送请求");
                    }

                }).show();//在按键响应事件中显示此对话框
            }
        });

    }

}
