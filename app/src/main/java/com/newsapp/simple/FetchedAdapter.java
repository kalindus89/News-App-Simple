package com.newsapp.simple;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.newsapp.simple.api.ModelClass;

import java.util.List;

public class FetchedAdapter extends RecyclerView.Adapter<FetchedAdapter.ViewHolder> {

    Context context;
    List<ModelClass> modelClassList;

    public FetchedAdapter(Context context, List<ModelClass> modelClassList) {
        this.context = context;
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public FetchedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FetchedAdapter.ViewHolder holder, int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WebViewForNews.class);
                intent.putExtra("url", modelClassList.get(holder.getAdapterPosition()).getUrl()); //position or holder.getAdapterPosition()
                //intent.putExtra("url",modelClassList.get(position).getUrl()); //both correct
                context.startActivity(intent);
            }
        });

        holder.mTime.setText("Published At:-" + modelClassList.get(position).getPublishedAt());
        holder.mAuthor.setText("Published At:-" + modelClassList.get(position).getAuthor());
        holder.mHeading.setText("Published At:-" + modelClassList.get(position).getTitle());
        holder.mContent.setText("Published At:-" + modelClassList.get(position).getDescription());
        Glide.with(context).load(modelClassList.get(position).getUrlToImage()).placeholder(R.drawable.ic_launcher_background).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mHeading, mContent, mAuthor, mTime;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mHeading = itemView.findViewById(R.id.mainHeading);
            mContent = itemView.findViewById(R.id.content);
            mAuthor = itemView.findViewById(R.id.author);
            mTime = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
