package com.bychoi00.depositapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<RecyclerItem> Items;

    public MyAdapter(List<RecyclerItem> Items) {
        this.Items = Items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RecyclerItem item = Items.get(position);

        holder.textView1.setText(item.Deposit);
        holder.textView2.setText(item.Rate+"%");
        holder.textView3.setText(item.Dudate);
        holder.textView4.setText(MyUtils.getFormatDEC(item.Total)+"원");
    }


    @Override
    public int getItemCount() {
        return Items.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public TextView textView4;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView)itemView.findViewById(R.id.txtDepositName);
            textView2 = (TextView)itemView.findViewById(R.id.txtRateName);
            textView3 = (TextView)itemView.findViewById(R.id.txtDurationName);
            textView4 = (TextView)itemView.findViewById(R.id.txtTotal);
        }
    }

}
