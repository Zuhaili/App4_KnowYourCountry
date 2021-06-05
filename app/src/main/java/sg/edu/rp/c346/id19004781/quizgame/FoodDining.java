package sg.edu.rp.c346.id19004781.quizgame;

public class FoodDining {
    private String companyName;
    private String locations;
    private String diningSite;
    private String diningCategory;
    private int diningImage;
    private  String diningArea;

    public FoodDining(String companyName, String locations, String diningSite, String diningCategory, int diningImage, String diningArea) {
        this.companyName =  companyName;
        this.locations = locations;
        this.diningSite = diningSite;
        this.diningCategory = diningCategory;
        this.diningImage = diningImage;
        this.diningArea = diningArea;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getDiningSite() {
        return diningSite;
    }

    public void setDiningSite(String diningSite) {
        this.diningSite = diningSite;
    }

    public String getDiningCategory() {
        return diningCategory;
    }

    public void setDiningCategory(String diningCategory) {
        this.diningCategory = diningCategory;
    }

    public int getDiningImage() {
        return diningImage;
    }

    public void setDiningImage(int diningImage) {
        this.diningImage = diningImage;
    }

    public String getDiningArea() {
        return diningArea;
    }

    public void setDiningArea(String diningArea) {
        this.diningArea = diningArea;
    }
}
