package com.example.mirunabudoias.myfirstapplication.user;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mirunabudoias.myfirstapplication.R;
import com.example.mirunabudoias.myfirstapplication.user.UserListFragment.OnListFragmentInteractionListener;

import java.util.List;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {

    private List<User> userList;
    private OnListFragmentInteractionListener mListener;

    public UserRecyclerViewAdapter(List<User> items, OnListFragmentInteractionListener listener) {
        userList = items;
        mListener = listener;
    }

    public void setData(List<User> userList){
        this.userList = userList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_user_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
       holder.onBind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvName;
        public final TextView tvAddress;
        public User currentUser;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvName = (TextView) view.findViewById(R.id.tv_item_user_name);
            tvAddress = (TextView) view.findViewById(R.id.tv_item_user_address);

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        mListener.onListFragmentInteraction(userList.get(getAdapterPosition()));
                    }
                }
            });
        }

        public void onBind(User user){
            currentUser = user;
            tvName.setText(currentUser.name);
            tvAddress.setText(currentUser.address);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvAddress.getText() + "'";
        }
    }
}
