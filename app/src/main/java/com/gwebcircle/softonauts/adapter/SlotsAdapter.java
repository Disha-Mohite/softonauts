package com.gwebcircle.softonauts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gwebcircle.softonauts.R;
import com.gwebcircle.softonauts.model.Slots;
import com.gwebcircle.softonauts.model.TimeSlots;

import java.util.ArrayList;
import java.util.List;

public class SlotsAdapter extends RecyclerView.Adapter<SlotsAdapter.SlotsViewHolder> {

    private Context context;
    private ArrayList<Slots> timeslotslist;
    private SlotsAdapterListener listener;

    public SlotsAdapter(Context context, ArrayList<Slots> timeslotslist, SlotsAdapterListener listener) {
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
      Slots timeslots = timeslotslist.get(position);
        String slottext = null;

        holder.texttime.setText(timeslots.getShowdate());

      ArrayList<TimeSlots> tmslts = new ArrayList<>();
        List<String> monlistt = new ArrayList<>();
      tmslts = timeslots.getSlots();

          holder.textslots.setText("No Slots Available");



          holder.linecard.setOnClickListener(view -> {
              listener.onClickslot(timeslotslist.get(position));
          });

    }

    @Override
    public int getItemCount() {
        return timeslotslist.size();
    }

    class SlotsViewHolder extends RecyclerView.ViewHolder{

        private TextView texttime;
        private TextView textslots;
        private LinearLayout linecard;

        public SlotsViewHolder(@NonNull View itemView) {
            super(itemView);
            texttime = itemView.findViewById(R.id.time);
            textslots = itemView.findViewById(R.id.slots);
            linecard = itemView.findViewById(R.id.slotcard);
        }
    }

    public interface  SlotsAdapterListener{
        void onClickslot(Slots slots);
    }
}
