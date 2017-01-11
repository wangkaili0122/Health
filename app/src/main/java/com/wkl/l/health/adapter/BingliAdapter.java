package com.wkl.l.health.adapter;

import android.widget.ImageView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import com.wkl.l.health.activities.R;
import com.wkl.l.health.bean.Bingli;

import java.util.List;

/**
 * Created by liushuxin on 2016/7/5.
 */
public class BingliAdapter extends BaseQuickAdapter<Bingli> {

    public BingliAdapter(List<Bingli> data) {
        super(R.layout.pull_list_id, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Bingli bingli) {

        baseViewHolder.setText(R.id.tv_no_id, bingli.getBingliId()+"");
        baseViewHolder.setText(R.id.tv_name_id, bingli.getBingliName());
        baseViewHolder.setText(R.id.tv_idcard_id, (String)bingli.getIdCard());
        baseViewHolder.setText(R.id.tv_age_id, bingli.getAge()+"");
        baseViewHolder.setText(R.id.tv_zhuyuanhao_id, bingli.getZhuyuanhao());
        baseViewHolder.setText(R.id.tv_marriage_id, bingli.getMarriage());
        baseViewHolder.setText(R.id.tv_bingqu_id, bingli.getBingqu());
        baseViewHolder.setText(R.id.tv_keshi_id, bingli.getKeshi());
        baseViewHolder.setText(R.id.tv_sex_id, bingli.getSex());
//        Glide.with(mContext).load(decoratePlan.getUserSmallImage()).crossFade().transform(new GlideCircleTransform(mContext)).into((ImageView) baseViewHolder.getView(R.id.decorate_author_id));
//        int coverPhoto = decoratePlan.getCoverPhoto();
//        String cover = coverPhoto + "";
//        if (cover.length() == 1) {
//            Glide.with(mContext).load("http://image.guju.com.cn/images/138/9/1389106_0_9-.jpg@1o").into((ImageView) baseViewHolder.getView(R.id.decorate_coveriv_id));
//        } else {
//            String preThree = cover.substring(0, 3);
//            Glide.with(mContext).load(DecorateDatasUtils.coverPhotoPreStr + preThree + "/9/" + coverPhoto + DecorateDatasUtils.coverPhotoLastStr).into((ImageView) baseViewHolder.getView(R.id.decorate_coveriv_id));
//        }

    }




}


//                .setText(R.id.tweetText, decoratePlan.getText())
//                .setText(R.id.tweetDate, decoratePlan.getCreatedAt())
//                .setVisible(R.id.tweetRT, decoratePlan.isRetweet())
//                .setOnClickListener(R.id.tweetAvatar, new OnItemChildClickListener())
//                .setOnClickListener(R.id.tweetName, new OnItemChildClickListener())
//                .linkify(R.id.tweetText);

//Glide.with(mContext).load(item.getUserAvatar()).crossFade().placeholder(R.mipmap.def_head).transform(new GlideCircleTransform(mContext)).into((ImageView) helper.getView(R.id.tweetAvatar));




