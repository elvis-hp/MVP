package com.sukenda.mvp.gellery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sukenda.mvp.R;
import com.sukenda.mvp.entity.Dummy;

import java.util.List;

/**
 * Created by sukenda on 20/04/16.
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public class GalleryActivity extends AppCompatActivity implements GalleryView {

    private GalleryPresenter galleryPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        galleryPresenter  = new GalleryPresenter();
        galleryPresenter.attachView(this);

        setContentView(R.layout.gallery_activity);
    }

    @Override
    public void setItems(List<Dummy> items) {

    }


}
