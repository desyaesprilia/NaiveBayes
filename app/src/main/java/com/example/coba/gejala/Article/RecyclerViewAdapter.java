package com.example.coba.gejala.Article;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coba.gejala.NyeriKepalaActivity;
import com.example.coba.gejala.R;

import java.util.List;

/**
 * Created by Owner on 09/04/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<NyeriKepala> mData;

    public RecyclerViewAdapter(Context mContext, List<NyeriKepala> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_nyeri_kepala,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_NyeriKepala_title.setText(mData.get(position).getTitle());
        holder.im_NyeriKepala_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //passing data to the Nyeri Kepala Activity
                Intent intent = new Intent(mContext, NyeriKepalaActivity.class);
                intent.putExtra("JudulNyeriKepala",mData.get(position).getTitle());
                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                //start the activity
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_NyeriKepala_title;
        ImageView im_NyeriKepala_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_NyeriKepala_title = (TextView) itemView.findViewById(R.id.nyeri_primer_title_id);
            im_NyeriKepala_thumbnail = (ImageView) itemView.findViewById(R.id.nyeri_primer_im_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
