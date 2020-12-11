package com.example.one.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.one.Activity.PoemActivity;
import com.example.one.PoemBean;
import com.example.one.R;

import java.util.List;

public class PoemAdapter extends RecyclerView.Adapter<PoemAdapter.ViewHolder> {
    private Context myContext;
    private List<PoemBean> poemBeanList;
    static class ViewHolder extends RecyclerView.ViewHolder{
       CardView cardView;
        TextView title;
        TextView author;
        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            title=(TextView)view.findViewById(R.id.poem_title);
            author=(TextView)view.findViewById(R.id.author);
        }
    }
    public PoemAdapter(List<PoemBean> poemBeans){
        poemBeanList=poemBeans;
    }
    @Override
   public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType){
        if (myContext==null)
            myContext=parent.getContext();
        View view= LayoutInflater.from(myContext).inflate(R.layout.poem_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                PoemBean poem=poemBeanList.get(position);
                Intent intent=new Intent(myContext, PoemActivity.class);
                intent.putExtra(PoemActivity.TITLE, poem.getTitle());
                intent.putExtra(PoemActivity.AUTHOR,poem.getAuthor());
                intent.putExtra(PoemActivity.CONTENT,poem.getContent());
                intent.putExtra(PoemActivity.INTRO,poem.getIntro());
                myContext.startActivity(intent);
            }
        });
            return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,int position){
         PoemBean poem=poemBeanList.get(position);
         viewHolder.title.setText(poem.getTitle());
         viewHolder.author.setText(poem.getAuthor());
    }
@Override
    public int getItemCount(){
        return poemBeanList.size();
}

}
