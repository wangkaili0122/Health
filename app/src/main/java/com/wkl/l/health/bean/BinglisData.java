package com.wkl.l.health.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by L on 2016/12/8.
 */

public class BinglisData {


    /**
     * result : Success
     * content : [{"intotime":"2016.4","marriagehistory":"无","zhusu":"重庆市南岸区","oldhistory":"无","address":"重庆市","sex":"女","keshi":"骨科","bingqu":"P2","marriage":"已婚","idcard":null,"name":"李华","nowhistory":"无","id":1,"zhuyuanhao":"P2160103","age":28},{"intotime":"2016.5","marriagehistory":"里","zhusu":"重庆市","oldhistory":"里","address":"河南","sex":"女","keshi":"骨科","bingqu":"p3","marriage":"未婚","idcard":null,"name":"王丽","nowhistory":"里","id":2,"zhuyuanhao":"p3160104","age":23},{"intotime":"2016.9","marriagehistory":"有","zhusu":"河南省","oldhistory":"有","address":"信仰","sex":"男","keshi":"外壳","bingqu":"P4","marriage":"已婚","idcard":null,"name":"王毅","nowhistory":"有","id":3,"zhuyuanhao":"p6","age":25}]
     */

    private String result;
    /**
     * intotime : 2016.4
     * marriagehistory : 无
     * zhusu : 重庆市南岸区
     * oldhistory : 无
     * address : 重庆市
     * sex : 女
     * keshi : 骨科
     * bingqu : P2
     * marriage : 已婚
     * idcard : null
     * name : 李华
     * nowhistory : 无
     * id : 1
     * zhuyuanhao : P2160103
     * age : 28
     */

    private List<Binglis> content;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Binglis> getContent() {
        return content;
    }

    public void setContent(List<Binglis> content) {
        this.content = content;
    }

    public static class Binglis {
        private String intotime;
        private String marriagehistory;
        private String zhusu;
        private String oldhistory;
        private String address;
        private String sex;
        private String keshi;
        private String bingqu;
        private String marriage;
        private Object idcard;
        private String name;
        private String nowhistory;
        private int id;
        private String zhuyuanhao;
        private int age;

        public String getIntotime() {
            return intotime;
        }

        public void setIntotime(String intotime) {
            this.intotime = intotime;
        }

        public String getMarriagehistory() {
            return marriagehistory;
        }

        public void setMarriagehistory(String marriagehistory) {
            this.marriagehistory = marriagehistory;
        }

        public String getZhusu() {
            return zhusu;
        }

        public void setZhusu(String zhusu) {
            this.zhusu = zhusu;
        }

        public String getOldhistory() {
            return oldhistory;
        }

        public void setOldhistory(String oldhistory) {
            this.oldhistory = oldhistory;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getKeshi() {
            return keshi;
        }

        public void setKeshi(String keshi) {
            this.keshi = keshi;
        }

        public String getBingqu() {
            return bingqu;
        }

        public void setBingqu(String bingqu) {
            this.bingqu = bingqu;
        }

        public String getMarriage() {
            return marriage;
        }

        public void setMarriage(String marriage) {
            this.marriage = marriage;
        }

        public Object getIdcard() {
            return idcard;
        }

        public void setIdcard(Object idcard) {
            this.idcard = idcard;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNowhistory() {
            return nowhistory;
        }

        public void setNowhistory(String nowhistory) {
            this.nowhistory = nowhistory;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getZhuyuanhao() {
            return zhuyuanhao;
        }

        public void setZhuyuanhao(String zhuyuanhao) {
            this.zhuyuanhao = zhuyuanhao;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
