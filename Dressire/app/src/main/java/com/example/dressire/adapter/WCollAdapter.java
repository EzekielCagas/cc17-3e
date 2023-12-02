package com.example.dressire.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dressire.Model.Womens;
import com.example.dressire.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class WCollAdapter extends RecyclerView.Adapter<WCollAdapter.ViewHolder> {
    
    private List<Womens> womensList;
    
    @NonNull
    @Override
    public WCollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.womens_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WCollAdapter.ViewHolder holder, int position) {
        Womens womens = womensList.get(position);
        holder.productNameTextView.setText(womens.getName());
        holder.productPriceTextView.setText(String.format(Locale.getDefault(), "$%.2f", womens.getPrice()));
        holder.productRatingBar.setRating(womens.getRating());
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/dressire-2501f.appspot.com/o/WomenCollection%2Fblue.png?alt=media&token=8a22b01b-b6bc-4bc6-b7b7-276830ecbc6d")
                .into(holder.productImageView);
    }

    @Override
    public int getItemCount() {
        return womensList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
       public ImageView productImageView;
       public TextView productNameTextView;
       public TextView productPriceTextView;
       public RatingBar productRatingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.productImageView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            productPriceTextView = itemView.findViewById(R.id.productPriceTextView);
            productRatingBar = itemView.findViewById(R.id.productRatingBar);

        }

    }
}
