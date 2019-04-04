package com.example.newstoday;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.newstoday.GridAdapter.GridAdapter;
import com.example.newstoday.GridAdapter.GridAdapter2;

public class FragmentTwo extends Fragment {
    public FragmentTwo(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_ativity, container, false);

        GridView gridView = (GridView)view.findViewById(R.id.customgrid);
        gridView.setAdapter(new GridAdapter2(this.getActivity(), this));
        return view;
    }

    public void onClickGridView(String id, String title){
        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        intent.putExtra("NEWS_ID", id);
        intent.putExtra("TITLE", title);
        startActivity(intent);
    }
}
