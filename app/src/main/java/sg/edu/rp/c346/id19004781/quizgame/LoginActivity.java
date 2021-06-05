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

public class LoginActivity extends AppCompatActivity {

    TextView tvCreateAccount;
    DBHelperUser helper = new DBHelperUser(this);
    EditText etLoginUsername, etLoginPass;
    Button btnLogin;
    ImageView ivHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvCreateAccount = findViewById(R.id.tvCreateAccount);
        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPass = findViewById(R.id.etLoginPass);
        ivHome = findViewById(R.id.ivHome_LoginPage);

        btnLogin = findViewById(R.id.btnLogin);

        ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginPage2HomePage = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(LoginPage2HomePage);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (helper.retrieveUserInfo(etLoginUsername.getText().toString(), etLoginPass.getText().toString())) {
                    Intent intentRegister = new Intent(getApplicationContext(), MainActivity.class);
                    intentRegister.putExtra("name", etLoginUsername.getText().toString());
                    startActivity(intentRegister);
                } else
                    Toast.makeText(LoginActivity.this, "Either username or password is wrong.", Toast.LENGTH_SHORT).show();
            }
        });

        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
            }
        });

        //Get Intent from Setting Page
        Intent Direct2LoginPage = getIntent();

        //Get Intent from register page
        Intent RegisterPage2LoginPage = getIntent();
    }
}
