package com.example.lbw.guaniu.commen_view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lbw.guaniu.Poem.Poem;
import com.example.lbw.guaniu.R;
import com.example.lbw.guaniu.detail.DetailsActivity;

import java.util.List;

/**
 * Created by lbw on 2017/8/4.
 */

public class CommentListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Poem> mDataset;
    private Context context;
    private int resourceId;



    // Provide a suitable constructor (depends on the kind of dataset)
    public CommentListAdapter(@NonNull Context context, int resource, @NonNull List<Poem> objects) {
        this.mDataset = objects;
        this.context = context;
        this.resourceId = resource;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(resourceId, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(context, v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ImageView poemImage;
        TextView title;
        TextView text;
        poemImage = (ImageView)holder.getView(R.id.image);
        title = (TextView)holder.getView(R.id.title);
        text = (TextView)holder.getView(R.id.text);
        Poem poem = mDataset.get(position);
        poemImage.setImageResource(poem.getImageId());
        title.setText(poem.getTitle());
        text.setText(poem.getText());

        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 点击事件
                Intent intent = new Intent(context, DetailsActivity.class);
                context.startActivity(intent);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
