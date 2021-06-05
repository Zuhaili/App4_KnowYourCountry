package sg.edu.rp.c346.id19004781.quizgame;

public class Staycations {
    private int hotelImage;
    private double hotelRating;
    private String hotelName;
    private String hotelSite;

    public Staycations(int hotelImage, double hotelRating, String hotelName, String hotelSite){
        this.hotelImage = hotelImage;
        this.hotelRating = hotelRating;
        this.hotelName = hotelName;
        this.hotelSite = hotelSite;
    }

    public int getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(int hotelImage) {
        this.hotelImage = hotelImage;
    }

    public double getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(double hotelRating) {
        this.hotelRating = hotelRating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelSite() {
        return hotelSite;
    }

    public void setHotelSite(String hotelSite) {
        this.hotelSite = hotelSite;
    }
}
