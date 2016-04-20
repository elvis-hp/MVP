package com.sukenda.mvp.home;

/**
 * Created by sukenda on 18/04/16.
 * Project : MaterialLayout
 * Email : soekenda09@gmail.com
 */
public interface HomePresenter {

    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
