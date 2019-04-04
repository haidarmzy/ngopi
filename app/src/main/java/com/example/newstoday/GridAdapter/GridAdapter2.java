package com.example.newstoday.GridAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newstoday.FragmentTwo;
import com.example.newstoday.HomeActivity;
import com.example.newstoday.R;

public class GridAdapter2 extends BaseAdapter{

    private final Context context;
    FragmentTwo fragment;

    public GridAdapter2(Context context, FragmentTwo fragment){
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

        GridAdapter2.Holder holder = new GridAdapter2.Holder();
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
                ((FragmentTwo) fragment).onClickGridView(newsId[position], title[position]);
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
            R.drawable.cnn,
            R.drawable.fox_news,
            R.drawable.nyt,
            R.drawable.the_telegraph1,
            R.drawable.vice_news,
    };

    private String[] title = {
            "ABC News",
            "BBC News",
            "CNN",
            "Fox News",
            "New York Times",
            "The Telegraph",
            "Vice News"
    };

    private String[] newsId = {
            "ABCNEWS",
            "BBCNEWS",
            "CNN",
            "FOXNEWS",
            "NYT",
            "TELEGRAPH",
            "VICENEWS",
    };

    private String[] category = {
            "General",
            "General",
            "General",
            "General",
            "General",
            "General",
            "General",
    };
}
