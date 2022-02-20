package com.gmail.com.wjlee611.acnh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalRecyclerTextAdapter extends RecyclerView.Adapter<CalRecyclerTextAdapter.ViewHolder> {

    private ArrayList<CalRecyclerItem> mData = null;

    CalRecyclerTextAdapter(ArrayList<CalRecyclerItem> list) {
        mData = list;
    }

    @Override
    public CalRecyclerTextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.calender_recycler, parent, false);
        CalRecyclerTextAdapter.ViewHolder vh = new CalRecyclerTextAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(CalRecyclerTextAdapter.ViewHolder holder, int position) {
        CalRecyclerItem item = mData.get(position);

        holder.day.setText(item.getDay());
        holder.event.setText(item.getEvent());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView day;
        TextView event;

        ViewHolder(View itemView) {
            super(itemView);

            day = itemView.findViewById(R.id.cal_recycler_day);
            event = itemView.findViewById(R.id.cal_recycler_event);
        }
    }
}
