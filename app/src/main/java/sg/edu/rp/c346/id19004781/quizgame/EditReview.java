package sg.edu.rp.c346.id19004781.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EditReview extends AppCompatActivity {

    TextView tvBack;
    EditText etReview;
    Button btnUpdate, btnDelete;
    Review data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_review);

        etReview = findViewById(R.id.etEditReview);
        etReview = findViewById(R.id.etEditReview);
        btnUpdate = findViewById(R.id.btnUpdateReview);
        btnDelete = findViewById(R.id.btnDeleteReview);
        tvBack = findViewById(R.id.tvBack_EditPage);

        //Get the intent from MainActivity
        Intent ReviewPage2EditReviewPage = getIntent();
        data = (Review) ReviewPage2EditReviewPage.getSerializableExtra("data");

//        tvID.setText("ID: " + data.getId());
        etReview.setText(data.getReviewContent());


        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent EditPage2ReviewPage = new Intent(EditReview.this, ReviewActivity.class);
                startActivity(EditPage2ReviewPage);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DBHelper dbh = new DBHelper(EditReview.this);
//                data.setReviewContent(etReview.getText().toString());
//                dbh.updateReview(data);
//                dbh.close();

                if (etReview.getText().toString().equalsIgnoreCase(data.getReviewContent())){
                    Toast.makeText(EditReview.this, "Make some change before updating”.", Toast.LENGTH_SHORT).show();
                } else {
                    DBHelper dbh = new DBHelper(EditReview.this);
                    int id = data.getId();

                    Review review = new Review(id, etReview.getText().toString());

                    int result = dbh.updateReview(review);

//                    setResult(RESULT_OK, i);

                    if (result != -1){
                        Toast.makeText(EditReview.this, "Update successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(EditReview.this, "Not update successfully", Toast.LENGTH_SHORT).show();
                    }
//                    finish();
                    dbh.close();
                }
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditReview.this);
                dbh.deleteReview(data.getId());
                dbh.close();
            }
        });



    }
}