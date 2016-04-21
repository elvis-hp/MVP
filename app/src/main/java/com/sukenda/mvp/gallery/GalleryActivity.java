package com.sukenda.mvp.gallery;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sukenda.mvp.R;
import com.sukenda.mvp.adapter.GalleryAdapter;
import com.sukenda.mvp.entity.Repository;

import java.util.List;

/**
 * Created by sukenda on 20/04/16.
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public class GalleryActivity extends AppCompatActivity implements GalleryView {

    private GalleryPresenter galleryPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        galleryPresenter  = new GalleryPresenter();
        galleryPresenter.attachView(this);

        setContentView(R.layout.gallery_activity);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_gallery);
        galleryPresenter.loadRepositories("sukenda");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Call some material design APIs here
        } else {
            // Implement this feature without material design
        }
    }

    @Override
    public void setRepositories(List<Repository> repositories) {
        setupRecyclerView(recyclerView, repositories);

        GalleryAdapter adapter = (GalleryAdapter) recyclerView.getAdapter();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        galleryPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public Context getContext() {
        return this;
    }

    private void setupRecyclerView(RecyclerView recyclerView, List<Repository> repositories) {
        GalleryAdapter galleryAdapter = new GalleryAdapter(getContext(), repositories);
        galleryAdapter.setOnItemClickListener(new GalleryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "USER " + position, Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.setAdapter(galleryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
