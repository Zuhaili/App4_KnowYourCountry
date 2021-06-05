//package sg.edu.rp.c346.id19004781.quizgame;
//
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import java.util.ArrayList;
//
//public class CountryAdapter extends ArrayAdapter<Country> {
//
//    private ArrayList<Country> countries;
//    private Context context;
//    private ImageView ivAttractionImage, ivRatingStars;
//    private TextView tvSite, tvAttractionName;
//    CountryAdapter(@NonNull Context context, int resource, ArrayList<Country> objects) {
//        super(context, resource, objects);
//        countries = objects;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View rowView = inflater.inflate(R.layout.country_row, parent, false);
//
//        TextView tvCountryName = rowView.findViewById(R.id.tvCountryName);
//        ImageView ivCountryImage = rowView.findViewById(R.id.ivCardViewCountry);
//
//
//        ivCountryImage.setImageResource(getItem(position).getCountryImg());
//        tvCountryName.setText(getItem(position).getCountryName());
//
//
//        ivCountryImage.setOnClickListener(v -> {
//            String country = getItem(position).getCountryName();
//            Intent go2HomePage = new Intent(context,MainActivity.class);
//            go2HomePage.putExtra("section",country);
//            context.startActivity(go2HomePage);
//
////            Intent openLinksIntent = new Intent(Intent.ACTION_VIEW);
//////            String openSite = tvSite.setText(getItem(position).getSite());
////            openLinksIntent.setData(Uri.parse(getItem(position).getDiningSite()));
////            context.startActivity(openLinksIntent);
//        });
//
//        return rowView;
//    }
//}
