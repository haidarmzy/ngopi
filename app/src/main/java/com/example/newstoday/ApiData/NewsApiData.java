package com.example.newstoday.ApiData;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.example.newstoday.ApiInterface.NewsApiInterface;
import com.example.newstoday.CheckConnection.NetworkConnection;
import com.example.newstoday.Model.Article;
import com.example.newstoday.Model.ArticleList;
import com.example.newstoday.Model.NewsArticleModel;
import com.example.newstoday.Model.NewsCallbackModel;
import com.example.newstoday.Model.NewsModel;
import com.example.newstoday.Model.Source;
import com.example.newstoday.Model.SourceList;
import com.example.newstoday.NewsCallback.NewsCallback;
import com.example.newstoday.NewsPage;
import com.example.newstoday.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NewsApiData extends AppCompatActivity {

    private NetworkConnection networkConnection;
    private NewsApiInterface newsApiInterface;
    protected List<NewsModel> newsModelLists = new ArrayList<>();
    protected List<NewsModel.Source> newsSourceList = new ArrayList<>();
    protected List<NewsModel> listNewsModelFiltered = new ArrayList<>();

    protected void initiateApiData(){
        networkConnection = new NetworkConnection(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        newsApiInterface = retrofit.create(NewsApiInterface.class);
    }

    protected void callNewsApi(final ProgressBar loading, final String newsId) {
        if (!(loading == null)){
            loading.setVisibility(View.VISIBLE);
        }
        if (!networkConnection.isNetworkConnected()) {
            if (!(loading == null)) {
                loading.setVisibility(View.GONE);
            }
            noConnectionDialog();
        } else {
            if (newsId.equalsIgnoreCase("ABCNEWS")){
                Call<ArticleList> call = newsApiInterface.getABCNews();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("BBCNEWS")){
                Call<ArticleList> call = newsApiInterface.getBBCNews();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("BBCSPORT")) {
                Call<ArticleList> call = newsApiInterface.getBBCSport();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("BUSINESSINSIDER")) {
                Call<ArticleList> call = newsApiInterface.getBussinessInsider();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("BUZZFEED")) {
                Call<ArticleList> call = newsApiInterface.getBuzzfeed();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("CNN")) {
                Call<ArticleList> call = newsApiInterface.getCNN();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("DAILYMAIL")) {
                Call<ArticleList> call = newsApiInterface.getDailyMail();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("ESPN")) {
                Call<ArticleList> call = newsApiInterface.getESPN();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("FINANCIALTIMES")) {
                Call<ArticleList> call = newsApiInterface.getFinancialTimes();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("FFT")) {
                Call<ArticleList> call = newsApiInterface.getFFT();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("FOXNEWS")) {
                Call<ArticleList> call = newsApiInterface.getFoxNews();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("IGN")) {
                Call<ArticleList> call = newsApiInterface.getIgn();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("NATGEO")) {
                Call<ArticleList> call = newsApiInterface.getNatGeo();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("NYT")) {
                Call<ArticleList> call = newsApiInterface.getNewYorkTimes();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("TECHCRUNCH")) {
                Call<ArticleList> call = newsApiInterface.getTechCrunch();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("TECHRADAR")) {
                Call<ArticleList> call = newsApiInterface.getTechRadar();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("THEECONOMIST")) {
                Call<ArticleList> call = newsApiInterface.getEconomist();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("TELEGRAPH")) {
                Call<ArticleList> call = newsApiInterface.getTelegraph();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("THEVERGE")) {
                Call<ArticleList> call = newsApiInterface.getTheVerge();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("WSJ")) {
                Call<ArticleList> call = newsApiInterface.getWSJ();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
            else if (newsId.equalsIgnoreCase("VICENEWS")) {
                Call<ArticleList> call = newsApiInterface.getVice();
                call.enqueue(new Callback<ArticleList>() {
                    @Override
                    public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                        if (response.isSuccessful()){
                            saveNews(response.body().getArticles());
                            if (!(loading == null)) {
                                loading.setVisibility(View.GONE);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleList> call, Throwable t) {
                        t.printStackTrace();
                        unexpectedError(t.getMessage());
                    }
                });
            }
        }
    }

    protected void saveNews(ArrayList<Article> response){

        NewsModel newsModel;
        List<NewsModel> newsModelList = new ArrayList<>();
        List<NewsModel> newsModelListFiltered = new ArrayList<>();

        for (Article result : response){
            newsModel = new NewsModel();

            newsModel.setAuthor(result.getAuthor());
            newsModel.setTitle(result.getTitle());
            newsModel.setDescription(result.getDescription());
            newsModel.setUrl(result.getUrl());
            newsModel.setUrlToImage(result.getUrlToImage());
            newsModel.setPublsihedAt(result.getPublishedAt());

            for (Article result2 : response){

                NewsModel.Source newsModelSource = new NewsModel(). new Source();

                newsModelSource.setId(result2.getSources().getId());
                newsModelSource.setName(result2.getSources().getName());

                newsModel.setSource(newsModelSource);
            }

            newsModelList.add(newsModel);
            newsModelListFiltered.add(newsModel);
        }

        newsModelLists = newsModelList;
        listNewsModelFiltered = newsModelListFiltered;

        showNews();
    }

//    protected void saveNewsSource(ArrayList<Source> response){
//
//        final NewsModel.Source saveSource= new NewsModel(). new Source();
//
//        List<NewsModel.Source> newsSource = new ArrayList<>();
//
//        for (Source result : response){
//
//            saveSource.setId(result.getId());
//            saveSource.setName(result.getName());
//
//            newsSource.add(saveSource);
//        }
//
//        newsSourceList = newsSource;
//
//    }

    protected void showNews(){

    }

    protected void noConnectionDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Connection Problem");
        builder.setCancelable(true);

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    protected void noData(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("No Data");
        builder.setCancelable(true);

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    protected void gagal(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("GAGAL :(");
        builder.setCancelable(true);

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    protected void unexpectedError(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.setCancelable(true);

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
