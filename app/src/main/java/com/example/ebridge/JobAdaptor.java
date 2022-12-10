package com.example.ebridge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebridge.Model.Job;

import java.util.List;

public class JobAdaptor extends RecyclerView.Adapter<JobVH>{

    List<Job> jobs;

    public JobAdaptor(List<Job> jobs) {
        this.jobs = jobs;
    }

    @NonNull
    @Override
    public JobVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.jobs_item,parent,false);
        return new JobVH(view).linkAdaptor(this);
    }

    @Override
    public void onBindViewHolder(@NonNull JobVH holder, int position) {
        holder.jobPos.setText(jobs.get(position).getPosition());
        holder.jobEx.setText(jobs.get(position).getExperienceRequired());
        holder.jobD.setText(jobs.get(position).getDepartment());
        holder.jobAv.setText(jobs.get(position).getPositionAvailable());
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }
}

class JobVH extends RecyclerView.ViewHolder{
    TextView jobPos,jobEx,jobD,jobAv;
    private JobAdaptor adaptor;

    public JobVH(@NonNull View itemView) {
        super(itemView);

        jobPos = itemView.findViewById(R.id.jobPos);
        jobEx = itemView.findViewById(R.id.jobExp);
        jobD = itemView.findViewById(R.id.jobDep);
        jobAv = itemView.findViewById(R.id.jobAva);
        if(CommonAuth.loggedUser.getRole() == 1 || CommonAuth.loggedUser.getRole() == 2){
            itemView.findViewById(R.id.deleteBtn).setVisibility(View.INVISIBLE);
            itemView.findViewById(R.id.editBtn).setVisibility(View.INVISIBLE);
        }

        itemView.findViewById(R.id.deleteBtn).setOnClickListener(view ->{
            adaptor.jobs.remove(getAdapterPosition());
            adaptor.notifyItemChanged(getAdapterPosition());
        });
    }

    public JobVH linkAdaptor(JobAdaptor adaptor){
        this.adaptor = adaptor;
        return this;
    }
}
