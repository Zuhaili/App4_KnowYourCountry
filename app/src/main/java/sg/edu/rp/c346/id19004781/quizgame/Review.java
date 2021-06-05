package sg.edu.rp.c346.id19004781.quizgame;

import java.io.Serializable;

public class Review implements Serializable {

    private int id;
    private String reviewContent;

    public Review(int id, String reviewContent){
        this.id = id;
        this.reviewContent = reviewContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    @Override
    public String toString() {
        return reviewContent ;
    }
}
