package com.gwebcircle.softonauts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.gwebcircle.softonauts.MainActivity;
import com.gwebcircle.softonauts.R;
import com.gwebcircle.softonauts.model.DropInNavigator;
import com.gwebcircle.softonauts.model.DropInNavigatorTwo;

import java.util.ArrayList;

public class DropInNavAdapter extends RecyclerView.Adapter<DropInNavAdapter.DropInNavViewHolder> {

    private Context context;
    private ArrayList<DropInNavigatorTwo> dropinnavlist;
    private DropInNavigatorListener listener;

    public DropInNavAdapter(Context context, ArrayList<DropInNavigatorTwo> dropnavlist, DropInNavigatorListener listener) {

        this.context = context;
        this.dropinnavlist = dropnavlist;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DropInNavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drop_in_center_item,parent,false);
        return new DropInNavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DropInNavViewHolder holder, int position) {

        DropInNavigatorTwo dropinnav = dropinnavlist.get(position);


        holder.textname.setText(dropinnav.navigatorname);
        holder.textadrs.setText(dropinnav.getLocationid().get(0).toString());
        holder.card.setOnClickListener(view -> {
            listener.onClickCard(dropinnav);
        });


    }

    @Override
    public int getItemCount() {
        return dropinnavlist.size();
    }

    class DropInNavViewHolder extends RecyclerView.ViewHolder {

        private CardView card;
        private TextView textname;
        private TextView textadrs;
        public DropInNavViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            textname = itemView.findViewById(R.id.pname);
            textadrs = itemView.findViewById(R.id.padrs);


        }
    }

    public interface DropInNavigatorListener {

        void onClickCard(DropInNavigatorTwo position);
    }
}
