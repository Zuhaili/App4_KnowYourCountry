package sg.edu.rp.c346.id19004781.quizgame;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FoodDiningAdapter extends ArrayAdapter<FoodDining>{
    private ArrayList<FoodDining> dining;
    private Context context;
    private ImageView ivAttractionImage, ivRatingStars;
    private TextView tvSite, tvAttractionName;
    FoodDiningAdapter(@NonNull Context context, int resource, ArrayList<FoodDining> objects) {
        super(context, resource, objects);
        dining = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.dining_row, parent, false);

        TextView tvRestaurant = rowView.findViewById(R.id.tvRestaurant);
        TextView tvDiningSite = rowView.findViewById(R.id.tvDiningSite);
        TextView tvDiningCategory = rowView.findViewById(R.id.tvCategory);
        TextView tvLocations = rowView.findViewById(R.id.tvLocations);
        ImageView ivDiningImage = rowView.findViewById(R.id.ivDining);


        ivDiningImage.setImageResource(getItem(position).getDiningImage());
        tvRestaurant.setText(getItem(position).getCompanyName());
        tvDiningSite.setText("Visit Site");
        tvDiningCategory.setText("Category: " + getItem(position).getDiningCategory());
        tvLocations.setText(getItem(position).getLocations() + " locations");

        tvDiningSite.setOnClickListener(v -> {
            Intent openLinksIntent = new Intent(Intent.ACTION_VIEW);
//            String openSite = tvSite.setText(getItem(position).getSite());
            openLinksIntent.setData(Uri.parse(getItem(position).getDiningSite()));
            context.startActivity(openLinksIntent);
        });

        return rowView;
    }
}
