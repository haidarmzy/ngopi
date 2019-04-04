package com.example.newstoday.ApiInterface;

import com.example.newstoday.Model.Article;
import com.example.newstoday.Model.ArticleList;
import com.example.newstoday.Model.NewsCallbackModel;
import com.example.newstoday.Model.Source;
import com.example.newstoday.Model.SourceList;
import com.example.newstoday.NewsCallback.NewsCallback;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface NewsApiInterface {
    @GET("everything?sources=techcrunch&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getNews();

    @GET("everything?sources=abc-news&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getABCNews();

    @GET("everything?sources=bbc-news&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getBBCNews();

    @GET("top-headlines?sources=bbc-sport&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getBBCSport();

    @GET("everything?sources=business-insider&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getBussinessInsider();

    @GET("everything?sources=buzzfeed&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getBuzzfeed();

    @GET("top-headlines?sources=cnn&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getCNN();

    @GET("everything?sources=daily-mail&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getDailyMail();

    @GET("top-headlines?sources=espn&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getESPN();

    @GET("everything?sources=financial-times&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getFinancialTimes();

    @GET("top-headlines?sources=four-four-two&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getFFT();

    @GET("everything?sources=fox-news&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getFoxNews();

    @GET("top-headlines?sources=ign&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getIgn();

    @GET("everything?sources=national-geographic&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getNatGeo();

    @GET("everything?sources=the-new-york-times&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getNewYorkTimes();

    @GET("everything?sources=techcrunch&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getTechCrunch();

    @GET("everything?sources=techradar&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getTechRadar();

    @GET("top-headlines?sources=the-economist&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getEconomist();

    @GET("everything?sources=the-telegraph&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getTelegraph();

    @GET("everything?sources=the-verge&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getTheVerge();

    @GET("top-headlines?sources=the-wall-street-journal&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getWSJ();

    @GET("everything?sources=vice-news&apiKey=7f1e6b98047f4758b208fe6750e42002")
    Call<ArticleList> getVice();
}
