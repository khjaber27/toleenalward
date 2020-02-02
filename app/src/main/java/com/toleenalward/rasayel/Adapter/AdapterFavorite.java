package com.toleenalward.rasayel.Adapter;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.toleenalward.rasayel.R;
import com.toleenalward.rasayel.model.messageRealm;


import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class AdapterFavorite extends RecyclerView.Adapter<AdapterFavorite.RestViewHolder> {

    RealmResults<messageRealm> message;
    private LayoutInflater mlayoutInflater;
    Realm realm;
    Context context;

    public AdapterFavorite(RealmResults<messageRealm> message, Context context, Realm realm) {
        this.message = message;
        mlayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.realm = realm;
    }


    @NonNull
    @Override
    public RestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mlayoutInflater.inflate(R.layout.message_row, parent, false);

      //  TextView message_title = (TextView) v.findViewById(R.id.name_message_love);
        // ImageButton imageButton = (ImageButton) v.findViewById(R.id.image_favorite_icon);


        return new RestViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RestViewHolder holder, final int position) {

        holder.messagetext.setText(message.get(position).getMessagename());

        holder.favorite.setImageResource(R.drawable.ic_favorite_black_24dp);

        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                realm.beginTransaction();
                RealmResults<messageRealm> kh = realm.where(messageRealm.class).equalTo("ID", message.get(position).getID()).findAll();
                kh.deleteAllFromRealm();
//                System.out.println(">>>>"+Integer.parseInt(message.get(position).getID()));


       /*         if(position>0){
                    kh.deleteFromRealm(Integer.parseInt(message.get(position).getID())-1);
                }else {
                    kh.deleteFromRealm(0);
                }


        */
                realm.commitTransaction();
                notifyDataSetChanged();
                Toast.makeText(context, "تمت الإزالة من المفضلة", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public int getItemCount() {
        return message.size();
    }

    class RestViewHolder extends RecyclerView.ViewHolder {

        TextView messagetext;
        ImageButton share, favorite, copy;

        RestViewHolder(@NonNull View itemView) {
            super(itemView);

            messagetext = itemView.findViewById(R.id.name_message_love);
            copy = itemView.findViewById(R.id.image_copy_icon);
            share = itemView.findViewById(R.id.image_share_icon);
            favorite = itemView.findViewById(R.id.image_favorite_icon);

            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/*");
                    String shareBody = (String) messagetext.getText();
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "تطبيق رسائل");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    context.startActivity(Intent.createChooser(sharingIntent, "إرسال الرسالة إلى"));
                }
            });


            copy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClipboardManager myClickboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData myClip = ClipData.newPlainText("text", (String) messagetext.getText());
                    myClickboard.setPrimaryClip(myClip);

                    Toast.makeText(context, "تم نسخ الرسالة", Toast.LENGTH_SHORT).show();

                }
            });


            context = itemView.getContext();


        }

    }


}



