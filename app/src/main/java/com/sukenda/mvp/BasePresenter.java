package com.sukenda.mvp;

public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();
}
