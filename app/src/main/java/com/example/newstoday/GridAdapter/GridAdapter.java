package com.example.newstoday.GridAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newstoday.HomeActivity;
import com.example.newstoday.R;

public class GridAdapter extends BaseAdapter{

    private final Context context;
    HomeActivity fragment;

    public GridAdapter(Context context, HomeActivity fragment){
        this.context = context;
        this.fragment = fragment;
    }

    @Override
    public int getCount() {
        return imageList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View view;

        view = View.inflate(context, R.layout.grid_list_detail, null);
        holder.img_grid = (ImageView) view.findViewById(R.id.imageNewsGrid);
        holder.text_cat = (TextView) view.findViewById(R.id.newsCategory);
        holder.category2 = (TextView) view.findViewById(R.id.newsCategory2);

        holder.img_grid.setImageResource(imageList[position]);
        holder.text_cat.setText(title[position]);
        holder.category2.setText(category[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity) fragment).onClickGridView(newsId[position], title[position]);
            }
        });

        return view;
    }

    public class Holder
    {
        TextView text_cat;
        TextView category2;
        ImageView img_grid;
    }

    private Integer[] imageList = {
            R.drawable.abc_news,
            R.drawable.bbc_news1,
            R.drawable.bbc_sport,
            R.drawable.business_insider1,
            R.drawable.buzzfeed,
            R.drawable.cnn,
            R.drawable.dailymail,
            R.drawable.espn1,
            R.drawable.financial_times,
            R.drawable.fourfourtwo,
            R.drawable.fox_news,
            R.drawable.ign1,
            R.drawable.national_geo1,
            R.drawable.nyt,
            R.drawable.techcrunch,
            R.drawable.techradar,
            R.drawable.the_economist,
            R.drawable.the_telegraph1,
            R.drawable.the_verge2,
            R.drawable.wsj1,
            R.drawable.vice_news,
    };

    private String[] title = {
            "ABC News",
            "BBC News",
            "BBC Sport",
            "Bussiness Insider",
            "Buzzfeed",
            "CNN",
            "Daily Mail",
            "ESPN",
            "Financial Times",
            "FourFourTwo",
            "Fox News",
            "IGN",
            "National Geographic",
            "New York Times",
            "TechCrunch",
            "TechRadar",
            "The Economist",
            "The Telegraph",
            "The Verge",
            "The Wall Street Journal",
            "Vice News"
    };

    private String[] newsId = {
            "ABCNEWS",
            "BBCNEWS",
            "BBCSPORT",
            "BUSINESSINSIDER",
            "BUZZFEED",
            "CNN",
            "DAILYMAIL",
            "ESPN",
            "FINANCIALTIMES",
            "FFT",
            "FOXNEWS",
            "IGN",
            "NATGEO",
            "NYT",
            "TECHCRUNCH",
            "TECHRADAR",
            "THEECONOMIST",
            "TELEGRAPH",
            "THEVERGE",
            "WSJ",
            "VICENEWS",
    };

    private String[] category = {
            "General",
            "General",
            "Sports",
            "Business",
            "Entertainment ",
            "General",
            "Entertainment",
            "Sports",
            "Business",
            "Sports",
            "General",
            "Gaming",
            "Science",
            "General",
            "Technology",
            "Technology",
            "Business",
            "General",
            "Technology",
            "Business",
            "General",
    };
}
