package com.example.ebridge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebridge.Model.Alert;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class AlertAdaptor extends RecyclerView.Adapter<AlertVH>{

    List<Alert> alerts;

    public AlertAdaptor(List<Alert> alerts) {
        this.alerts = alerts;
    }

    @NonNull
    @Override
    public AlertVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alerts_item,parent,false);
        return new AlertVH(view).linkAdaptor(this);
    }

    @Override
    public void onBindViewHolder(@NonNull AlertVH holder, int position) {
        holder.alertN.setText(alerts.get(position).getName());
        holder.alertD.setText(alerts.get(position).getDesciption());
    }

    @Override
    public int getItemCount() {
        return alerts.size();
    }
}

class AlertVH extends RecyclerView.ViewHolder{
    TextView alertN,alertD;
    private AlertAdaptor adaptor;

    public AlertVH(@NonNull View itemView) {
        super(itemView);

        alertN = itemView.findViewById(R.id.alertName);
        alertD = itemView.findViewById(R.id.alertDes);
        if(CommonAuth.loggedUser.getRole() == 1 || CommonAuth.loggedUser.getRole() == 2){
            itemView.findViewById(R.id.deleteBtn).setVisibility(View.INVISIBLE);
            itemView.findViewById(R.id.editBtn).setVisibility(View.INVISIBLE);
        }

        itemView.findViewById(R.id.deleteBtn).setOnClickListener(view ->{
            DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("E-Bridge").child("alerts");
            db.child(adaptor.alerts.get(getAdapterPosition()).getName()).setValue(null);

            adaptor.alerts.remove(getAdapterPosition());
            adaptor.notifyItemChanged(getAdapterPosition());
        });
    }

    public AlertVH linkAdaptor(AlertAdaptor adaptor){
        this.adaptor = adaptor;
        return this;
    }
}
