package com.example.dressire.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dressire.Model.Womens;
import com.example.dressire.ProductView;
import com.example.dressire.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WomensAdapter extends RecyclerView.Adapter<WomensAdapter.ProductViewHolder>{

    private List<Womens> womensList;

    public WomensAdapter(List<Womens> productList) {
        this.womensList = womensList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.womens_card_view, parent, false);
        return new ProductViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Picasso.get().load(womensList.get(position).getImgUrl()).into(holder.productImage);
        holder.productTitle.setText(womensList.get(position).getName());
        holder.productPrice.setText(womensList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return womensList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productTitle;
        TextView productPrice;

        public ProductViewHolder(View view) {
            super(view);
            productImage = view.findViewById(R.id.image);
            productTitle = view.findViewById(R.id.product_name);
            productPrice = view.findViewById(R.id.product_price);
        }
    }
}
