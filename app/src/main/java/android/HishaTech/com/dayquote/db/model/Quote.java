package android.HishaTech.com.dayquote.db.model;

/**
 * Created by smithkev on 1/27/2015.
 */
public class Quote {

    private Integer id;
    private Integer authorid;
    private String quote;

    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public Integer getAuthorId() {
        return authorid;
    }

    public void setAuthorId(Integer AuthorId) {
        this.authorid = AuthorId;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String Quote) {
        this.quote = Quote;
    }

}
