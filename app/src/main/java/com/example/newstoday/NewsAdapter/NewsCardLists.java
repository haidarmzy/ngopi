package com.example.newstoday.NewsAdapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.newstoday.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsCardLists extends NewsAdapter.ViewHolder {


    LinearLayout newsContainer;
    ImageView imageNews;
    TextView newsTitle;
    TextView newsDescription;
    TextView newsDate;
    TextView newsTime;
    TextView author;

    public NewsCardLists(View view) {
        super(view);
        ButterKnife.bind(this, view);
        newsContainer = (LinearLayout) view.findViewById(R.id.newsContainer);
        newsTitle = (TextView) view.findViewById(R.id.newsTitle);
        imageNews = (ImageView) view.findViewById(R.id.imageNews);
        newsDescription = (TextView) view.findViewById(R.id.newsDescription);
        newsDate = (TextView) view.findViewById(R.id.newsDate);
        newsTime = (TextView) view.findViewById(R.id.newsTime);
        author = (TextView) view.findViewById(R.id.author);
    }
}
