package com.sukenda.mvp.home;


import com.sukenda.mvp.entity.Dummy;

import java.util.List;

/**
 * Created by sukenda on 18/04/16.
 * Project : MaterialLayout
 * Email : soekenda09@gmail.com
 */
public interface HomeView {

    void setItems(List<Dummy> items);

    void showMessage(String message);
}
