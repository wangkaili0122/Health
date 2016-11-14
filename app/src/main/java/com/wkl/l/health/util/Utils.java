package com.wkl.l.health.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;


import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 概述：工具类
 * Created by KevinMeng on 2016/5/30.
 */
public class Utils {

    /**
     * 检测网络是否可用
     *
     * @param context
     * @return true; false;
     */
    public static boolean isNetworkAvailabl(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (NetworkInfo anInfo : info) {
                    if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 验证输入信息是否符合
     *
     * @param pattern 验证规则
     * @param input   需要验证的字符串
     * @return 当条件满足时，将返回true，否则返回false
     */
    public static boolean isRegex(String pattern, String input) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(input);
        return matcher.matches();
    }

    /**
     * 格式化时间显示 <br/>
     * H:mm:ss 24小时制，hh:mm:ss 12小时 <br/><br/>
     *
     * @param timestamp 时间戳
     * @return 12:00:00
     */
    public static String getDisplayTimeByTimestamp(long timestamp) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
        return sdf.format(new Date(timestamp));
    }
    /**
     * dp转px
     */
    public static int dip2px(Context context,float dp) {
        float density =context.getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5);
    }

    /**
     * 格式化日期显示 <br/>
     *
     * @param timestamp 时间戳
     * @return 2016-01-01
     */
    public static String getDisplayDateByTimestamp(long timestamp) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(timestamp * 1000));
    }

    /**
     * 格式化日期显示 <br/>
     *
     * @param timestamp 时间戳
     * @return 2016-01-01
     */
    public static String getBiDisplayDateByTimestamp(long timestamp) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
        return sdf.format(new Date(timestamp));
    }

    /**
     * cxp添加
     * 格式化日期->yyyy-MM-dd
     *
     * @return 2016-01-01
     */
    public static String getDateByTimestamp(long currentTimeMillis) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(currentTimeMillis);
    }

    /**
     * cxp添加
     * 把时间向后推迟 ? 时间
     * 格式化日期->yyyy-MM-dd
     *
     * @return 2016-01-01
     */
    public static String getDateByTimestampRetardedTime(String delay) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String mdate = "";
            Date d = new Date();
            long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
            d.setTime(myTime * 1000);
            mdate = format.format(d);
            return mdate;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * @param input
     * @return 将半角字符转换为全角字符
     */
    public static String ToDBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);
            }
        }
        return new String(c);
    }

}