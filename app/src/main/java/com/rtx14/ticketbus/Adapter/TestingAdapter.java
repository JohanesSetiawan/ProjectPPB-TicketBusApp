package com.rtx14.ticketbus.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rtx14.ticketbus.ItemList;
import com.rtx14.ticketbus.R;

import java.util.ArrayList;

public class TestingAdapter extends RecyclerView.Adapter<TestingAdapter.ExampleViewHolder> {
    private final ArrayList<ItemList> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNamaPenumpang2;
        public TextView textViewBerangkatKota2;
        public TextView textViewTibaKota2;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            textViewNamaPenumpang2 = itemView.findViewById(R.id.textViewNamaPenumpang2);
            textViewBerangkatKota2 = itemView.findViewById(R.id.textViewBerangkatKota2);
            textViewTibaKota2 = itemView.findViewById(R.id.textViewTibaKota2);
        }
    }

    public TestingAdapter(ArrayList<ItemList> exampleList) {
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public TestingAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull TestingAdapter.ExampleViewHolder holder, int position) {
        ItemList currentItem = mExampleList.get(position);

        holder.textViewNamaPenumpang2.setText(currentItem.getTextViewNamaPenumpang2());
        holder.textViewBerangkatKota2.setText(currentItem.getTextViewBerangkatKota2());
        holder.textViewTibaKota2.setText(currentItem.getTextViewTibaKota2());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}

