package com.mp.collegefaction.collegefaction.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mp.collegefaction.collegefaction.MessageActivity;
import com.mp.collegefaction.collegefaction.R;
import com.mp.collegefaction.collegefaction.adapters.MessageAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment {


    public MessagesFragment() {
        // Required empty public constructor
    }

    public static MessagesFragment newInstance(){
        return new MessagesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView messageList = (RecyclerView)view.findViewById(R.id.recycler_view);
        MessageAdapter messageAdapter = new MessageAdapter(getContext());
        messageList.setLayoutManager(new LinearLayoutManager(getContext()));
        messageList.setAdapter(messageAdapter);
        return view;
    }
}
