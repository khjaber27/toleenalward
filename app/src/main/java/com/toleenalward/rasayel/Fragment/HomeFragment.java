package com.toleenalward.rasayel.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.toleenalward.rasayel.Adapter.AdapterRasayel;
import com.toleenalward.rasayel.R;
import com.toleenalward.rasayel.friends_messages_rasayel;
import com.toleenalward.rasayel.love_messages_rasayel;
import com.toleenalward.rasayel.object.rasayel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<rasayel> resData;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = v.findViewById(R.id.recyclerview__home_rasayel);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        resData = new ArrayList<>();

        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل الحب"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل للأصدقاء"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل مضحكة"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل الشوق"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل حب بالإنجليزي"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل غرامية"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل عيد ميلاد"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل الصباح"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل المساء"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل عيد زواج"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل خيانة الحبيب"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل تحشيش"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل اعتذار"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل شكر"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل شعر"));;
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل واتس اب"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل العام الجديد 2020"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل شهر رمضان"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل عيد الفطر"));
        resData.add(new rasayel(R.drawable.love_mas_icon, "رسائل عيد الأضحى"));


        AdapterRasayel adapter = new AdapterRasayel(resData, getContext());
        recyclerView.setAdapter(adapter);


        return v;


    }

}
