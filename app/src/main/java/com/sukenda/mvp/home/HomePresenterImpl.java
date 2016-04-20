package com.sukenda.mvp.home;

import com.sukenda.mvp.entity.Dummy;

import java.util.List;

/**
 * Created by sukenda on 18/04/16.
 * Project : MaterialLayout
 * Email : soekenda09@gmail.com
 */
public class HomePresenterImpl implements HomePresenter, HomeInteraction.OnFinishedListener {

    private HomeView homeView;
    private HomeInteraction homeInteraction;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        homeInteraction = new HomeInteractionImpl();
    }

    @Override
    public void onResume() {
        homeInteraction.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (homeView != null) {
            homeView.showMessage("OPTIONAL WHEN SOME INTERACTIONS");
        }
    }

    @Override
    public void onDestroy() {
        homeView = null;
    }

    @Override
    public void onFinished(List<Dummy> items) {
        if (homeView != null) {
            homeView.setItems(items);
        }
    }
}
