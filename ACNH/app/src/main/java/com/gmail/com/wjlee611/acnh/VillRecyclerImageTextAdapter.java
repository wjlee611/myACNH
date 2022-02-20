package com.gmail.com.wjlee611.acnh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VillRecyclerImageTextAdapter extends RecyclerView.Adapter<VillRecyclerImageTextAdapter.ViewHolder> {

    private ArrayList<RecyclerVillItem> mData = null;

    VillRecyclerImageTextAdapter(ArrayList<RecyclerVillItem> list) {
        mData = list;
    }

    @Override
    public VillRecyclerImageTextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.sh_recycler, parent, false);
        VillRecyclerImageTextAdapter.ViewHolder vh = new VillRecyclerImageTextAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(VillRecyclerImageTextAdapter.ViewHolder holder, int position) {
        RecyclerVillItem item = mData.get(position);

        holder.icon.setImageDrawable(item.getIcon());
        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    private OnItemLongClickListener mLongListener = null;

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.mLongListener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        TextView desc;

        ViewHolder(View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.sh_icon);
            title = itemView.findViewById(R.id.sh_title);
            desc = itemView.findViewById(R.id.sh_desc);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        RecyclerVillItem item = mData.get(pos);

                        if (mListener != null) {
                            mListener.onItemClick(view, pos);
                        }
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        RecyclerVillItem item = mData.get(pos);

                        if (mLongListener != null) {
                            mLongListener.onItemLongClick(view, pos);
                        }
                    }

                    return false;
                }
            });
        }
    }
}
