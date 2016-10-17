package com.zhangzuhao.dllo.autohome.model.db;

import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.zhangzuhao.dllo.autohome.ui.app.AutoHomeApp;

import java.util.List;

/**
 * Created by dllo on 16/10/10.
 * 数据库单例类
 */
public class LiteOrmInstance {

    private static LiteOrmInstance instance;
    /**
     * 数据库名字
     */
    private static final String DB_NAME = "collect.db";
    /**
     * LiteOrm对象
     */
    private LiteOrm liteOrm ;

    private LiteOrmInstance(){
        liteOrm = LiteOrm.newSingleInstance(AutoHomeApp.getContext() , DB_NAME);
    }
    public static LiteOrmInstance getInstance(){
        if (instance == null){
            synchronized (LiteOrmInstance.class){
                if (instance == null){
                    instance = new LiteOrmInstance();
                }
            }
        }
        return instance;
    }
    /*****************************增删改查****************************/
    //插入一条
    public void insert(CollectBean cb){
        if (liteOrm != null){
            liteOrm.insert(cb);
        }
    }

    //插入集合
    public  void insert(List<CollectBean> cbs){
        liteOrm.insert(cbs);
    }

    /**
     * 查询所有
     * @return 查询结果数据集合
     */
    public List<CollectBean> queryAll(){
        return liteOrm.query(CollectBean.class);
    }

    //如果查询多张表 , 查询所有
    public <T> List<T> queryAllData(Class<T> clz){
        return liteOrm.query(clz);
    }

    /**
     * 根据条件查寻
     */
    //1.按title(如果换成用户名 , 查该用户存储的)查询
    public List<CollectBean> queryByTitle(String title){
        QueryBuilder<CollectBean> qb = new QueryBuilder<>(CollectBean.class);
        qb.where("title = ?" , new Object [] {title});
        return liteOrm.query(qb);
    }
    /**
     * 根据标题查询数据库
     * @param start
     * @param end 限制条数
     *              如果查新出100条 限制使用条数
     */
    public List<CollectBean>queryByTitle(String title, int start , int end){
        QueryBuilder<CollectBean> qb = new QueryBuilder<>(CollectBean.class);
        qb.where("title = ?" , new Object [] {title});
        //但是:end需要判断 , 不要超出数据库数据的个数
        qb.limit(start ,end);

        return liteOrm.query(qb);
    }

    /**
     * 按条件删除
     */
    public  void deleteByTitle(String title){
        WhereBuilder wb = new WhereBuilder(CollectBean.class );
        wb.where("title = ? " , new Object [] {title});
        liteOrm.delete(wb);
    }
    /**
     * 删除所有
     */
    public void deleteAll(){
        liteOrm.deleteAll(CollectBean.class);
    }

}
