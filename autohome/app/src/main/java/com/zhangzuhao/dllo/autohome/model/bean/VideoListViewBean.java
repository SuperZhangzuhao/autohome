package com.zhangzuhao.dllo.autohome.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 视频的接口实体类
 */
public class VideoListViewBean {

    private VideoListViewBeanChild1 result;

    public void setResult(VideoListViewBeanChild1 result) {
        this.result = result;
    }

    public VideoListViewBeanChild1 getResult() {
        return result;
    }

    public static class VideoListViewBeanChild1 {
        private boolean isloadmore;
        private int rowcount;
        private int pagecount;
        private int pageindex;
        private List<VideoListViewBeanChild2> list;

        public boolean isloadmore() {
            return isloadmore;
        }

        public void setIsloadmore(boolean isloadmore) {
            this.isloadmore = isloadmore;
        }

        public int getRowcount() {
            return rowcount;
        }

        public void setRowcount(int rowcount) {
            this.rowcount = rowcount;
        }

        public int getPagecount() {
            return pagecount;
        }

        public void setPagecount(int pagecount) {
            this.pagecount = pagecount;
        }

        public int getPageindex() {
            return pageindex;
        }

        public void setPageindex(int pageindex) {
            this.pageindex = pageindex;
        }

        public List<VideoListViewBeanChild2> getList() {
            return list;
        }

        public void setList(List<VideoListViewBeanChild2> list) {
            this.list = list;
        }

        public static class VideoListViewBeanChild2 {
            private int id;
            private String title;
            private String time;
            private String smallimg;
            private int playcount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getSmallimg() {
                return smallimg;
            }

            public void setSmallimg(String smallimg) {
                this.smallimg = smallimg;
            }

            public int getPlaycount() {
                return playcount;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
            }
        }
    }
}

