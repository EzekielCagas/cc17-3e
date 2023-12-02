package com.example.dressire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class Highlight extends AppCompatActivity {

    ViewPager2 viewpager2;
    private ImageButton WBtn;
    private ImageButton MBtn;

    private ImageButton KBtn;

    //auto slide
    private Handler slideHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highlight);

        WBtn = (ImageButton) findViewById(R.id.WBtn);
        MBtn = (ImageButton) findViewById(R.id.MBtn);
        KBtn = (ImageButton) findViewById(R.id.KBtn);


        WBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                openWColl();
            }
        });
        MBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMColl();
            }
        });
        KBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKColl();
            }
        });

        viewpager2=findViewById(R.id.viewPager);

        List<SlideIten> sliderItem = new ArrayList<>();
        sliderItem.add(new SlideIten(R.drawable.h1));
        sliderItem.add(new SlideIten(R.drawable.h2));
        sliderItem.add(new SlideIten(R.drawable.h3));
        sliderItem.add(new SlideIten(R.drawable.h4));
        sliderItem.add(new SlideIten(R.drawable.h5));

        viewpager2.setAdapter(new SlideAdapter(sliderItem, viewpager2));

        viewpager2.setClipToPadding(false);
        viewpager2.setClipChildren(false);
        viewpager2.setOffscreenPageLimit(5);
        viewpager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositionTransform = new CompositePageTransformer();
        compositionTransform.addTransformer(new MarginPageTransformer(30));
        compositionTransform.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);

            }
        });

        viewpager2.setPageTransformer(compositionTransform);

        viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable, 2000);
            }
        });

    }

        //Buttons
        public void openWColl() {
            Intent intent = new Intent(this, WColl.class);
            startActivity(intent);
        }
        public void openMColl(){
            Intent intent = new Intent(this, MColl.class);
            startActivity(intent);
        }
        public void openKColl(){
            Intent intent = new Intent(this, KColl.class);
            startActivity(intent);
        }

        //Image slieshow
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewpager2.setCurrentItem(viewpager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        slideHandler.removeCallbacks(sliderRunnable);

    }

    @Override
    protected void onResume() {
        super.onResume();
        slideHandler.postDelayed(sliderRunnable, 3000);
    }
}