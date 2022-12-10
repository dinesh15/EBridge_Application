package com.example.ebridge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebridge.Model.Subject;

import java.util.List;

public class SubjectAdaptor extends RecyclerView.Adapter<SubjectVH>{

    List<Subject> subjects;

    public SubjectAdaptor(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public SubjectVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item,parent,false);
        return new SubjectVH(view).linkAdaptor(this);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectVH holder, int position) {
        holder.subjectName.setText(subjects.get(position).getName());
        holder.subjectCode.setText(subjects.get(position).getSubjectCode());
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }
}

class SubjectVH extends RecyclerView.ViewHolder{
    TextView subjectCode,subjectName;
    private SubjectAdaptor adaptor;

    public SubjectVH(@NonNull View itemView) {
        super(itemView);

        subjectCode = itemView.findViewById(R.id.subjectCode);
        subjectName = itemView.findViewById(R.id.subjectName);

        if(CommonAuth.loggedUser.getRole() == 1 || CommonAuth.loggedUser.getRole() == 2){
            itemView.findViewById(R.id.deleteBtn).setVisibility(View.INVISIBLE);
        }

        itemView.findViewById(R.id.deleteBtn).setOnClickListener(view ->{
            adaptor.subjects.remove(getAdapterPosition());
            adaptor.notifyItemChanged(getAdapterPosition());
        });
    }

    public SubjectVH linkAdaptor(SubjectAdaptor adaptor){
        this.adaptor = adaptor;
        return this;
    }
}
