package com.example.cj.lockscreen;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PermissionTable extends android.support.v4.app.Fragment {

    RecyclerView recyclerView;
    UserAdapter adapter;
    //when we query only select the user and id
    List<Users> usersList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.fragment_permission_table, container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //This is the equivaelent to the oncreate methods
        usersList = new ArrayList<>();
        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_View);
        //Sets the recycler view to a fixed size
        recyclerView.setHasFixedSize(true);
        //sets it to a vertical layout, card with stack on top each other
        RecyclerView.LayoutManager layouter = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layouter);

        //Grab the items from the database here
        Users newUser = new Users();
        newUser.set_permID(0);
        newUser.set_username("Jarrod");
        Users newUser2 = new Users();
        newUser2.set_permID(1);
        newUser2.set_username("Jeb");
        Users newUser3 = new Users();
        newUser3.set_permID(2);
        newUser3.set_username("bob");
        //Instantiate and set recycler
        usersList.add(newUser);
        usersList.add(newUser2);
        usersList.add(newUser3);
        adapter = new UserAdapter(getActivity(),usersList);
        recyclerView.setAdapter(adapter);


    }

}
