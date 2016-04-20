package com.sukenda.mvp.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.sukenda.mvp.R;
import com.sukenda.mvp.entity.Dummy;

import java.util.List;

/**
 * Created by sukenda on 18/04/16.
 * Project : MaterialLayout
 * Email : soekenda09@gmail.com
 */
public class HomeActivity extends AppCompatActivity implements HomeView {

    private RecyclerView recyclerView;
    private HomePresenter homePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_hotel);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        assert recyclerView != null;
        homePresenter = new HomePresenterImpl(this);
    }

    @Override
    public void setItems(List<Dummy> items) {
        HomeAdapter homeAdapter = new HomeAdapter(getApplicationContext(), items);
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                homePresenter.onItemClicked(position);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        homePresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.onDestroy();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
