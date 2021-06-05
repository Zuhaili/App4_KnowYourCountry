package sg.edu.rp.c346.id19004781.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    ImageView ivHomeIcon, ivReviewIcon, ivSettingIcon;
    ListView lv;
    EditText etReview;
    Button btnInsert, btnRetrieve;
    ArrayAdapter<Review> aa;
    ArrayList<Review> al;
    ArrayList<User> alUser;
    DBHelperUser helper = new DBHelperUser(this);
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ivHomeIcon = findViewById(R.id.ivHomeIcon_ReviewPage);
        ivReviewIcon = findViewById(R.id.ivReviewIcon_ReviewPage);
        ivSettingIcon = findViewById(R.id.ivSettingIcon_ReviewPage);
        lv = findViewById(R.id.lvReview);
        etReview = findViewById(R.id.etReview);
        btnInsert = findViewById(R.id.btnInsert);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        tvName = findViewById(R.id.tvName);


        al = new ArrayList<Review>();

        ArrayList<User> data = helper.getAllNames();
//        alUser.clear();
//        alUser.addAll(helper.getAllNames());
        helper.close();
        String txt = "";
        for (int i = 0; i < data.size(); i++) {
            Log.d("Database User Content", i +". "+data.get(i));
            txt = data.get(i).getName();
        }
        tvName.setText(txt);

//        if(helper.)
//        tvName.setText("Name");
        String userName = tvName.getText().toString();

        if (helper.checkNameExists(userName) == true) {
            btnInsert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String reviewData = etReview.getText().toString();
                    DBHelper dbh = new DBHelper(ReviewActivity.this);
                    long inserted_id = dbh.insertReview(reviewData);
                    dbh.close();

                    if (inserted_id != -1) {
                        Toast.makeText(ReviewActivity.this, "Insert successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ReviewActivity.this, "Insert failed", Toast.LENGTH_SHORT).show();
                    }


//                    String
//                    tvName.setText(userName);
//                    finish();
//                    startActivity(getIntent());


                }
            });
        } else {
            btnInsert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent Go2LoginPage = new Intent(ReviewActivity.this, LoginActivity.class);
                    startActivity(Go2LoginPage);
                }
            });
        }


        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ReviewActivity.this);
                al.clear();
                al.addAll(dbh.getAllReview());
                dbh.close();

                aa.notifyDataSetChanged();

            }
        });


        ivHomeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ReviewPage2HomePage = new Intent(ReviewActivity.this, MainActivity.class);
                startActivity(ReviewPage2HomePage);
            }
        });

        ivSettingIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ReviewPage2SettingPage = new Intent(ReviewActivity.this, SettingActivity.class);
                startActivity(ReviewPage2SettingPage);
            }
        });



        aa = new ArrayAdapter<Review>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DBHelper dbh = new DBHelper(ReviewActivity.this);
                al.addAll(dbh.getAllReview());
                Review test = al.get(i);
                Intent ReviewPage2EditReviewPage = new Intent(ReviewActivity.this, EditReview.class);
                ReviewPage2EditReviewPage.putExtra("data", test);
                startActivity(ReviewPage2EditReviewPage);
            }
        });

        //Get the intent from MainActivity
        Intent ReviewPage = getIntent();

        //Get the intent from Attraction
        Intent AttractionPage2ReviewPage = getIntent();

        //Get the intent from Staycation
        Intent StaycationPage2ReviewPage = getIntent();

        //Get the intent from Register
        Intent RegisterPage2ReviewPage = getIntent();

        //Get the intent from Edit Review
        Intent EditPage2ReviewPage = getIntent();

        //get the intent from Setting
        Intent SettingPage2ReviewPage = getIntent();
   }
}