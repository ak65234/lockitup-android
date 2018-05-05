package com.example.cj.lockscreen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class frag_access_history extends Fragment {
    RecyclerView recyclerView;
    access_history_Adapter adapter;
    //when we query only select the user and id
    List<Access_History> accessList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.fragment_frag_access_history, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //This is the equivaelent to the oncreate methods
        accessList = new ArrayList<>();
        recyclerView = (RecyclerView) getView().findViewById(R.id.access_recycler_View);
        //Sets the recycler view to a fixed size
        recyclerView.setHasFixedSize(true);
        //sets it to a vertical layout, card with stack on top each other
        RecyclerView.LayoutManager layouter = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layouter);

        //Grab the items from the database here
        Access_History newAccess = new Access_History();
        newAccess.set_action("Unlock");
        newAccess.set_time("8:05 PM 5/4/18");
        newAccess.set_username("Bob");

        Access_History newAccess1 = new Access_History();
        newAccess1.set_action("Lock");
        newAccess1.set_time("2:54 AM 5/2/18");
        newAccess1.set_username("Jerry");

        Access_History newAccess2 = new Access_History();
        newAccess2.set_action("Unlock");
        newAccess2.set_time("2:05 AM 5/2/18");
        newAccess2.set_username("Sue");

        accessList.add(newAccess);
        accessList.add(newAccess1);
        accessList.add(newAccess2);
        adapter = new access_history_Adapter(getActivity(),accessList);
        recyclerView.setAdapter(adapter);
    }

}
