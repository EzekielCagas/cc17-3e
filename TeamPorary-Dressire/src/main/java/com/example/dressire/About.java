package com.example.dressire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class About extends AppCompatActivity {
    TextView oneD;
    LinearLayout one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        oneD=findViewById(R.id.oneD);
        one = findViewById(R.id.one);
    }
    public void expand(View view){
        int v = (oneD.getVisibility() == View.GONE)? View.VISIBLE: View.GONE;
        TransitionManager.beginDelayedTransition(one, new AutoTransition());
        oneD.setVisibility(v);
    }
}