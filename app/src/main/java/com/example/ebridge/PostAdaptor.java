package com.example.ebridge;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ebridge.Model.Post;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class PostAdaptor extends RecyclerView.Adapter<PostVH>{

    List<Post> posts;

    public PostAdaptor(List<Post> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
        return new PostVH(view).linkAdaptor(this);
    }

    @Override
    public void onBindViewHolder(@NonNull PostVH holder, int position) {
        holder.postTitle.setText(posts.get(position).getTitle());
        holder.PostDetail.setText(posts.get(position).getDetails());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}

class PostVH extends RecyclerView.ViewHolder{
    TextView postTitle,PostDetail;
    private PostAdaptor adaptor;

    public PostVH(@NonNull View itemView) {
        super(itemView);

        postTitle = itemView.findViewById(R.id.postTitle);
        PostDetail = itemView.findViewById(R.id.PostDetail);

        if(CommonAuth.loggedUser.getRole() == 1){
            itemView.findViewById(R.id.deleteBtn).setVisibility(View.INVISIBLE);
            itemView.findViewById(R.id.editBtn).setVisibility(View.INVISIBLE);
        }


        itemView.findViewById(R.id.deleteBtn).setOnClickListener(view ->{
            DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("E-Bridge").child("posts");
            db.child(adaptor.posts.get(getAdapterPosition()).getTitle()).setValue(null);

            adaptor.posts.remove(getAdapterPosition());
            adaptor.notifyItemChanged(getAdapterPosition());
        });
    }

    public PostVH linkAdaptor(PostAdaptor adaptor){
        this.adaptor = adaptor;
        return this;
    }
}
