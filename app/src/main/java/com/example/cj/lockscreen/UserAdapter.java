package com.example.cj.lockscreen;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        final UserViewHolder holder = new UserViewHolder(view);
        return holder;
    }

    //Binds the data to it
    @Override
    public void onBindViewHolder(final UserViewHolder holder, final int position) {
        //Position is the specific item inside of it
        final Users user  = userList.get(position);
        holder.userName.setText(user.get_username());
        holder.permID.setText(Integer.toString(user.get_permID()));
        /*
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Do stuff
                PopupMenu popupMenu = new PopupMenu(context,view);
            }
        });*/
    }

    //Returns the size of the list
    @Override
    public int getItemCount() {
        return userList.size();
    }



    class UserViewHolder extends RecyclerView.ViewHolder{

        TextView userName;
        TextView permID;
        LinearLayout parentLayout;
        //Constructor
        public UserViewHolder(final View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.userName);
            permID = itemView.findViewById(R.id.text_PermissionLevel);
            parentLayout = itemView.findViewById(R.id.parent_Layout_list);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    PopupMenu popupMenu = new PopupMenu(view.getContext(),view);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                    //Here we need to update the table based on the choice
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            if(item.getTitle().equals("Owner")){
                                //Update Table
                            }else if(item.getTitle().equals("Sub-User")){
                                //Update table
                            }else if(item.getTitle().equals("Restricted")){
                                //update table
                            }
                            Toast.makeText(view.getContext(),"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                            return true;
                        }
                    });
                    popupMenu.show();
                    Toast.makeText(view.getContext(),"Hello", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
