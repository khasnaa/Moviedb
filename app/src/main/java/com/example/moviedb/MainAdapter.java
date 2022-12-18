package com.example.moviedb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Viewholder> {

    private List<MainModel.Result> results;
    private OnAdapterListener listener;

    public MainAdapter(List<MainModel.Result> results, OnAdapterListener listener){
        this.results = results;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MainAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder (
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.Viewholder holder, int position) {
        MainModel.Result result = results.get(position);
        holder.textView.setText(result.getTitle() );
        Picasso.get()
                .load(result.getImage() )
                .centerCrop()
                .fit().centerCrop()
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(result);
            }
        });

        }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    public void setData(List<MainModel.Result> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }

    interface OnAdapterListener{
        void onClick(MainModel.Result result);
    }
}
