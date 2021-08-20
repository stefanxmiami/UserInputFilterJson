import java.util.ArrayList;

public class Account {
    Long id;
    String reviewId;
    private String reviewFullText;
    String reviewText;
    Long numLikes;
    Long numComments;
    Long numShares;
    private Long rating;
    String reviewCreatedOn;
    private String reviewCreatedOnDate;
    Long reviewCreatedOnTime;
    Long reviewerId;
    String reviewerUrl;
    String reviewerName;
    String reviewerEmail;
    String sourceType;
    boolean isVerified;
    String source;
    String sourceName;
    String sourceId;
    ArrayList<Object> tags;
    String href;
    String logoHref;
    ArrayList<Object> photos;

    public Account(Object rating, Object reviewFullText, Object reviewCreatedOnDate) {
        this.setRating((Long) rating);
        this.setReviewFullText((String) reviewFullText);
        this.setReviewCreatedOnDate((String) reviewCreatedOnDate.toString().substring(0,19));

    }

    public String getReviewFullText() {
        return reviewFullText;
    }

    public void setReviewFullText(String reviewFullText) {
        this.reviewFullText = reviewFullText;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getReviewCreatedOnDate() {
        return reviewCreatedOnDate;
    }

    public void setReviewCreatedOnDate(String reviewCreatedOnDate) {
        this.reviewCreatedOnDate = reviewCreatedOnDate;
    }
}
