package android.HishaTech.com.dayquote.db.table;

import android.HishaTech.com.dayquote.Conversions;
import android.HishaTech.com.dayquote.db.DbAdapter;
import android.HishaTech.com.dayquote.db.model.Quote;
import android.content.Context;

/**
 * Created by smithkev on 1/27/2015.
 */
public class table_Quote {

    public static boolean checkQuoteExistsById(Context context, Integer Id) {
        boolean recordExists = false;
        DbAdapter db = new DbAdapter(context);
        db.open();
        recordExists = db.checkQuoteExistsById(Id);
        db.close();
        return recordExists;
    }

    public static boolean insertQuote(Context context,
                                      Quote quote) {
        boolean insertFailed = false;
        DbAdapter db = new DbAdapter(context);
        db.open();
        insertFailed = Conversions.TrueFalseIntToBoolean((int) db
                .insertQuote
                        (quote));
        db.close();
        return insertFailed;
    }

}
