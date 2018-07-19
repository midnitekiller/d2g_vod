package com.direct2guests.d2g_tv.Activities;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.direct2guests.d2g_tv.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LangSelectActivity extends Activity {

    RecyclerView horizontal_recycler_view;
    HorizontalAdapter horizontalAdapter;
    private List<Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        horizontal_recycler_view= (RecyclerView) findViewById(R.id.horizontal_recycler_view);

        data = fill_with_data();


        horizontalAdapter=new HorizontalAdapter(data, getApplication());

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(LangSelectActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);

    }

    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();

        data.add(new Data( R.drawable.english, "Image 1"));
        data.add(new Data( R.drawable.french, "Image 2"));
        data.add(new Data( R.drawable.korean, "Image 3"));
//        data.add(new Data( R.drawable.img1, "Image 1"));
//        data.add(new Data( R.drawable.img2, "Image 2"));
//        data.add(new Data( R.drawable.img3, "Image 3"));
//        data.add(new Data( R.drawable.img1, "Image 1"));
//        data.add(new Data( R.drawable.img2, "Image 2"));
//        data.add(new Data( R.drawable.img3, "Image 3"));


        return data;
    }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {


        List<Data> horizontalList = Collections.emptyList();
        Context context;


        public HorizontalAdapter(List<Data> horizontalList, Context context) {
            this.horizontalList = horizontalList;
            this.context = context;
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView txtview;
            public MyViewHolder(View view) {
                super(view);
                imageView=(ImageView) view.findViewById(R.id.imageview);
                txtview=(TextView) view.findViewById(R.id.txtview);
            }
        }



        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.langselect_vertical_menu, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            holder.imageView.setImageResource(horizontalList.get(position).imageId);
            holder.txtview.setText(horizontalList.get(position).txt);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    String list = horizontalList.get(position).txt.toString();
                    Toast.makeText(LangSelectActivity.this, list, Toast.LENGTH_SHORT).show();
                }

            });

        }


        @Override
        public int getItemCount()
        {
            return horizontalList.size();
        }
    }

    public class Data {
        public int imageId;
        public String txt;

        Data( int imageId, String text) {

            this.imageId = imageId;
            this.txt=text;
        }
    }
}