package com.toleenalward.rasayel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.toleenalward.rasayel.Adapter.AdapterMessage;
import com.toleenalward.rasayel.object.message;
import com.toleenalward.rasayel.object.rasayel;

import java.util.ArrayList;

public class love_messages_rasayel extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<message> resData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_messages_rasayel);

        recyclerView = findViewById(R.id.recyclerview_love_messages);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        resData = new ArrayList<>();

        resData.add(new message("A", "إنت أغلى ما في عالمي، وأروع ما في دنياي، وأجمل ما في حياتي"));
        resData.add(new message("B", "قلبي فرحان بحبك وعيني صابرة في بعدك وبقولك انك انتا وبس اللى نور عيني يارب يجعل حياتي فداك حبيبي"));
        resData.add(new message("C", "حبيبي قلبي ليك ولهان .. ومالك عليا حلفان لو تطلب مني عين .. لاعطيك قلبي كمان"));
        resData.add(new message("D", "عيني عشقتك شوفتك .. والدم في شراييني قلبي بيجري فيه حبك .. وكل نبرة من صوتك اسمعها .. شفايفي تتحرك وتقولك بحبك"));
        resData.add(new message("E", "شراييني انتا مزروع فيها .. وعيني انتا نظرها . واحساسي كله وهبتهولك .. وبقولك انتا وبس اللى ناسي واهلي"));
        resData.add(new message("F", "حبيبي : لو كتبتلك كلمة “احبك” ما يكفيني كل اغصان الاشجار ولا احبار مداد الأبحار .. بحبك وهفضل احبك"));
        resData.add(new message("G", "يمكن تكون بعيد ومشغول .. ويمكن قصرت في حبي وماسألت عليا .. بس اللي متاكد منه .. اني اشتقلك وحنيت إليك.."));
        resData.add(new message("H", "بكل نبضة فيا عشقتك .. ومعرفش ازاي ولا ليه عشقتك كل دا .. بس كل اللى اعرفه ان العشق جنون وانا اتجننت في عشقك حبيبي"));
        resData.add(new message("L", "عشقت دفايا جوا أحضانك .. وعينيي ادمنت نظاراتها ليك .. ونبرات همساتك عشقتها من شفتيك .. وعشقت حنانك وعطفك"));
        resData.add(new message("I", "لو الرسايل بقدر الحب تتبعت للغالين لابعتلك موبينيل وفودافون واتصالات ” بالموظفين “"));
        resData.add(new message("J", "العين بتعشق شوفتك .. والقلب مليان بدمك .. ولما بسمع صوتك الاقي شفايفي تقول بحبك"));
        resData.add(new message("K", "لو فوق الكون كون وزاد البشر ميت مليون مايسوي رمش عينك يااغلي مافي الكون "));
        resData.add(new message("F", "الاشتياق لشخص حنون هو الادمان الذي لايعاقب عليه القانون"));
        resData.add(new message("N", "ممكن اكون بعدت واتشغلت .. وممكن أكون قصرت وما سألت .. بس الأكيد حنيتلك واشتقت"));


        AdapterMessage adapter = new AdapterMessage(resData, this);
        recyclerView.setAdapter(adapter);


    }
}
