package com.sukenda.mvp.gellery;

import com.sukenda.mvp.BasePresenter;
import com.sukenda.mvp.entity.Dummy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sukenda on 18/04/16.
 * Project : MaterialLayout
 * Email : soekenda09@gmail.com
 */
public class GalleryPresenter implements BasePresenter<GalleryView> {

    private GalleryView galleryView;

    @Override
    public void attachView(GalleryView galleryView) {
        this.galleryView = galleryView;
    }

    @Override
    public void detachView() {
        this.galleryView = null;
    }

    private void load() {
        List<Dummy> dummies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dummies.add(new Dummy());
        }

        galleryView.setItems(dummies);
    }
}
