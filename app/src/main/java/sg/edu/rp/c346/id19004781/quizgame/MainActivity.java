package sg.edu.rp.c346.id19004781.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvAttraction, tvFoodDining, tvStaycations;
    ImageView ivCountry, ivSetting;
//    ArrayAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAttraction = findViewById(R.id.tvAttraction);
        tvFoodDining = findViewById(R.id.tvFood);
        tvStaycations = findViewById(R.id.tvStaycation);
        ivCountry = findViewById(R.id.ivFavourites_HomePage);
        ivSetting = findViewById(R.id.ivSetting_HomePage);


        tvAttraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainAttraction = new Intent(MainActivity.this, AttractionActivity.class);
                startActivity(MainAttraction);
            }
        });

        tvFoodDining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainDining = new Intent(MainActivity.this, FoodDiningActivity.class);
                startActivity(MainDining);
            }
        });

        tvStaycations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainStaycations = new Intent(MainActivity.this, StaycationsActivity.class);
                startActivity(MainStaycations);
            }
        });

        ivCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ReviewPage = new Intent(MainActivity.this, ReviewActivity.class);
                startActivity(ReviewPage);
            }
        });

        ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomePage2SettingPage = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(HomePage2SettingPage);
            }
        });


        Intent HomeAttraction = getIntent();
//        Attraction geta = (Attraction)HomeAttraction.getSerializableExtra("getCountry");
        Intent HomeDining = getIntent();
        Intent HomeSC = getIntent();
//        Intent HomeReview = getIntent();

        //Get intent from Review Activity
        Intent ReviewPage2HomePage = getIntent();

        //Get intent from Register Activity
        Intent RegisterPage2HomePage = getIntent();

        //Get intent from Setting Activity
        Intent SettingPage2HomePage = getIntent();

        Intent LoginPage2HomePage = getIntent();
    }
}