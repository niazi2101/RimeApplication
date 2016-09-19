package com.example.rafi715.rimeapplication;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Rafi715 on 8/31/2016.
 */
public class ViviAdapter extends RecyclerView.Adapter <ViviAdapter.MyViewAdapter>{

    private LayoutInflater inflater;
    List<RecyclerViewContent> data= Collections.emptyList();

    public ViviAdapter(Context context, List<RecyclerViewContent> data){
        inflater=LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public MyViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recycler_row, null);
        Log.e("Vivi", "onCreateViewHolder Called");
        MyViewAdapter holder=new MyViewAdapter(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewAdapter holder, int position) {
        RecyclerViewContent current=data.get(position);
        Log.e("Vivi", "onBindViewHolder Called" + position);
        holder.title.setText(current.title);
        holder.item.setImageResource(current.itemId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewAdapter extends RecyclerView.ViewHolder{
        TextView title;
        ImageView item;
        public MyViewAdapter(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.textList);
            item=(ImageView)itemView.findViewById(R.id.imageList);
        }
    }
}
