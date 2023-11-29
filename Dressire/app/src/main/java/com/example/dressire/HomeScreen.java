package com.example.dressire;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

public class HomeScreen extends AppCompatActivity {
    private Button browse;
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, men, women, kids, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        browse = (Button) findViewById(R.id.browse);
        drawerLayout = findViewById(R.id.drawer_layout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        men = findViewById(R.id.men);
        women = findViewById(R.id.women);
        kids = findViewById(R.id.kids);
        about = findViewById(R.id.about);



        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openHighlight();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });
        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(HomeScreen.this, MColl.class);
            }
        });
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(HomeScreen.this, WColl.class);
            }
        });
        kids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(HomeScreen.this, KColl.class);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(HomeScreen.this, AboutUs.class);
            }
        });

    }

        public void openHighlight() {
            Intent intent = new Intent(this, Highlight.class);
            startActivity(intent);
        }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void redirectActivity(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }
    @Override
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }

}