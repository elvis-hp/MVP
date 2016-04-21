package com.sukenda.mvp.gallery;

import com.sukenda.mvp.BasePresenter;
import com.sukenda.mvp.MVPApplication;
import com.sukenda.mvp.entity.Repository;
import com.sukenda.mvp.service.GithubService;

import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by sukenda on 18/04/16.
 * Project : MVP
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

    public void loadRepositories(String usernameEntered) {
        String username = usernameEntered.trim();
        if (username.isEmpty()) return;
        MVPApplication application = MVPApplication.get(galleryView.getContext());
        GithubService githubService = application.getGithubService();
        githubService.publicRepositories(username).enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Response<List<Repository>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    galleryView.setRepositories(response.body());
                }
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
    }
}
