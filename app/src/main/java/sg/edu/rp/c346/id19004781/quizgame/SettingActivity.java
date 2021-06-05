package sg.edu.rp.c346.id19004781.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {

    TextView tvName;
    Button btnLogin, btnLogout, btnDelete;
    ImageView ivHome, ivReview, ivSetting;
    DBHelperUser helper = new DBHelperUser(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        tvName = findViewById(R.id.tvWelcomeName);
        btnLogin = findViewById(R.id.btnLogin_SettingPage);
        btnLogout = findViewById(R.id.btnLogout_SettingPage);
        btnDelete = findViewById(R.id.btnDelete_SettingPage);
        ivHome = findViewById(R.id.ivHome_SettingPage);
        ivReview = findViewById(R.id.ivReview_SettingPage);

        ArrayList<User> data = helper.getAllNames();
        helper.close();
        String getName = "";
        for (int i = 0; i < data.size(); i++) {
            Log.d("Database Content", i +". "+data.get(i));
            getName = data.get(i).getName();
        }
         String name = getName;

        if(name == ""){
            tvName.setText("Welcome Guest!");
        } else {
            tvName.setText("Welcome " + name + "!");
        }

        if (helper.checkNameExists(name) == true) {
            btnLogin.setVisibility(View.GONE);

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent Direct2LoginPage = new Intent(SettingActivity.this, LoginActivity.class);
                    startActivity(Direct2LoginPage);
                    tvName.setText("");
                }
            });

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent Direct2RegisterPage = new Intent(SettingActivity.this, RegisterActivity.class);
                    startActivity(Direct2RegisterPage);
                }
            });
        } else {
            btnDelete.setVisibility(View.GONE);
            btnLogout.setVisibility(View.GONE);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent Go2LoginPage = new Intent(SettingActivity.this, LoginActivity.class);
                    startActivity(Go2LoginPage);
                }
            });
        }

        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SettingPage2HomePage = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(SettingPage2HomePage);
            }
        });

        ivReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SettingPage2ReviewPage = new Intent(SettingActivity.this, ReviewActivity.class);
                startActivity(SettingPage2ReviewPage);
            }
        });

        //Get intent from MainActivity
        Intent HomePage2SettingPage = getIntent();

        //Get intent from Attraction Page
        Intent AttractionPage2SettingPage = getIntent();

        //Get intent from Dining Page
        Intent DiningPage2SettingPage = getIntent();

        //Get intent from Staycation Page
        Intent StaycationPage2SettingPage = getIntent();

        //Get intent from Review Page
        Intent ReviewPage2SettingPage = getIntent();

        //Get intent from Register Page
        Intent RegisterPage2SettingPage = getIntent();
    }
}