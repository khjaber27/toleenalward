package com.toleenalward.rasayel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.toleenalward.rasayel.Adapter.AdapterMessage;
import com.toleenalward.rasayel.object.message;

import java.util.ArrayList;

public class friends_messages_rasayel extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<message> resData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_messages_rasayel);

        recyclerView = findViewById(R.id.recyclerview_friends_messages);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        resData = new ArrayList<>();

        resData.add(new message("AA", "فلبي محظوظ بوجودك جانبي دائما يا صديقي ، فانا افديك بروحي ، ولو كان طيفك في كوكب اخر لذهبت اليه دون تردد"));
        resData.add(new message("BB", "الصديق هو شخص عزيز وفّي وبئر لكل اسرارك ،  تبني معه اقوى جسر لا تهدمه الرياح مهما كانت قوتها ، ستجد في النهاية شخص يعينك يبكي لبكائك ويمسح دموعك"));
        resData.add(new message("CC", "صديقي انت مثل الذهب مهما ارتفعت قيمته و مهما انخفضت يظل الذهب سلعة ثمينة ، وانت كذلك تشبه المطر لان المطر اذا غاب طويلا فان البشر يتأذون ، فهذا حالي معك يا صديقي"));
        resData.add(new message("DD", "صديقي انت شمعة حياتي"));
        resData.add(new message("EE", "وجودك بجانبي ياصديقي لون حياتي فكن معي دوماً فانت الحياة انت الحياة انت الحياة الملونة"));
        resData.add(new message("FF", "ساكتب صدقتنا علي جدار الزمن فان عشنا عشنا معاً وان متنا تقاسمنا الكفن"));
        resData.add(new message("GG", "وكم من صديق لم يكن ذا قرابة ولكنه في القلب دوماً من الاهل"));
        resData.add(new message("HH", "صديقي كل شيء جميل له معنى ولكن الاجمل هو انك الذي تعطي للا شياء معانيها"));
        resData.add(new message("LL", "صديقي اجمل الاوقات هي التي اقضيها بقربك يا اغلى الاصدقاء… لذلك كن بقربي دائماً ولا تتركني وحيد"));
        resData.add(new message("II", "ليس هناك اجمل من صديق بنكهة اخ"));
        resData.add(new message("JJ", "اجمل قلب انت صديقه…والاجمل ان يكون لك صديق انت قلبه"));
        resData.add(new message("KK", "صديقي انا لك حين يثقل العالم علي كتفيك "));
        resData.add(new message("FF", "تحلو الحياة بصدقة الاخيار وتطيب رغم تعاقب الاكدار يارب فاجمعنا بدار قرار"));
        resData.add(new message("NN", "اللهم ان لي اصدقاء عيني لا تراهم فبعينك اللهم ارعاهم وفرج همومهم وشكواهم واجعل السعادة لا تفارق خطاهم"));


        AdapterMessage adapter = new AdapterMessage(resData, this);
        recyclerView.setAdapter(adapter);

    }
}
