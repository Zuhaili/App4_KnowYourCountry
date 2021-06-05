package sg.edu.rp.c346.id19004781.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView tvLogin;
    ImageView ivHome, ivReview, ivSetting;
    EditText etName, etPass, etCfmPass;
    Button btnRegister;
    DBHelperUser helper = new DBHelperUser(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);
        etCfmPass = findViewById(R.id.etCfmPass);
        btnRegister = findViewById(R.id.btnRegister);
        ivHome = findViewById(R.id.ivHome_RegisterPage);

        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterPage2HomePage = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(RegisterPage2HomePage);
            }
        });

//        ivReview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent RegisterPage2ReviewPage = new Intent(RegisterActivity.this, ReviewActivity.class);
//                startActivity(RegisterPage2ReviewPage);
//            }
//        });
//
//        ivSetting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent RegisterPage2SettingPage = new Intent(RegisterActivity.this, SettingActivity.class);
//                startActivity(RegisterPage2SettingPage);
//            }
//        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {
                    //Get Input From edit text
                    String userName = etName.getText().toString();
                    String userPassword = etPass.getText().toString();
                    String userConfirmPassword = etCfmPass.getText().toString();

                    if (userConfirmPassword.equals(userPassword) && !helper.checkNameExists(userName)) {

                        //Insert data in Database from EditText field
                        helper.addUser(userName, userPassword);
                        Toast.makeText(RegisterActivity.this, "User created successfully! You can now log in. ", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Toast.LENGTH_LONG);
                        Intent RegisterPage2LoginPage = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(RegisterPage2LoginPage);
                    } else if (!userConfirmPassword.equals(userPassword)) {
                        Toast.makeText(RegisterActivity.this, "Password is incorrect!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(RegisterActivity.this, "This user already exists! ", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });

        //Get intent from Setting Page
        Intent Direct2RegisterPage = getIntent();
    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean Checkvalid = false;

        //Get values from EditText fields
        String UserName = etName.getText().toString();
        String Password = etPass.getText().toString();
        String ConfirmPassword = etCfmPass.getText().toString();

        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            Checkvalid = false;
            etName.setError("Please enter username!");
        } else {
            if (UserName.length() > 5) {
                Checkvalid = true;
                etName.setError(null);
            } else {
                Checkvalid = false;
                etName.setError("Please enter valid username!");
            }
        }
        //Handling validation for confirm password field
        if (ConfirmPassword.isEmpty()) {
            Checkvalid = false;
            etCfmPass.setError("Please re-enter password again!");
        } else {
            if (ConfirmPassword.length() == Password.length()) {
                Checkvalid = true;
                etCfmPass.setError(null);
            } else {
                Checkvalid = false;
                etCfmPass.setError("No matching!");
            }
        }
        return Checkvalid;
    }
}
