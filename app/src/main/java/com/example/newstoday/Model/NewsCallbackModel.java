package com.example.newstoday.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsCallbackModel {

    public String status;
    public Integer totalResults;
    @SerializedName("articles")
    public ArrayList<NewsArticleModel> articles;
}
