package sg.edu.rp.c346.id19004781.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AttractionActivity extends AppCompatActivity {

    VideoView Quiz1VideoView;
    ListView lv;
    ArrayList<Attraction> al;
    ArrayAdapter aa;
    ImageView ivHomeAttraction, ivFavourites, ivSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
        lv = findViewById(R.id.lvAttractions);
        ivFavourites = findViewById(R.id.ivFavourites_AttractionPage);
        ivHomeAttraction = findViewById(R.id.ivHomeAttraction);
        ivSetting = findViewById(R.id.ivSetting_AttractionPage);
        al = new ArrayList<>();
        al.add(new Attraction(1, "Universal Studio Singapore", R.drawable.star1, "https://www.rwsentosa.com/en/attractions/universal-studios-singapore/explore", R.drawable.uss));
        al.add(new Attraction(2,"Gardens by the Bay", R.drawable.star2, "https://www.gardensbythebay.com.sg/en.html", R.drawable.gardensbythebay));
        aa = new AttractionArrayAdapter(this, R.layout.attraction_row, al);
        lv.setAdapter(aa);


        ivHomeAttraction.setOnClickListener(v -> {
                Intent HomeAttraction = new Intent(AttractionActivity.this, MainActivity.class);
                startActivity(HomeAttraction);
        });

        ivFavourites.setOnClickListener(v -> {
            Intent AttractionPage2ReviewPage = new Intent(AttractionActivity.this, ReviewActivity.class);
            startActivity(AttractionPage2ReviewPage);

        });

        ivSetting.setOnClickListener(v -> {
            Intent AttractionPage2SettingPage = new Intent(AttractionActivity.this, SettingActivity.class);
            startActivity(AttractionPage2SettingPage);

        });

         //Get the intent
        Intent MainAttraction = getIntent();
    }
}
