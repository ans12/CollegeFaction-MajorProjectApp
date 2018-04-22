package com.mp.collegefaction.collegefaction.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mp.collegefaction.collegefaction.R;
import com.mp.collegefaction.collegefaction.adapters.FriendRequestAdapter;

import static android.view.View.GONE;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RequestsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RequestsFragment extends Fragment{

    public RequestsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RequestsFragment.
     */

    public static RequestsFragment newInstance() {
        return new RequestsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView friendRequestsList = (RecyclerView) view.findViewById(R.id.recycler_view);
        FriendRequestAdapter adapter = new FriendRequestAdapter(getContext());
        friendRequestsList.setLayoutManager(new LinearLayoutManager(getContext()));
        friendRequestsList.setAdapter(adapter);
        return view;
    }

}
