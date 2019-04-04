package com.example.newstoday;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.newstoday.ApiData.NewsApiData;
import com.example.newstoday.ApiInterface.NewsApiInterface;
import com.example.newstoday.NewsAdapter.NewsAdapter;
import com.example.newstoday.NewsAdapter.NewsAdapterInterface;
import com.squareup.picasso.Picasso;
import com.example.newstoday.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends NewsApiData implements NewsAdapterInterface {

    private NewsAdapter adapter;
    private Picasso picasso;
    private String newsId;
    private String title;

    RecyclerView listNews;
    ProgressBar loading;
    SearchView searchView;
    SwipeRefreshLayout swipeRefresh;
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initiateApiData();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getStringExtra("NEWS_ID") != null){
            newsId = getIntent().getStringExtra("NEWS_ID");
        }
        if (getIntent().getStringExtra("TITLE") != null){
            title = getIntent().getStringExtra("TITLE");
        }

        swipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        loading = (ProgressBar)findViewById(R.id.loadingList);
        textView = (TextView)findViewById(R.id.labelArticle);

        textView.setText("Latest News From " + title);

        refresh();
        callNewsApi(loading, newsId);


    }

    public void showNews(){
        if (swipeRefresh.isRefreshing()){
            swipeRefresh.setRefreshing(false);
        }

        listNews = (RecyclerView)findViewById(R.id.listNews);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listNews.setLayoutManager(linearLayoutManager);
        listNews.setHasFixedSize(true);
        adapter = new NewsAdapter(this, newsModelLists, this, picasso, listNewsModelFiltered);
        listNews.setAdapter(adapter);
        adapter.updateList(newsModelLists, listNewsModelFiltered);
    }

    public void refresh(){
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(true);
                callNewsApi(null, newsId);
            }
        });
    }

    @Override
    public void toDetailNews(String urlNews) {
        Intent intent = new Intent(this, NewsPage.class);
        intent.putExtra("URL", urlNews);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView)menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    protected void test(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("LEBIH DARI 0");
        builder.setCancelable(true);

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
