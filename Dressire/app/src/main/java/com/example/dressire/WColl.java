package com.example.dressire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.dressire.Model.Women;
import com.example.dressire.adapter.WomenAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WColl extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    DatabaseReference womenReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wcoll);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        womenReference = databaseReference.child("Night Gowns");

        recyclerView = findViewById(R.id.recycler_view);
        womenReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Women> womenList = new ArrayList<>();
                for(DataSnapshot womenSnapshot : snapshot.getChildren()) {
                    Women women = womenSnapshot.getValue(Women.class);
                    women.setKey(womenSnapshot.getKey());
                    womenList.add(women);
                }
                recyclerView.setAdapter(new WomenAdapter(WColl.this, womenList, womenReference));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}