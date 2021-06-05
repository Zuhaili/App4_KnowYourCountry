package sg.edu.rp.c346.id19004781.quizgame;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FoodDiningActivity extends AppCompatActivity {
    VideoView Quiz1VideoView;
    ListView lvFoodDining;
    ArrayList<FoodDining> al;
    ArrayAdapter aa;
    ImageView ivHomeDining, ivSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_dining);
        lvFoodDining = findViewById(R.id.lvDining);
        ivHomeDining = findViewById(R.id.ivHome_DiningPage);
        ivSetting = findViewById(R.id.ivSetting_DiningPage);

        al = new ArrayList<>();
        al.add(new FoodDining("KFC", "5", "https://www.kfc.com.sg/", "Fast Food", R.drawable.kfc, "Woodlands"));
        al.add(new FoodDining("MacDonald", "4", "https://www.mcdonalds.com.sg/", "Fast Food", R.drawable.macdonald, "Woodlands"));

        aa = new FoodDiningAdapter(this, R.layout.dining_row, al);
        lvFoodDining.setAdapter(aa);

        ivHomeDining.setOnClickListener(v -> {
//            Intent rpIntent = new Intent(Intent.ACTION_VIEW);
//            String openSite = tvSite.setText(getItem(position).getSite());
//            rpIntent.setData(Uri.parse(getItem(position).getSite()));

            Intent HomeDining = new Intent(FoodDiningActivity.this, MainActivity.class);
            startActivity(HomeDining);

        });

        ivHomeDining.setOnClickListener(v -> {
            Intent DiningPage2SettingPage = new Intent(FoodDiningActivity.this, SettingActivity.class);
            startActivity(DiningPage2SettingPage);
        });

        //Get the intent from MainActivity
        Intent MainDining = getIntent();





    }
}
