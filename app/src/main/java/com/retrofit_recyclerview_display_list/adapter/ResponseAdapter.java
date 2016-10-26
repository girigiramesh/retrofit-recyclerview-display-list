package com.retrofit_recyclerview_display_list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.retrofit_recyclerview_display_list.R;
import com.retrofit_recyclerview_display_list.model.Contact;

import java.util.List;

/**
 * Created by Ramesh on 10/25/16.
 */

public class ResponseAdapter extends RecyclerView.Adapter<ResponseAdapter.ViewHolder> {

    private Context context;
    private List<Contact> lists;

    public ResponseAdapter(List<Contact> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    public void notifyData(List<Contact> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_id.setText(lists.get(position).getId());
        holder.tv_name.setText(lists.get(position).getName());
        holder.tv_email.setText(lists.get(position).getEmail());
        holder.tv_address.setText(lists.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id,tv_name,tv_email,tv_address;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_id = (TextView) itemView.findViewById(R.id.tv_id);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_email = (TextView) itemView.findViewById(R.id.tv_email);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);

        }
    }
}
