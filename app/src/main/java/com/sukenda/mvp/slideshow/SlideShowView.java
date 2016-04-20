package com.sukenda.mvp.slideshow;

import com.sukenda.mvp.BaseView;
import com.sukenda.mvp.entity.Dummy;

import java.util.List;

/**
 * Created by Kenda on 4/20/2016
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public interface SlideShowView extends BaseView {

    void setItems(List<Dummy> items);
}
