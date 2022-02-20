package com.gmail.com.wjlee611.acnh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnalysisRecyclerAdapter extends RecyclerView.Adapter<AnalysisRecyclerAdapter.ViewHolder> {
    private ArrayList<AnalysisRecyclerItem> mData = null;

    AnalysisRecyclerAdapter(ArrayList<AnalysisRecyclerItem> list) {
        mData = list;
    }

    @Override
    public AnalysisRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.ta_recycler, parent, false);
        AnalysisRecyclerAdapter.ViewHolder vh = new AnalysisRecyclerAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(AnalysisRecyclerAdapter.ViewHolder holder, int position) {
        AnalysisRecyclerItem item = mData.get(position);

        holder.Form.setText(item.getForm());
        holder.Sun.setText(item.getSun());
        holder.MonAM.setText(item.getMonAM());
        holder.MonPM.setText(item.getMonPM());
        holder.TueAM.setText(item.getTueAM());
        holder.TuePM.setText(item.getTuePM());
        holder.WedAM.setText(item.getWedAM());
        holder.WedPM.setText(item.getWedPM());
        holder.ThuAM.setText(item.getThuAM());
        holder.ThuPM.setText(item.getThuPM());
        holder.FriAM.setText(item.getFriAM());
        holder.FriPM.setText(item.getFriPM());
        holder.SatAM.setText(item.getSatAM());
        holder.SatPM.setText(item.getSatPM());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Form;
        TextView Sun;
        TextView MonAM;
        TextView MonPM;
        TextView TueAM;
        TextView TuePM;
        TextView WedAM;
        TextView WedPM;
        TextView ThuAM;
        TextView ThuPM;
        TextView FriAM;
        TextView FriPM;
        TextView SatAM;
        TextView SatPM;

        ViewHolder(View itemView) {
            super(itemView);

            Form = itemView.findViewById(R.id.ta_rc_form);
            Sun = itemView.findViewById(R.id.ta_rc_Sun);
            MonAM = itemView.findViewById(R.id.ta_rc_MonAM);
            MonPM = itemView.findViewById(R.id.ta_rc_MonPM);
            TueAM = itemView.findViewById(R.id.ta_rc_TueAM);
            TuePM = itemView.findViewById(R.id.ta_rc_TuePM);
            WedAM = itemView.findViewById(R.id.ta_rc_WedAM);
            WedPM = itemView.findViewById(R.id.ta_rc_WedPM);
            ThuAM = itemView.findViewById(R.id.ta_rc_ThuAM);
            ThuPM = itemView.findViewById(R.id.ta_rc_ThuPM);
            FriAM = itemView.findViewById(R.id.ta_rc_FriAM);
            FriPM = itemView.findViewById(R.id.ta_rc_FriPM);
            SatAM = itemView.findViewById(R.id.ta_rc_SatAM);
            SatPM = itemView.findViewById(R.id.ta_rc_SatPM);

        }
    }
}
