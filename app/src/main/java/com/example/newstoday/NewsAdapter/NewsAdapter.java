package com.example.newstoday.NewsAdapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.newstoday.Model.NewsModel;
import com.example.newstoday.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> implements Filterable{

    private List<NewsModel> list;
    private List<NewsModel> listFiltered;
    private Context context;
    private NewsAdapterInterface newsAdapterInterface;
    private Picasso picasso;

    public NewsAdapter(Context context, List<NewsModel> list, NewsAdapterInterface newsAdapterInterface, Picasso picasso, List<NewsModel> listFiltered){
        this.list = list;
        this.context = context;
        this.newsAdapterInterface = newsAdapterInterface;
        this.picasso = picasso;
        this.listFiltered = listFiltered;
    }

    public void updateList(List<NewsModel> list, List<NewsModel> listFiltered){
        this.list = list;
        this.listFiltered = listFiltered;
        notifyDataSetChanged();
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_row_news, viewGroup, false);
        return new NewsCardLists(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder view, final int pos) {
        final NewsModel filter = listFiltered.get(pos);
        if (!(filter.getTitle() == null)){
            ((NewsCardLists) view).newsTitle.setText(filter.getTitle());
        } else {
            ((NewsCardLists) view).newsTitle.setText("-");
        }
        if (!(filter.getUrlToImage() == null)) {
            Picasso.with(context)
                    .load(filter.getUrlToImage())
                    .fit()
                    .into(((NewsCardLists) view).imageNews);
        } else {
            Picasso.with(context)
                    .load(R.drawable.picture_error2)
                    .fit()
                    .into(((NewsCardLists) view).imageNews);
        }
        if (!(filter.getDescription() == null)){
            ((NewsCardLists) view).newsDescription.setText(filter.getDescription());
        }else {
            ((NewsCardLists) view).newsDescription.setText("-");
        }
        if (!(filter.getPublsihedAt() == null)){
//            ((NewsCardLists) view).newsTime.setText(list.get(pos).getPublsihedAt());
            DateFormat outputFormat     = new SimpleDateFormat("MMM dd yyyy");
            DateFormat outputFormatHour = new SimpleDateFormat("HH:mm");
            DateFormat inputFormat      = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try {
                Date date = inputFormat.parse(filter.getPublsihedAt());
                String outputText     = outputFormat.format(date);
                String outputTextHour = outputFormatHour.format(date);
                ((NewsCardLists) view).newsDate.setText(outputText);
                ((NewsCardLists) view).newsTime.setText(outputTextHour);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            ((NewsCardLists) view).newsDate.setText("-");
            ((NewsCardLists) view).newsTime.setText("-");

        }
        if (!(filter.getAuthor() == null)){
            ((NewsCardLists) view).author.setText(filter.getAuthor());
        } else {
            ((NewsCardLists) view).author.setText("Author : -");
        }
        ((NewsCardLists) view).newsContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(filter.getUrl() == null)){
                    newsAdapterInterface.toDetailNews(filter.getUrl());
                } else {
                    gagal();
                }
            }
        });
    }

    @Override
    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()){
                    listFiltered = list;
                } else {
                    List<NewsModel> filteredList = new ArrayList<>();
                    for (NewsModel row : list){
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(row);
                        }
                    }
                    listFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = listFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                listFiltered = (ArrayList<NewsModel>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return listFiltered.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    protected void gagal(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setMessage("There is no URL attached");
        builder.setCancelable(true);

        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder.show();

    }
}
