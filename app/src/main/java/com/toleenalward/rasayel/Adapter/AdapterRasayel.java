package com.toleenalward.rasayel.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;


import com.toleenalward.rasayel.FunnyMessagesRasayel;
import com.toleenalward.rasayel.R;
import com.toleenalward.rasayel.friends_messages_rasayel;
import com.toleenalward.rasayel.love_messages_rasayel;
import com.toleenalward.rasayel.object.rasayel;

import java.util.ArrayList;

public class AdapterRasayel extends RecyclerView.Adapter<AdapterRasayel.RestViewHolder> {

    ArrayList<rasayel> rasayels;
    LayoutInflater mlayoutInflater;
    Context context;

    public AdapterRasayel(ArrayList<rasayel> rasayels, Context context) {
        this.rasayels = rasayels;
        mlayoutInflater = LayoutInflater.from(context);
        this.context = context;

    }


    @NonNull
    @Override
    public AdapterRasayel.RestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mlayoutInflater.inflate(R.layout.rasayel_row, parent, false);
        return new RestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterRasayel.RestViewHolder holder, int position) {
        holder.image.setImageResource(rasayels.get(position).getImage());
        holder.namerasayel.setText(rasayels.get(position).getNamerasayel());
        holder.cardviewrow.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                final Intent intent;
                switch (holder.getAdapterPosition()) {
                    case 0:
                        intent = new Intent(context, love_messages_rasayel.class);
                        break;

                    case 1:

                        intent = new Intent(context, friends_messages_rasayel.class);
                        break;

                    case 2:
                        intent = new Intent(context, FunnyMessagesRasayel.class);
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + holder.getAdapterPosition());
                }
                context.startActivity(intent);

            }

            ;

        });
    }

    @Override
    public int getItemCount() {
        return rasayels.size();
    }

    class RestViewHolder extends RecyclerView.ViewHolder {
        TextView namerasayel;
        ImageView image;
        LinearLayout cardviewrow;

        RestViewHolder(@NonNull View itemView) {
            super(itemView);
            namerasayel = itemView.findViewById(R.id.name_rasayel);
            image = itemView.findViewById(R.id.image_rasayel);
            cardviewrow = itemView.findViewById(R.id.cardview_rasayel_row);
            context = itemView.getContext();


        }
    }


}



