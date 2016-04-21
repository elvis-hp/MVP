package com.sukenda.mvp;

import android.app.Application;
import android.content.Context;

import com.sukenda.mvp.service.GithubService;

/**
 * Created by sukenda on 21/04/16.
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public class MVPApplication extends Application {

    private GithubService githubService;

    public static MVPApplication get(Context context) {
        return (MVPApplication) context.getApplicationContext();
    }

    public GithubService getGithubService() {
        if (githubService == null) {
            githubService = GithubService.Factory.create();
        }
        return githubService;
    }
}
