package com.zhangzuhao.dllo.autohome.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/10/10.
 * 快报详情页的实体类
 */
public class NewsFlashDetailsExBean  {

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
        private int rowcount;
        private boolean isloadmore;

        private NewsdataBean newsdata;
        private ArticlemodelBean articlemodel;
        private boolean canedit;

        private List<MessagelistBean> messagelist;

        public int getRowcount() {
            return rowcount;
        }

        public void setRowcount(int rowcount) {
            this.rowcount = rowcount;
        }

        public boolean isIsloadmore() {
            return isloadmore;
        }

        public void setIsloadmore(boolean isloadmore) {
            this.isloadmore = isloadmore;
        }

        public NewsdataBean getNewsdata() {
            return newsdata;
        }

        public void setNewsdata(NewsdataBean newsdata) {
            this.newsdata = newsdata;
        }

        public ArticlemodelBean getArticlemodel() {
            return articlemodel;
        }

        public void setArticlemodel(ArticlemodelBean articlemodel) {
            this.articlemodel = articlemodel;
        }

        public boolean isCanedit() {
            return canedit;
        }

        public void setCanedit(boolean canedit) {
            this.canedit = canedit;
        }

        public List<MessagelistBean> getMessagelist() {
            return messagelist;
        }

        public void setMessagelist(List<MessagelistBean> messagelist) {
            this.messagelist = messagelist;
        }

        public static class NewsdataBean {
            private int newsid;
            private int newstypeid;
            private String newstypeanme;
            private String title;
            private String summary;
            private int newsstate;
            private int showstate;
            private int newsauthorid;
            private String newsauthor;

            public int getNewsid() {
                return newsid;
            }

            public void setNewsid(int newsid) {
                this.newsid = newsid;
            }

            public int getNewstypeid() {
                return newstypeid;
            }

            public void setNewstypeid(int newstypeid) {
                this.newstypeid = newstypeid;
            }

            public String getNewstypeanme() {
                return newstypeanme;
            }

            public void setNewstypeanme(String newstypeanme) {
                this.newstypeanme = newstypeanme;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public int getNewsstate() {
                return newsstate;
            }

            public void setNewsstate(int newsstate) {
                this.newsstate = newsstate;
            }

            public int getShowstate() {
                return showstate;
            }

            public void setShowstate(int showstate) {
                this.showstate = showstate;
            }

            public int getNewsauthorid() {
                return newsauthorid;
            }

            public void setNewsauthorid(int newsauthorid) {
                this.newsauthorid = newsauthorid;
            }

            public String getNewsauthor() {
                return newsauthor;
            }

            public void setNewsauthor(String newsauthor) {
                this.newsauthor = newsauthor;
            }
        }

        public static class ArticlemodelBean {
        }

        public static class MessagelistBean {
            private int messageid;
            private int authorid;
            private String authorname;
            private String headimg;
            private String publishtime;
            private String publishtiptime;
            private int messagestate;
            private String content;
            private int upcount;
            private int replycount;
            private String shareimg;
            private String pageid;
            private int memberid;

            private List<AttachmentsBean> attachments;


            private List<CommentlistBean> commentlist;

            public int getMessageid() {
                return messageid;
            }

            public void setMessageid(int messageid) {
                this.messageid = messageid;
            }

            public int getAuthorid() {
                return authorid;
            }

            public void setAuthorid(int authorid) {
                this.authorid = authorid;
            }

            public String getAuthorname() {
                return authorname;
            }

            public void setAuthorname(String authorname) {
                this.authorname = authorname;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }

            public String getPublishtime() {
                return publishtime;
            }

            public void setPublishtime(String publishtime) {
                this.publishtime = publishtime;
            }

            public String getPublishtiptime() {
                return publishtiptime;
            }

            public void setPublishtiptime(String publishtiptime) {
                this.publishtiptime = publishtiptime;
            }

            public int getMessagestate() {
                return messagestate;
            }

            public void setMessagestate(int messagestate) {
                this.messagestate = messagestate;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getUpcount() {
                return upcount;
            }

            public void setUpcount(int upcount) {
                this.upcount = upcount;
            }

            public int getReplycount() {
                return replycount;
            }

            public void setReplycount(int replycount) {
                this.replycount = replycount;
            }

            public String getShareimg() {
                return shareimg;
            }

            public void setShareimg(String shareimg) {
                this.shareimg = shareimg;
            }

            public String getPageid() {
                return pageid;
            }

            public void setPageid(String pageid) {
                this.pageid = pageid;
            }

            public int getMemberid() {
                return memberid;
            }

            public void setMemberid(int memberid) {
                this.memberid = memberid;
            }

            public List<AttachmentsBean> getAttachments() {
                return attachments;
            }

            public void setAttachments(List<AttachmentsBean> attachments) {
                this.attachments = attachments;
            }

            public List<CommentlistBean> getCommentlist() {
                return commentlist;
            }

            public void setCommentlist(List<CommentlistBean> commentlist) {
                this.commentlist = commentlist;
            }

            public static class AttachmentsBean {
                private int attachtype;
                private String picurl;
                private String videourl;
                private int width;
                private int height;
                private int ordernum;

                public int getAttachtype() {
                    return attachtype;
                }

                public void setAttachtype(int attachtype) {
                    this.attachtype = attachtype;
                }

                public String getPicurl() {
                    return picurl;
                }

                public void setPicurl(String picurl) {
                    this.picurl = picurl;
                }

                public String getVideourl() {
                    return videourl;
                }

                public void setVideourl(String videourl) {
                    this.videourl = videourl;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getOrdernum() {
                    return ordernum;
                }

                public void setOrdernum(int ordernum) {
                    this.ordernum = ordernum;
                }
            }

            public static class CommentlistBean {
                private int userid;
                private String username;
                private String headimg;
                private int issocialize;
                private int iscarower;
                private int isbusinessauth;
                private String carname;
                private String sourcename;
                private String sourcecontent;
                private String content;
                private String createtime;

                public int getUserid() {
                    return userid;
                }

                public void setUserid(int userid) {
                    this.userid = userid;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getHeadimg() {
                    return headimg;
                }

                public void setHeadimg(String headimg) {
                    this.headimg = headimg;
                }

                public int getIssocialize() {
                    return issocialize;
                }

                public void setIssocialize(int issocialize) {
                    this.issocialize = issocialize;
                }

                public int getIscarower() {
                    return iscarower;
                }

                public void setIscarower(int iscarower) {
                    this.iscarower = iscarower;
                }

                public int getIsbusinessauth() {
                    return isbusinessauth;
                }

                public void setIsbusinessauth(int isbusinessauth) {
                    this.isbusinessauth = isbusinessauth;
                }

                public String getCarname() {
                    return carname;
                }

                public void setCarname(String carname) {
                    this.carname = carname;
                }

                public String getSourcename() {
                    return sourcename;
                }

                public void setSourcename(String sourcename) {
                    this.sourcename = sourcename;
                }

                public String getSourcecontent() {
                    return sourcecontent;
                }

                public void setSourcecontent(String sourcecontent) {
                    this.sourcecontent = sourcecontent;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }
            }
        }
    }
}
