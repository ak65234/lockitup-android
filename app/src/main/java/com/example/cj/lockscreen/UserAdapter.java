package com.example.cj.lockscreen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//Just the recycler view adapter for the user table
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    //Used to inflate view
    private Context mCtx;
    //This is to be a query list from the DB
    private List<Users> userList;

    public UserAdapter(Context mCtx, List<Users> userList) {
        this.mCtx = mCtx;
        this.userList = userList;
    }

    //Creates view holder  (The UI returns)
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        //Inflate the list
        View view = inflater.inflate(R.layout.permission_layout, null);
        UserViewHolder holder = new UserViewHolder(view);
        return holder;
    }

    //Binds the data to it
    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        //Position is the specific item inside of it
        Users user  = userList.get(position);
        holder.userName.setText(user.get_username());
        holder.permID.setText(Integer.toString(user.get_permID()));
    }

    //Returns the size of the list
    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{

        TextView userName;
        TextView permID;
        //Constructor
        public UserViewHolder(View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.userName);
            permID = itemView.findViewById(R.id.text_PermissionLevel);
        }
    }
}
