package com.example.ebridge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebridge.Model.Feedback;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class FeedbackAdaptor extends RecyclerView.Adapter<FeedbackVH>{

    List<Feedback> feedbacks;

    public FeedbackAdaptor(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    @NonNull
    @Override
    public FeedbackVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_item,parent,false);
        return new FeedbackVH(view).linkAdaptor(this);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackVH holder, int position) {
        holder.feedbackTitle.setText(feedbacks.get(position).getFeedbackTitle());
        holder.feedbackMessage.setText(feedbacks.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return feedbacks.size();
    }
}

class FeedbackVH extends RecyclerView.ViewHolder{
    TextView feedbackTitle,feedbackMessage;
    private FeedbackAdaptor adaptor;

    public FeedbackVH(@NonNull View itemView) {
        super(itemView);

        feedbackTitle = itemView.findViewById(R.id.feedbackTitle);
        feedbackMessage = itemView.findViewById(R.id.feedbackMessage);

    }

    public FeedbackVH linkAdaptor(FeedbackAdaptor adaptor){
        this.adaptor = adaptor;
        return this;
    }
}
