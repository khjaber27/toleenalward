package com.toleenalward.rasayel.Fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.toleenalward.rasayel.Adapter.AdapterFavorite;
import com.toleenalward.rasayel.Adapter.AdapterMessage;
import com.toleenalward.rasayel.R;
import com.toleenalward.rasayel.model.messageRealm;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    RecyclerView recyclerView;
    Context context;
    Realm realm;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_favorite, container, false);
        Realm.init(getActivity());
        realm = Realm.getDefaultInstance();
        recyclerView = v.findViewById(R.id.recyclerview__favorite_rasayel);
        this.context = context;


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        RealmResults<messageRealm> kh = realm.where(messageRealm.class).findAll();
        AdapterFavorite adapter = new AdapterFavorite(kh, getContext(),realm);
        recyclerView.setAdapter(adapter);


        return v;
    }

}
