package com.gmail.com.wjlee611.acnh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainVillRecyclerImageTextAdapter extends RecyclerView.Adapter<MainVillRecyclerImageTextAdapter.ViewHolder> {
    private ArrayList<MainRecyclerVillItem> mData = null;

    MainVillRecyclerImageTextAdapter(ArrayList<MainRecyclerVillItem> list) {
        mData = list;
    }

    @Override
    public MainVillRecyclerImageTextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.resident_01, parent, false);
        MainVillRecyclerImageTextAdapter.ViewHolder vh = new MainVillRecyclerImageTextAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(MainVillRecyclerImageTextAdapter.ViewHolder holder, int position) {
        MainRecyclerVillItem item = mData.get(position);

        holder.icon.setImageDrawable(item.getIcon());
        holder.name.setText(item.getName());
        holder.gender.setText(item.getGender());
        holder.birth.setText(item.getBirth());
        holder.person.setText(item.getPerson());
        holder.coffee.setText(item.getCoffee());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        TextView gender;
        TextView birth;
        TextView person;
        TextView coffee;

        ViewHolder(View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.r1_civ);
            name = itemView.findViewById(R.id.r1_tvName);
            gender = itemView.findViewById(R.id.r1_tvGender);
            birth = itemView.findViewById(R.id.r1_tvBirth);
            person = itemView.findViewById(R.id.r1_tvPersonality);
            coffee = itemView.findViewById(R.id.r1_tvCoffee);
        }
    }
}
