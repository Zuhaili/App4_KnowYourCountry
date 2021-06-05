package sg.edu.rp.c346.id19004781.quizgame;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FavouriteList_Attraction extends AppCompatActivity {

    ListView lv;
    ArrayList<Attraction> al;
    ArrayAdapter aa;
    ImageView ivHomeAttraction, ivFavourites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favouritelist_attraction);


    }
}
