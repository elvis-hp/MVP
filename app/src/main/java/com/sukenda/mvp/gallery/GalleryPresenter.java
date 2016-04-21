package com.sukenda.mvp.gallery;

import com.sukenda.mvp.BasePresenter;
import com.sukenda.mvp.MVPApplication;
import com.sukenda.mvp.entity.Repository;
import com.sukenda.mvp.service.GithubService;

import java.util.List;

import rx.Subscriber;

/**
 * Created by sukenda on 18/04/16.
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public class GalleryPresenter implements BasePresenter<GalleryView> {

    private GalleryView galleryView;
    private List<Repository> repositories;

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
        githubService.publicRepositories(username).subscribe(new Subscriber<List<Repository>>() {
            @Override
            public void onCompleted() {
                if (!repositories.isEmpty()) {
                    galleryView.setIRepositories(repositories);
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Repository> repositories) {
                GalleryPresenter.this.repositories = repositories;
            }
        });
    }
}
