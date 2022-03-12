package com.gwebcircle.softonauts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gwebcircle.softonauts.NavigatorDetailsActivity;
import com.gwebcircle.softonauts.R;
import com.gwebcircle.softonauts.model.TimeSlots;

import java.util.ArrayList;

public class SlotsAdapter extends RecyclerView.Adapter<SlotsAdapter.SlotsViewHolder> {

    private Context context;
    private ArrayList<TimeSlots> timeslotslist;
    private SlotsAdapterListener listener;

    public SlotsAdapter(Context context, ArrayList<TimeSlots> timeslotslist, SlotsAdapterListener listener) {
        this.context = context;
        this.timeslotslist = timeslotslist;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SlotsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.card_slots, parent, false);
       return new SlotsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlotsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return timeslotslist.size();
    }

    class SlotsViewHolder extends RecyclerView.ViewHolder{

        public SlotsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public interface  SlotsAdapterListener{
        void onClickslot();
    }
}
