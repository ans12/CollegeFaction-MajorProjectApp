package com.mp.collegefaction.collegefaction.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mp.collegefaction.collegefaction.R;
import com.mp.collegefaction.collegefaction.adapters.EventsAdapter;
import com.mp.collegefaction.collegefaction.adapters.HomeAdapter;

/**
 * Created by pranjul on 24/4/18.
 */

public class EventsFragment extends Fragment {

    RecyclerView recycler_post;
    public EventsFragment() {
        // Required empty public constructor
    }

    public static EventsFragment newInstance(){
        return new EventsFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        recycler_post = (RecyclerView) view.findViewById(R.id.recycler_view);
        TextView textView = (TextView) view.findViewById(R.id.tv_placeholder);
        textView.setText("No more events available");
        EventsAdapter adapter = new EventsAdapter(getContext());
        recycler_post.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler_post.setFocusable(true);
        recycler_post.setAdapter(adapter);
        return view;
    }
}

