package android.HishaTech.com.dayquote.db.model;

/**
 * Created by smithkt on 1/27/15.
 */
public class QuoteCategory {

    private Integer id;
    private Integer quoteid;
    private Integer categoryid;

    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public Integer getQuoteID() {
        return quoteid;
    }

    public void setQuoteID(Integer QuoteID) {
        this.quoteid = QuoteID;
    }

    public Integer getCategoryID() {
        return categoryid;
    }

    public void setCategoryID(Integer CategoryID) {
        this.categoryid =
                CategoryID;
    }
}
