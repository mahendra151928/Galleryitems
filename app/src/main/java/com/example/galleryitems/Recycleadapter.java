package com.example.galleryitems;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class Recycleadapter extends RecyclerView.Adapter<Recycleadapter.recycle> {
    Context context;
    ArrayList<Integer>reimgs;
    ArrayList<String>reprice;


    public Recycleadapter(Context context, ArrayList<Integer> reimgs, ArrayList<String> reprice) {
        this.context = context;
        this.reimgs = reimgs;
        this.reprice = reprice;
    }

    @NonNull
    @Override
    public recycle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.rootlayout,parent,false);
        return new recycle(v);
    }

    @Override
    public void onBindViewHolder(@NonNull recycle holder, int position) {

        holder.itmimg.setImageResource((reimgs.get(position)));
        holder.itmprice.setText(reprice.get(position));
    }

    @Override
    public int getItemCount() {
        return reprice.size();
    }

    public class recycle extends RecyclerView.ViewHolder {
        ImageView itmimg;
        TextView itmprice;
        public recycle(@NonNull View itemView) {
            super(itemView);
            itmimg=itemView.findViewById(R.id.rimg);
            itmprice=itemView.findViewById(R.id.rprice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent=new Intent(context,Costofphones.class);
                    intent.putExtra("maheimg",reimgs.get(getAdapterPosition()));
                    intent.putExtra("maherate",reprice.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
