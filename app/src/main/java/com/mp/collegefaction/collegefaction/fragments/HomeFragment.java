package com.mp.collegefaction.collegefaction.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mp.collegefaction.collegefaction.PostDetailActivity;
import com.mp.collegefaction.collegefaction.R;
import com.mp.collegefaction.collegefaction.WritePostActivity;
import com.mp.collegefaction.collegefaction.adapters.HomeAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{


    RecyclerView recycler_post;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        recycler_post = (RecyclerView) view.findViewById(R.id.recycler_view);
        HomeAdapter adapter = new HomeAdapter(getContext());
        recycler_post.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler_post.setFocusable(true);
        recycler_post.setAdapter(adapter);
        return view;
    }


}
