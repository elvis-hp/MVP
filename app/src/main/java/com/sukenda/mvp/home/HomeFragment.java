package com.sukenda.mvp.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sukenda.mvp.R;
import com.sukenda.mvp.entity.Dummy;

import java.util.List;

/**
 * Created by sukenda on 20/04/16.
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public class HomeFragment extends Fragment implements HomeView {

    private RecyclerView recyclerView;
    private HomePresenter homePresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_hotel_fragment);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        assert recyclerView != null;
        homePresenter = new HomePresenterImpl(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        homePresenter.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        homePresenter.onDestroy();
    }

    @Override
    public void setItems(List<Dummy> items) {
        HomeAdapter homeAdapter = new HomeAdapter(getActivity().getApplicationContext(), items);
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                homePresenter.onItemClicked(position);
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
