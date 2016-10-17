package com.zhangzuhao.dllo.autohome.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/27.
 * 找车中品牌页面的listView的实体类
 */
public class BrandExpandableBean {



    private int returncode;
    private String message;


    private ResultBean result;

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private long timestamp;
        /**
         * letter : A
         * list : [{"id":117,"name":"AC Schnitzer","imgurl":"http://x.autoimg.cn/app/image/brands/117.png"},{"id":35,"name":"阿斯顿·马丁","imgurl":"http://x.autoimg.cn/app/image/brands/35.png"},{"id":221,"name":"安凯客车","imgurl":"http://x.autoimg.cn/app/image/brands/221.png"},{"id":33,"name":"奥迪","imgurl":"http://x.autoimg.cn/app/image/brands/33.png"}]
         */

        private List<BrandlistBean> brandlist;

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public List<BrandlistBean> getBrandlist() {
            return brandlist;
        }

        public void setBrandlist(List<BrandlistBean> brandlist) {
            this.brandlist = brandlist;
        }

        public static class BrandlistBean {
            private String letter;
            /**
             * id : 117
             * name : AC Schnitzer
             * imgurl : http://x.autoimg.cn/app/image/brands/117.png
             */

            private List<ListBean> list;

            public String getLetter() {
                return letter;
            }

            public void setLetter(String letter) {
                this.letter = letter;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private int id;
                private String name;
                private String imgurl;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getImgurl() {
                    return imgurl;
                }

                public void setImgurl(String imgurl) {
                    this.imgurl = imgurl;
                }
            }
        }
    }
}
