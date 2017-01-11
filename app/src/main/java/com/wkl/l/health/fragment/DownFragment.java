package com.wkl.l.health.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.wkl.l.health.activities.DownActivity;
import com.wkl.l.health.activities.R;


/**
 * Created by L on 2016/11/19.
 */

public class DownFragment extends Fragment {
    private Activity activity;
    private Spinner provinceSpinner = null;  //省级（省、直辖市）
    private Spinner citySpinner = null;     //地级市
    private Spinner countySpinner = null;    //县级（区、县、县级市）
    ArrayAdapter<String> provinceAdapter = null;  //省级适配器
    ArrayAdapter<String> cityAdapter = null;    //地级适配器
    ArrayAdapter<String> countyAdapter = null;    //县级适配器
    static int provincePosition = 3;
    //省级选项值
    private String[] province = new String[] {"重庆","上海","天津","广东","黑龙江","江苏","山东","浙江","香港","澳门"};
    private String[][] city = new String[][]
            {
                    { "东城医院", "西城医院", "崇文医院", "宣武医院", "朝阳区", "海淀区", "丰台区", "石景山区", "门头沟区",
                            "房山医院", "通州医院", "顺义医院", "大兴医院", "昌平医院", "平谷医院"},
                    { "长宁医院", "静安医院", "普陀医院", "闸北医院", "虹口医院" },
                    { "和平医院", "河东医院", "河西医院", "南开医院", "河北医院", "红桥医院", "塘沽医院", "汉沽医院", "大港医院", "东丽医院" },
                    { "广州医院", "深圳医院", "韶关医院","珠海医院","汕头医院","佛山医院","湛江医院","肇庆医院","江门医院","茂名医院"}
            };
    //县级选项值
    private String[][][] county = new String[][][]
            {
                    {   //北京
                            {"李丽"},{"李金华"},{"张红"},{"李萍"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},
                            {"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"}},
                    {    //上海
                            {"李淑婷"},{"王真"},{"魏样"},{"小球"},{"周乐"}},
                    {    //天津
                            {"唐涵"},{"何磊"},{"刘舒"},{"王路"},{"无"},{"无"},{"无"},{"无"},{"无"},{"无"}},
                    {    //广东
                            {"海珠区","荔湾区","越秀区","白云区","萝岗区","天河区","黄埔区","花都区","从化市","增城市","番禺区","南沙区"},
                         //广州
                            {"宝安区","福田区","龙岗区","罗湖区","南山区","盐田区"},
                          //深圳
                            {"武江区","浈江区","曲江区","乐昌市","南雄市","始兴县","仁化县","翁源县","新丰县","乳源县"}}
            };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        activity=getActivity();
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_down,null);
        provinceSpinner = (Spinner) view.findViewById(R.id.spin_province);
        citySpinner = (Spinner) view.findViewById(R.id.spin_city);
        countySpinner = (Spinner) view.findViewById(R.id.spin_county);
        Button But_send=(Button)view.findViewById(R.id.button6);
        But_send.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(activity).setTitle("提示信息")//设置对话框标题

                        .setMessage("确定发送请求吗？")//设置显示的内容

                        .setPositiveButton("确定",new DialogInterface.OnClickListener() {//添加确定按钮
                            @Override
                            public void onClick(DialogInterface dialog, int which) {//确定按钮的响应事件

                                Toast.makeText(activity," 发送成功，等待上级医院处理。。", Toast.LENGTH_LONG).show();
                               }

                        }).setNegativeButton("返回",new DialogInterface.OnClickListener() {//添加返回按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//响应事件
                        Log.i("alertdialog"," 已发送请求");
                    }

                }).show();//在按键响应事件中显示此对话框
            }
        });
        setSpinner();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setSpinner()
    {
        //绑定适配器和值
        provinceAdapter = new ArrayAdapter<String>(activity,
                android.R.layout.simple_spinner_item, province);
        provinceSpinner.setAdapter(provinceAdapter);
        provinceSpinner.setSelection(3,true);  //设置默认选中项，此处为默认选中第4个值

        cityAdapter = new ArrayAdapter<String>(activity,
                android.R.layout.simple_spinner_item, city[3]);
        citySpinner.setAdapter(cityAdapter);
        citySpinner.setSelection(0,true);  //默认选中第0个

        countyAdapter = new ArrayAdapter<String>(activity,
                android.R.layout.simple_spinner_item, county[0][0]);
        countySpinner.setAdapter(countyAdapter);
        countySpinner.setSelection(0, true);


        //省级下拉框监听
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            // 表示选项被改变的时候触发此方法，主要实现办法：动态改变地级适配器的绑定值
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                //position为当前省级选中的值的序号

                //将地级适配器的值改变为city[position]中的值
                cityAdapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, city[position]);
                // 设置二级下拉列表的选项内容适配器
                citySpinner.setAdapter(cityAdapter);
                provincePosition = position;    //记录当前省级序号，留给下面修改县级适配器时用
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }

        });
//地级下拉监听
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long arg3)
            {
                countyAdapter = new ArrayAdapter<String>(activity,
                        android.R.layout.simple_spinner_item, county[provincePosition][position]);
                countySpinner.setAdapter(countyAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }
        });
    }

    }
