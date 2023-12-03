package com.example.dressire.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dressire.Model.Women;
import com.example.dressire.R;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class WomenAdapter extends RecyclerView.Adapter {
    List<Women> womenList;
    Context context;

    DatabaseReference womenReference;

    public WomenAdapter(List<Women> womenList, Context context, DatabaseReference womenReference) {
        this.womenList = womenList;
        this.context = context;
        this.womenReference = womenReference;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.womens_card_view, parent, false);
        return new WomenViewHolder(adapterLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Women women = womenList.get(position);
        WomenViewHolder womenViewHolder = (WomenViewHolder) holder;
        Picasso.get().load(womenList.get(position).getImg())
                        .into(womenViewHolder.productImage);
        womenViewHolder.textViewName.setText(women.getName());
        womenViewHolder.textViewPrice.setText(women.getPrice());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class WomenViewHolder extends RecyclerView.ViewHolder{
        ImageView productImage;
        TextView textViewName;
        TextView textViewPrice;
        ImageButton buttonBookmark;

        public WomenViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.image);
            textViewName = itemView.findViewById(R.id.product_name);
            textViewPrice = itemView.findViewById(R.id.product_price);
        }
    }
}
