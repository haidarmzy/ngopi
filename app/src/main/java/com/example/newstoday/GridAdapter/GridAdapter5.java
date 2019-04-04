package com.example.newstoday.GridAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newstoday.FragmentFive;
import com.example.newstoday.HomeActivity;
import com.example.newstoday.R;

public class GridAdapter5 extends BaseAdapter {

    private final Context context;
    FragmentFive fragment;

    public GridAdapter5(Context context, FragmentFive fragment){
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

        GridAdapter5.Holder holder = new GridAdapter5.Holder();
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
                ((FragmentFive) fragment).onClickGridView(newsId[position], title[position]);
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
            R.drawable.ign1,
            R.drawable.techcrunch,
            R.drawable.techradar,
            R.drawable.the_verge2,
    };

    private String[] title = {
            "IGN",
            "TechCrunch",
            "TechRadar",
            "The Verge",
    };

    private String[] newsId = {
            "IGN",
            "TECHCRUNCH",
            "TECHRADAR",
            "THEVERGE",
    };

    private String[] category = {
            "Gaming",
            "Technology",
            "Technology",
            "Technology",
    };
}
