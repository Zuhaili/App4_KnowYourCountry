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

public class StaycationsAdapter extends ArrayAdapter<Staycations> {

    private ArrayList<Staycations> staycations;
    private Context context;

    public StaycationsAdapter(@NonNull Context context, int resource, ArrayList<Staycations> objects) {
        super(context, resource, objects);
        staycations = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.staycation_row, parent, false);

        TextView tvSCName = rowView.findViewById(R.id.tvHotelName);
        TextView tvSite = rowView.findViewById(R.id.tvHotelSite);
        TextView tvRating = rowView.findViewById(R.id.tvRating);
        ImageView ivStaycationsImage = rowView.findViewById(R.id.ivSC);
        ImageView ivStars = rowView.findViewById(R.id.star);

        ivStaycationsImage.setImageResource(getItem(position).getHotelImage());
//        tvSite.setText(getItem(position).getHotelSite());
        tvSCName.setText(getItem(position).getHotelName());

        tvSite.setOnClickListener(v -> {
            Intent openLinksIntent = new Intent(Intent.ACTION_VIEW);
//            String openSite = tvSite.setText(getItem(position).getSite());
            openLinksIntent.setData(Uri.parse(getItem(position).getHotelSite()));
            context.startActivity(openLinksIntent);
        });

        return rowView;
    }

}
