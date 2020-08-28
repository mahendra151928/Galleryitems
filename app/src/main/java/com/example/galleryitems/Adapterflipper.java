package com.example.galleryitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class Adapterflipper extends PagerAdapter {

    Context context;
    int[]pageimages;


    public Adapterflipper(Context context, int[] pageimages) {
        this.context = context;
        this.pageimages = pageimages;

    }
    @Override
    public int getCount() {
        return pageimages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v=LayoutInflater.from(context).inflate(R.layout.flipperlayout,container,false);
        ImageView pimg;
        pimg=v.findViewById(R.id.pgrimg);
        pimg.setImageResource(pageimages[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View m= (View) object;
        container.removeView(m);
    }

//    Context context;
//    ArrayList<Integer> flprimg;
//    ArrayList<String> flprprice;
//
//    public Adapterflipper(Context context, ArrayList<Integer> flprimg, ArrayList<String> flprprice) {
//        this.context = context;
//        this.flprimg = flprimg;
//        this.flprprice = flprprice;
//    }
//
//    @Override
//    public int getCount() {
//        return flprimg.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int i, View v, ViewGroup viewGroup) {
//
//        v=LayoutInflater.from(context).inflate(R.layout.flipperlayout,viewGroup,false);
//        ImageView adflimg=v.findViewById(R.id.adflprimg);
//        TextView adflprice=v.findViewById(R.id.adflprprice);
//
//        adflimg.setImageResource(flprimg.get(i));
//        adflprice.setText(flprprice.get(i));
//        return v;
//    }
}
