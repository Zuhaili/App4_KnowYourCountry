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

public class AttractionArrayAdapter extends ArrayAdapter<Attraction> {

    private ArrayList<Attraction> attraction;
    private Context context;
    private ImageView ivAttractionImage, ivRatingStars;
    private TextView tvSite, tvAttractionName;
    AttractionArrayAdapter(@NonNull Context context, int resource, ArrayList<Attraction> objects) {
        super(context, resource, objects);
        attraction = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.attraction_row, parent, false);

        TextView tvAttractionName = rowView.findViewById(R.id.tvAttractionName);
        TextView tvSite = rowView.findViewById(R.id.tvAttractionSite);
        ImageView ivAttractionImage = rowView.findViewById(R.id.ivAttractionImage);
        ImageView ivRatingStars = rowView.findViewById(R.id.ivRatingStar);
//        ImageView ivFavourites2 = rowView.findViewById(R.id.ivFavourite2);

        ivAttractionImage.setImageResource(getItem(position).getAttractionImage());
        ivRatingStars.setImageResource(getItem(position).getStar());
        tvAttractionName.setText(getItem(position).getPlace());

        tvSite.setOnClickListener(v -> {
            Intent openLinksIntent = new Intent(Intent.ACTION_VIEW);
//            String openSite = tvSite.setText(getItem(position).getSite());
            openLinksIntent.setData(Uri.parse(getItem(position).getSite()));
            context.startActivity(openLinksIntent);
        });

        return rowView;
    }
}
