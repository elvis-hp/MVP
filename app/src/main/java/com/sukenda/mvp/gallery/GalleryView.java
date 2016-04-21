package com.sukenda.mvp.gallery;


import com.sukenda.mvp.BaseView;
import com.sukenda.mvp.entity.Repository;

import java.util.List;

/**
 * Created by sukenda on 18/04/16.
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public interface GalleryView extends BaseView {

    void setRepositories(List<Repository> items);
}
