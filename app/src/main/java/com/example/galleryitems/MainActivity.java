package com.example.galleryitems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Adapter;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //    AdapterViewFlipper adapterViewFlipper;
    ArrayList<Integer> arrayimg = new ArrayList<>(Arrays.asList(R.drawable.vivo1, R.drawable.vivo2, R.drawable.vivo3, R.drawable.vivo4, R.drawable.vivo5));
    //    ArrayList<String>arraprice=new ArrayList<>(Arrays.asList("Vivo","Oppo","Micromax","Redmi","Realme"));
    ArrayList<String> arraprice = new ArrayList<>(Arrays.asList("15000", "12000", "80000", "20000", "18000"));

//    ArrayList<Integer>arimg=new ArrayList<>(Arrays.asList(R.drawable.vivo1,R.drawable.vivo2,R.drawable.vivo3,R.drawable.vivo4,R.drawable.vivo5));
//    //    ArrayList<String>arraprice=new ArrayList<>(Arrays.asList("Vivo","Oppo","Micromax","Redmi","Realme"));
//    ArrayList<String>arprice=new ArrayList<>(Arrays.asList("15000","12000","80000","20000","18000"));

//        int[] flipperimg={R.drawable.vivo1,R.drawable.vivo2,R.drawable.vivo3,R.drawable.vivo4,R.drawable.vivo5};
//    String[] flipperprice={"15000","12000","80000","20000","18000"};
    ViewPager viewPager;
    LinearLayout linearLayout;
    int[]images={R.drawable.vivo1, R.drawable.vivo2, R.drawable.vivo3, R.drawable.vivo4, R.drawable.vivo5};
    Adapterflipper pageradapter;
    int dotscount,currentpage=0;
    ImageView[] dots;
    Timer timer;
    private final long DELAY=500;
    private final long PERIOD=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rview);

        viewPager=findViewById(R.id.pager);
        linearLayout=findViewById(R.id.dots);

        pageradapter=new Adapterflipper(this,images);
        viewPager.setAdapter(pageradapter);

        dotscount=pageradapter.getCount();
        dots=new ImageView[dotscount];
//        adapterflipper=findViewById(R.id.readflpr);

        Recycleadapter recycleadapter = new Recycleadapter(MainActivity.this, arrayimg, arraprice);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recycleadapter);

        for (int i=0;i<dotscount;i++){
            dots[i]=new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactivedots));
            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(8,0,8,0);
            linearLayout.addView(dots[i],layoutParams);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.activedots));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i=0;i<dotscount;i++){

                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactivedots));

                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.activedots));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        final Handler handler=new Handler();
        final Runnable runnable=new Runnable() {
            @Override
            public void run() {

                if (currentpage==images.length){
                    currentpage=0;
                }
                viewPager.setCurrentItem(currentpage ++,true);
            }
        };

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },DELAY,PERIOD);

    }

//        Adapterflipper adapterflipper=new Adapterflipper(MainActivity.this,arrayimg,arraprice);
//        adapterViewFlipper.setAdapter(adapterflipper);
//        adapterViewFlipper.setAutoStart(true);
//        adapterViewFlipper.setFlipInterval(2000);

    }


