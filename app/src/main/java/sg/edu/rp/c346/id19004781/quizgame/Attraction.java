package sg.edu.rp.c346.id19004781.quizgame;

public class Attraction {
    private int id;
    private String place;
    private int star;
    private String site;
    private int attractionImage;
//    private int attractionFavourite;

    public Attraction(int id, String place, int star, String site, int attractionImage) {
        this.id = id;
        this.place =  place;
        this.star = star;
        this.site = site;
        this.attractionImage = attractionImage;
//        this.attractionFavourite = attractionFavourite;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getAttractionImage() {
        return attractionImage;
    }

    public void setAttractionImage(int attractionImage) {
        this.attractionImage = attractionImage;
    }

//    public int getAttractionFavourite() {
//        return attractionFavourite;
//    }
//
//    public void setAttractionFavourite(int attractionFavourite) {
//        this.attractionFavourite = attractionFavourite;
//    }
}
