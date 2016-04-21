package com.sukenda.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sukenda.mvp.R;
import com.sukenda.mvp.entity.Repository;

import java.util.List;

/**
 * Created by sukenda on 09/04/16.
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private Context context;
    private List<Repository> repositories;
    private OnItemClickListener onItemClickListener;

    public GalleryAdapter(Context context, List<Repository> repositories) {
        this.context = context;
        this.repositories = repositories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler_gallery, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repository repository = repositories.get(position);
        holder.repository = repository;
        holder.titleTextView.setText(repository.name);
        holder.descriptionTextView.setText(repository.description);
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView titleTextView;
        public TextView descriptionTextView;
        public Repository repository;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.text_repo_title);
            descriptionTextView = (TextView) itemView.findViewById(R.id.text_repo_description);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
}
