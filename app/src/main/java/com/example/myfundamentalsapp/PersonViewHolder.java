package com.example.myfundamentalsapp;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonViewHolder extends RecyclerView.ViewHolder {
    final private TextView textView1;
    final private TextView textView2;
    final private LinearLayout linearLayout;
    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        this.textView1 = itemView.findViewById(R.id.textView1);
        this.textView2 = itemView.findViewById(R.id.textView2);
        this.linearLayout = itemView.findViewById(R.id.linear);
    }

    public TextView getTextView1() {
        return textView1;
    }

    public TextView getTextView2() {
        return textView2;
    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }
}
