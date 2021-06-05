package sg.edu.rp.c346.id19004781.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class StaycationsActivity extends AppCompatActivity {

    ListView lvSC;
    ArrayList<Staycations> al;
    StaycationsAdapter aa;
    ImageView ivHomeSC, ivReview, ivSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staycations);

        lvSC = findViewById(R.id.lvStaycations);
        ivHomeSC = findViewById(R.id.ivHome_StaycationPage);
        ivReview = findViewById(R.id.ivReview_StaycationPage);
        ivSetting = findViewById(R.id.ivSetting_StaycationPage);

        al = new ArrayList<>();
        al.add(new Staycations(R.drawable.mbs, 5.0, "Marina Bay Sands Singapore", "https://www.marinabaysands.com/"));
        al.add(new Staycations(R.drawable.shangri_la, 4.5, "Shangri-La Hotel", "https://www.shangri-la.com/"));
        aa = new StaycationsAdapter(StaycationsActivity.this, R.layout.staycation_row, al);
        lvSC.setAdapter(aa);

        ivHomeSC.setOnClickListener(v -> {
            Intent HomeSC = new Intent(StaycationsActivity.this, MainActivity.class);
            startActivity(HomeSC);
        });

        ivReview.setOnClickListener(v -> {
            Intent StaycationPage2ReviewPage = new Intent(StaycationsActivity.this, ReviewActivity.class);
            startActivity(StaycationPage2ReviewPage);
        });

        ivSetting.setOnClickListener(v -> {
            Intent StaycationPage2SettingPage = new Intent(StaycationsActivity.this, SettingActivity.class);
            startActivity(StaycationPage2SettingPage);
        });

        //Get the intent
        Intent MainStaycations = getIntent();
    }
}