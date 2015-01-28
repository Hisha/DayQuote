package android.HishaTech.com.dayquote.db.table;

import android.HishaTech.com.dayquote.Conversions;
import android.HishaTech.com.dayquote.db.DbAdapter;
import android.HishaTech.com.dayquote.db.model.QuoteCategory;
import android.content.Context;

/**
 * Created by smithkt on 1/27/15.
 */
public class table_QuoteCategory {

    public static boolean checkQuoteCategoryExistsById(Context context,
                                                       Integer Id) {
        boolean recordExists = false;
        DbAdapter db = new DbAdapter(context);
        db.open();
        recordExists = db.checkQuoteCategoryExistsById(Id);
        db.close();
        return recordExists;
    }

    public static boolean insertQuoteCategory(Context context,
                                              QuoteCategory quotecategory) {
        boolean insertFailed = false;
        DbAdapter db = new DbAdapter(context);
        db.open();
        insertFailed = Conversions.TrueFalseIntToBoolean((int) db
                .insertQuoteCategory
                        (quotecategory));
        db.close();
        return insertFailed;
    }

}
