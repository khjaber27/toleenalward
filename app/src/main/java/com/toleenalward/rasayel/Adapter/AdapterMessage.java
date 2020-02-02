package com.toleenalward.rasayel.Adapter;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.toleenalward.rasayel.Fragment.FavoriteFragment;
import com.toleenalward.rasayel.FunnyMessagesRasayel;
import com.toleenalward.rasayel.R;
import com.toleenalward.rasayel.friends_messages_rasayel;
import com.toleenalward.rasayel.love_messages_rasayel;
import com.toleenalward.rasayel.model.messageRealm;
import com.toleenalward.rasayel.object.message;
import com.toleenalward.rasayel.object.rasayel;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static android.content.Context.CLIPBOARD_SERVICE;

public class AdapterMessage extends RecyclerView.Adapter<AdapterMessage.RestViewHolder> {

    ArrayList<message> message;
    LayoutInflater mlayoutInflater;
    Realm realm;
    Context context;
    RealmResults<messageRealm> message1;

    public AdapterMessage(ArrayList<message> message, Context context) {
        this.message = message;
        mlayoutInflater = LayoutInflater.from(context);
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        this.context = context;

    }


    @NonNull
    @Override
    public RestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mlayoutInflater.inflate(R.layout.message_row, parent, false);

        // TextView message_title = (TextView) v.findViewById(R.id.name_message_love);
        // TextView message_id = (TextView) v.findViewById(R.id.id_message);


        return new RestViewHolder(v);
    }

    int cuurentID;

    @Override
    public void onBindViewHolder(@NonNull final RestViewHolder holder, final int position) {

        holder.messageId.setText(message.get(position).getMessageID());
        holder.messagetext.setText(message.get(position).getMessagetext());
        holder.favorite.setImageResource();


        //   System.out.println("Count is >>>>>>" + getItemCount());

        //    RealmResults<messageRealm> kh = realm.where(messageRealm.class).findAll();
        //  message1 = kh;
        //  System.out.println("FFFFFFFFFFFFFFFFFFFFFF" + message1.size());
   /*     for (int i = 0; i < message1.size(); i++) {
            if (message1.get(i).getID().equalsIgnoreCase(message.get(position).getMessageID())) {

                holder.favorite.setImageResource(R.drawable.ic_favorite_black_24dp);
            }

        }*/


    }


    @Override
    public int getItemCount() {
        return message.size();
    }

    class RestViewHolder extends RecyclerView.ViewHolder {
        TextView messagetext, messageId;
        ImageButton share, favorite, copy;

        RestViewHolder(@NonNull View itemView) {
            super(itemView);
            messageId = itemView.findViewById(R.id.id_message);
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

            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    realm.beginTransaction();

                    if(isFav == 1){
                        favorite.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                        messageRealm messageRealm = realm.createObject(messageRealm.class);
                        messageRealm.setID(message.get(getAdapterPosition()).getMessageID());
                        messageRealm.setMessagename(message.get(getAdapterPosition()).getMessagetext());
                        messageRealm.setImagefav(0);
                        realm.commitTransaction();
                    }else{
                        favorite.setImageResource(R.drawable.ic_favorite_black_24dp);
                        messageRealm messageRealm = realm.createObject(messageRealm.class);
                        messageRealm.setID(message.get(getAdapterPosition()).getMessageID());
                        messageRealm.setMessagename(message.get(getAdapterPosition()).getMessagetext());
                        messageRealm.setImagefav(1);
                        realm.commitTransaction();
                    }

                    Toast.makeText(context, "تمت الإضافة إلى المفضلة", Toast.LENGTH_SHORT).show();

          /*          for (int i = 0; i < message1.size(); i++) {
                        if (message1.get(i).getID().equalsIgnoreCase(message.get(getAdapterPosition()).getMessageID())) {

                            favorite.setEnabled(false);
                        }

                    }
*/
                }
            });


            context = itemView.getContext();


        }
    }

}










