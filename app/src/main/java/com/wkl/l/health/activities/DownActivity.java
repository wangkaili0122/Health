package com.wkl.l.health.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by L on 2017/1/10.
 */

public class DownActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_down);
        Button But_send=(Button) findViewById(R.id.button6);
        But_send.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(DownActivity.this).setTitle("提示信息")//设置对话框标题

                        .setMessage("确定发送请求吗？")//设置显示的内容

                        .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮
                            @Override
                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                Toast.makeText(DownActivity.this," 发送成功，等待上级医院处理。。", Toast.LENGTH_LONG).show();
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
