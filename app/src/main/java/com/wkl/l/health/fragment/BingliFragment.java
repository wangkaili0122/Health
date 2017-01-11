package com.wkl.l.health.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.wkl.l.health.activities.BingliDetailsActivity;
import com.wkl.l.health.activities.R;
import com.wkl.l.health.activities.SmartActivity;
import com.wkl.l.health.adapter.BingliAdapter;
import com.wkl.l.health.base.BingliInfo;
import com.wkl.l.health.bean.Bingli;
import com.wkl.l.health.bean.BinglisData;
import com.wkl.l.health.util.HealthDataServerinterface;
import com.wkl.l.health.util.OkHttp3Utils;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.id;
import static android.nfc.tech.MifareUltralight.PAGE_SIZE;
import static com.wkl.l.health.activities.R.id.button4;

/**
 * Created by L on 2016/11/19.
 */

public class BingliFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
   private Retrofit retrofit;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private Activity activity;
    private BingliAdapter mQuickAdapter;
   private int  mCurrentCounter;
    private  List<Bingli> datas = new ArrayList<>();
private List<BingliInfo> bingliInfosList=new ArrayList<>();

    private LinkedTreeMap<String,String> map;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        activity=getActivity();
        OkHttpClient client = OkHttp3Utils.getOkHttpSingletonInstance();
        retrofit = new Retrofit.Builder().
                baseUrl("http://139.199.2.204:8080/MedicalProjectServer/").client(client).addConverterFactory(GsonConverterFactory.create()).build();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmentbingli,null);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_id);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        aboutRecyclerView();
        super.onActivityCreated(savedInstanceState);
    }
    private List<Bingli> initRetrofit(final List<Bingli> returnData) {
        HealthDataServerinterface myInterface = retrofit.create(HealthDataServerinterface.class);
        Call<BinglisData> call_result = myInterface.getInfoList();
        call_result.enqueue(new Callback<BinglisData>() {
            @Override
            public void onResponse(Call<BinglisData> call, Response<BinglisData> response) {
                List<BinglisData.Binglis> binglises = response.body().getContent();
                for (int i = 0; i < binglises.size(); i++) {
                    BinglisData.Binglis preBinglis = binglises.get(i);
                    Bingli bingli = new Bingli();
                    BingliInfo bingliInfo=new BingliInfo();
                    bingli.setBingliId(preBinglis.getId());
                    bingli.setBingliName(preBinglis.getName());
                    bingli.setIdCard(preBinglis.getIdcard());
                    bingli.setSex(preBinglis.getSex());
                    bingli.setAge(preBinglis.getAge());
                    bingli.setKeshi(preBinglis.getKeshi());
                    bingli.setBingqu(preBinglis.getBingqu());
                    bingli.setZhuyuanhao(preBinglis.getZhuyuanhao());
                  bingli.setMarriage(preBinglis.getMarriage());
                   bingliInfo.setBinglipreId(preBinglis.getId());
                   bingliInfo.setJuiaodu(preBinglis.getMarriagehistory());
                  bingliInfo.setXinlv(preBinglis.getOldhistory());
                    bingliInfo.setXueya(preBinglis.getNowhistory());
                    bingliInfosList.add(bingliInfo);
                    returnData.add(bingli);
                    mQuickAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<BinglisData> call, Throwable t) {
                Toast.makeText(activity, "请求网络失败", Toast.LENGTH_LONG).show();
            }
        });
        return returnData;
    }
    private void aboutRecyclerView(){
      initAdapter();
      mRecyclerView.setAdapter(mQuickAdapter);
}
    private void initAdapter() {
       //接口map
    datas=initRetrofit(datas);
    mQuickAdapter = new BingliAdapter(datas);
    mCurrentCounter = datas.size();
    mQuickAdapter.openLoadAnimation();
    mRecyclerView.setAdapter(mQuickAdapter);
    mQuickAdapter.openLoadMore(PAGE_SIZE, true);
    mQuickAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
  @Override
     public void onLoadMoreRequested() {
              mRecyclerView.post(new Runnable() {

                  //private View footview;

                   @Override
                   public void run() {
                       if (mCurrentCounter > 20) {
                          mQuickAdapter.notifyDataChangedAfterLoadMore(false);

                        } else {
                            mQuickAdapter.notifyDataChangedAfterLoadMore(datas, true);
                            mCurrentCounter = mQuickAdapter.getItemCount();
                        }
                    }
                });
            }
        });
        mQuickAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //TODO
                Intent DetailIntent=new Intent(activity, BingliDetailsActivity.class);
                TextView name=(TextView) view.findViewById(R.id.tv_name_id);

                Bundle bundle=new Bundle();
                bundle.putInt("id",bingliInfosList.get(position).getBinglipreId());
                bundle.putString("jiaodu",bingliInfosList.get(position).getJuiaodu());
                bundle.putString("xinlv",bingliInfosList.get(position).getXinlv());
                bundle.putString("xueya",bingliInfosList.get(position).getXueya());
                bundle.putString("name",name.getText().toString());
                DetailIntent.putExtras(bundle);
                activity.startActivity(DetailIntent);

            }
        });
    }
    @Override
    public void onRefresh() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
