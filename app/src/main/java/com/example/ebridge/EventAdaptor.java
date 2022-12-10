package com.example.ebridge;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebridge.Model.Event;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class EventAdaptor extends RecyclerView.Adapter<EventVH>{

    List<Event> events;

    public EventAdaptor(List<Event> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_item,parent,false);
        return new EventVH(view).linkAdaptor(this);
    }

    @Override
    public void onBindViewHolder(@NonNull EventVH holder, int position) {
        holder.eventN.setText(events.get(position).getName());
        holder.eventD.setText(events.get(position).getDesciption());
        holder.eventV.setText(events.get(position).getVenu());
        holder.eventDt.setText(events.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}

class EventVH extends RecyclerView.ViewHolder{
    TextView eventN,eventD,eventV,eventDt;
    private EventAdaptor adaptor;

    public EventVH(@NonNull View itemView) {
        super(itemView);

        eventN = itemView.findViewById(R.id.eventName);
        eventD = itemView.findViewById(R.id.eventDesc);
        eventV = itemView.findViewById(R.id.eventVenue);
        eventDt = itemView.findViewById(R.id.eventDate);

        if(CommonAuth.loggedUser.getRole() == 1 || CommonAuth.loggedUser.getRole() == 2){
            itemView.findViewById(R.id.deleteBtn).setVisibility(View.INVISIBLE);
            itemView.findViewById(R.id.editBtn).setVisibility(View.INVISIBLE);
        }



        itemView.findViewById(R.id.deleteBtn).setOnClickListener(view ->{
            DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("E-Bridge").child("events");
            db.child(adaptor.events.get(getAdapterPosition()).getName()).setValue(null);

            adaptor.events.remove(getAdapterPosition());
            adaptor.notifyItemChanged(getAdapterPosition());
        });
    }

    public EventVH linkAdaptor(EventAdaptor adaptor){
        this.adaptor = adaptor;
        return this;
    }
}
