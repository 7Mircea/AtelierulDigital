package com.example.myfundamentalsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    List<Person> list;
    Context context;

    PersonRecyclerAdapter(List<Person> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.person_view, parent, false);
        //de ce false ultimul parametru? pentru ca lista se afiseaza dinamic, nu vrem ca un elemente
        // sa ramana lipit pe vecie daca cineva vrea sa dea mai jos
        return new PersonViewHolder(recyclerRow);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = list.get(position);
        holder.getTextView1().setText(person.getFirstName());
        holder.getTextView2().setText(person.getLastName());
        if (position % 2 == 0) {
            LinearLayout linearLayout = holder.getLinearLayout();
            linearLayout.setBackgroundColor(context.getResources().getColor(R.color.lightBlue));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
