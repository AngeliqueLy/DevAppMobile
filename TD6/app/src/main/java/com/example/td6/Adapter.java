package com.example.td6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private final List<Repo> mRepo ;


    public Adapter( List<Repo> repo) {

        mRepo = repo;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.nomrepo, parent,false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Repo repo = mRepo.get(position);

        TextView NomrepoTextView = holder.Nomrepo;
        NomrepoTextView.setText(repo.getName());



    }

    @Override
    public int getItemCount() {
        return mRepo.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Nomrepo;


        public ViewHolder(View itemView) {
            super(itemView);

            Nomrepo = (TextView) itemView.findViewById((R.id.view));

        }

    }
}
