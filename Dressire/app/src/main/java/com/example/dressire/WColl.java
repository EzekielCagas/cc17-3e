package com.example.dressire;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dressire.Model.Womens;
import com.example.dressire.adapter.WCollAdapter;
import com.example.dressire.adapter.WomensAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class WColl extends AppCompatActivity {

    RecyclerView recyclerView;
    WomensAdapter adapter;
    ArrayList<Womens> womensList = new ArrayList<>();
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.womens_card_view, container, false);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Night Gowns");

        ValueEventListener firebaseListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                womensList.clear();
                for(DataSnapshot child : snapshot.getChildren()){
                    Womens product = new Womens(
                            child.child("img").getValue().toString(),
                            child.child("name").getValue().toString(),
                            child.child("price").getValue().toString()
                    );

                    womensList.add(product);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        reference.addValueEventListener(firebaseListener);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false));

        adapter = new WomensAdapter(womensList);
        recyclerView.setAdapter(adapter);

        return view;
    }

}