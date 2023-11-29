package com.example.dressire;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContentsAdapter extends RecyclerView.Adapter<ContentsAdapter.ContentVH> {

    List<Contents> contentsList;

    public ContentsAdapter(List<Contents> contentsList) {
        this.contentsList = contentsList;
    }


    @NonNull
    @Override
    public ContentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ContentVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentVH holder, int position) {

        Contents contents = contentsList.get(position);
        holder.aboutsNameTxt.setText(contents.getAboutName());
        holder.descTxt.setText(contents.getDesc());

        boolean isExpandable = contentsList.get(position).isExpandable();
        holder.linearLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return contentsList.size();
    }

    public class ContentVH extends RecyclerView.ViewHolder {

        TextView aboutsNameTxt, descTxt;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;
        public ContentVH(@NonNull View itemView) {
            super(itemView);

            aboutsNameTxt = itemView.findViewById(R.id.about_name);
            descTxt = itemView.findViewById(R.id.description);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Contents contents = contentsList.get(getAdapterPosition());
                    contents.setExpandable(!contents.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
