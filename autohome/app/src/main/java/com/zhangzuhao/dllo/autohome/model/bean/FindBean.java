package com.zhangzuhao.dllo.autohome.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/28.
 * 发现页面的实体类
 */
public class FindBean {
    private ResultBean result;

    private int returncode;
    private String message;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {


        private GoodslistBean goodslist;
        private int issmartrecommendpvtype;


        private List<ModulelistBean> modulelist;

        public GoodslistBean getGoodslist() {
            return goodslist;
        }

        public void setGoodslist(GoodslistBean goodslist) {
            this.goodslist = goodslist;
        }

        public int getIssmartrecommendpvtype() {
            return issmartrecommendpvtype;
        }

        public void setIssmartrecommendpvtype(int issmartrecommendpvtype) {
            this.issmartrecommendpvtype = issmartrecommendpvtype;
        }

        public List<ModulelistBean> getModulelist() {
            return modulelist;
        }

        public void setModulelist(List<ModulelistBean> modulelist) {
            this.modulelist = modulelist;
        }

        public static class GoodslistBean {
            private boolean isloadmore;
            private String carmallurl;

            private List<ListBean> list;

            public boolean isIsloadmore() {
                return isloadmore;
            }

            public void setIsloadmore(boolean isloadmore) {
                this.isloadmore = isloadmore;
            }

            public String getCarmallurl() {
                return carmallurl;
            }

            public void setCarmallurl(String carmallurl) {
                this.carmallurl = carmallurl;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private int id;
                private int productid;
                private String title;
                private String shorttitle;
                private String logo;
                private String price;
                private String fctprice;
                private String adinfo;
                private String murl;
                private String carlable;
                private String state;
                private int brandid;
                private int seriesid;
                private int specid;
                private String seriesname;
                private int count;
                private int type;
                private boolean ishistory;
                private String pvid;
                private int isoperation;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getProductid() {
                    return productid;
                }

                public void setProductid(int productid) {
                    this.productid = productid;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getShorttitle() {
                    return shorttitle;
                }

                public void setShorttitle(String shorttitle) {
                    this.shorttitle = shorttitle;
                }

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getFctprice() {
                    return fctprice;
                }

                public void setFctprice(String fctprice) {
                    this.fctprice = fctprice;
                }

                public String getAdinfo() {
                    return adinfo;
                }

                public void setAdinfo(String adinfo) {
                    this.adinfo = adinfo;
                }

                public String getMurl() {
                    return murl;
                }

                public void setMurl(String murl) {
                    this.murl = murl;
                }

                public String getCarlable() {
                    return carlable;
                }

                public void setCarlable(String carlable) {
                    this.carlable = carlable;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public int getBrandid() {
                    return brandid;
                }

                public void setBrandid(int brandid) {
                    this.brandid = brandid;
                }

                public int getSeriesid() {
                    return seriesid;
                }

                public void setSeriesid(int seriesid) {
                    this.seriesid = seriesid;
                }

                public int getSpecid() {
                    return specid;
                }

                public void setSpecid(int specid) {
                    this.specid = specid;
                }

                public String getSeriesname() {
                    return seriesname;
                }

                public void setSeriesname(String seriesname) {
                    this.seriesname = seriesname;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public boolean isIshistory() {
                    return ishistory;
                }

                public void setIshistory(boolean ishistory) {
                    this.ishistory = ishistory;
                }

                public String getPvid() {
                    return pvid;
                }

                public void setPvid(String pvid) {
                    this.pvid = pvid;
                }

                public int getIsoperation() {
                    return isoperation;
                }

                public void setIsoperation(int isoperation) {
                    this.isoperation = isoperation;
                }
            }
        }

        public static class ModulelistBean {
            private String title;
            /**
             * bannerimg :
             * detailurl :
             * spreadid : 0
             */

            private SpreadBean spread;
            /**
             * id : 158778
             * productid : 60002196
             * title : 一汽丰田锐志
             * shorttitle : 平安汽融0息购车专场，成功办理汽车分期后10个工作日内获赠百元万里通积分
             * logo : http://car0.autoimg.cn/upload/2014/11/3/tp_20141103202646117-110.jpg
             * price : 1元
             * fctprice : 100元
             * adinfo : 平安汽融0息购车专场，成功办理汽车分期后10个工作日内获赠百元万里通积分
             * murl : http://mall.m.autohome.com.cn/item/app/item-60002196-0.html#pvareaid=2018163
             * functionid : 0
             * type : 1
             * pvid : kHYaxsSH981fLfBOS2RpOFy2kEtUbILc
             * isoperation : 0
             */

            private List<ListBean> list;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public SpreadBean getSpread() {
                return spread;
            }

            public void setSpread(SpreadBean spread) {
                this.spread = spread;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class SpreadBean {
                private String bannerimg;
                private String detailurl;
                private int spreadid;

                public String getBannerimg() {
                    return bannerimg;
                }

                public void setBannerimg(String bannerimg) {
                    this.bannerimg = bannerimg;
                }

                public String getDetailurl() {
                    return detailurl;
                }

                public void setDetailurl(String detailurl) {
                    this.detailurl = detailurl;
                }

                public int getSpreadid() {
                    return spreadid;
                }

                public void setSpreadid(int spreadid) {
                    this.spreadid = spreadid;
                }
            }

            public static class ListBean {
                private int id;
                private int productid;
                private String title;
                private String shorttitle;
                private String logo;
                private String price;
                private String fctprice;
                private String adinfo;
                private String murl;
                private int functionid;
                private int type;
                private String pvid;
                private int isoperation;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getProductid() {
                    return productid;
                }

                public void setProductid(int productid) {
                    this.productid = productid;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getShorttitle() {
                    return shorttitle;
                }

                public void setShorttitle(String shorttitle) {
                    this.shorttitle = shorttitle;
                }

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getFctprice() {
                    return fctprice;
                }

                public void setFctprice(String fctprice) {
                    this.fctprice = fctprice;
                }

                public String getAdinfo() {
                    return adinfo;
                }

                public void setAdinfo(String adinfo) {
                    this.adinfo = adinfo;
                }

                public String getMurl() {
                    return murl;
                }

                public void setMurl(String murl) {
                    this.murl = murl;
                }

                public int getFunctionid() {
                    return functionid;
                }

                public void setFunctionid(int functionid) {
                    this.functionid = functionid;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getPvid() {
                    return pvid;
                }

                public void setPvid(String pvid) {
                    this.pvid = pvid;
                }

                public int getIsoperation() {
                    return isoperation;
                }

                public void setIsoperation(int isoperation) {
                    this.isoperation = isoperation;
                }
            }
        }
    }
}
