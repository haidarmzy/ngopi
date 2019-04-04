package com.example.newstoday.GridAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newstoday.FragmentSix;
import com.example.newstoday.HomeActivity;
import com.example.newstoday.R;

public class GridAdapter6 extends BaseAdapter {

    private final Context context;
    FragmentSix fragment;

    public GridAdapter6(Context context, FragmentSix fragment){
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

        GridAdapter6.Holder holder = new GridAdapter6.Holder();
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
                ((FragmentSix) fragment).onClickGridView(newsId[position], title[position]);
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
            R.drawable.business_insider1,
            R.drawable.financial_times,
            R.drawable.the_economist,
            R.drawable.wsj1,
    };

    private String[] title = {
            "Bussiness Insider",
            "Financial Times",
            "The Economist",
            "The Wall Street Journal",
    };

    private String[] newsId = {
            "BUSINESSINSIDER",
            "FINANCIALTIMES",
            "THEECONOMIST",
            "WSJ",
    };

    private String[] category = {
            "Business",
            "Business",
            "Business",
            "Business",
    };
}
