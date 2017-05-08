package com.lml.yyzj.base;

import com.lml.yyzj.bean.AnswerBean;
import com.lml.yyzj.bean.BannerBean;
import com.lml.yyzj.bean.HomeRecommend;
import com.lml.yyzj.bean.LunchBean;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by liml on 2016/11/24.
 */
public interface Api {
    String Host = "http://114.215.200.140:8080/YYZJ/";

    @GET("api/festival/one")
    Observable<LunchBean> getLunchAD();

    @POST("api/banner/list")
    Observable<BannerBean> getBanner(@Query("userId") int userId);

    @POST("api/prompt/list")
    Observable<HomeRecommend> getRecommend(@Query("userId") int userId);

    @POST("api/question/list")
    Observable<AnswerBean> getAnswer(@Query("userId") int userId, @Query("pageNum") int pageNum, @Query("pageSize") int pageSize);

//    @GET("api/getRankingList")
//    Observable<RankBean> getRank();

    //GET /api/getBookInfo 图书详情  id  integer
//    @GET("api/getBookInfo")
//    Observable<BookInfo> getBookInfo(@Query("id") int id);

    //GET /api/getSearchLable 热门搜索标签
//    @GET("api/getSearchLable")
//    Observable<BookTag> getHotTag();

    // /api/getSearchList 关键字搜索 key string
//    @GET("api/getSearchList")
//    Observable<BookList> getKeySearch(@Query("key") String key);

    // /api/getTypeBooks 根据类别获取图书列表 type string pageIndex string
//    @GET("api/getTypeBooks")
//    Observable<BookList> getBookListByCategory(@Query("type") String type, @Query("pageIndex") String pageIndex);

    // /api/getTypeConfigList获取类别列表
//    @GET("api/getTypeConfigList")
//    Observable<BookCatrgory> getCategoryList();
}
