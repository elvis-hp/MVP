package com.sukenda.mvp.slideshow;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sukenda.mvp.R;
import com.sukenda.mvp.entity.Dummy;
import com.sukenda.mvp.adapter.HomeAdapter;

import java.util.List;

/**
 * Created by Kenda on 4/20/2016
 * Project : MVP
 * Email : soekenda09@gmail.com
 */
public class SlideShowFragment extends Fragment implements SlideShowView {

    private SlideShowPresenter slideShowPresenter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        slideShowPresenter = new SlideShowPresenter();
        slideShowPresenter.attachView(this);

        View view = inflater.inflate(R.layout.fragment_slide_show, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_slide);
        slideShowPresenter.load();

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setItems(List<Dummy> items) {
        setupRecyclerView(recyclerView, items);

        HomeAdapter adapter = (HomeAdapter) recyclerView.getAdapter();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        slideShowPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }

    private void setupRecyclerView(RecyclerView recyclerView, List<Dummy> users) {
        HomeAdapter adapter = new HomeAdapter(getContext(), users);
        adapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), "USER " + position, Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
