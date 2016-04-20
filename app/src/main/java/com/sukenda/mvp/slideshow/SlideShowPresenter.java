package com.sukenda.mvp.slideshow;

import com.sukenda.mvp.BasePresenter;
import com.sukenda.mvp.entity.Dummy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kenda on 4/20/2016
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public class SlideShowPresenter implements BasePresenter<SlideShowView> {

    private SlideShowView slideShowView;

    @Override
    public void attachView(SlideShowView slideShowView) {
        this.slideShowView = slideShowView;
    }

    @Override
    public void detachView() {
        slideShowView = null;
    }

    /**
     * Pada presenter bisa diimplementasikan method2 untuk keperluan view
     */
    public void load(){
        List<Dummy> dummies = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            dummies.add(new Dummy());
        }

        slideShowView.setItems(dummies);
    }
}
