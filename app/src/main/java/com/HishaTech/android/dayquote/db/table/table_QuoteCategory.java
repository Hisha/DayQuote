package com.HishaTech.android.dayquote.db.table;

import com.HishaTech.android.dayquote.Conversions;
import com.HishaTech.android.dayquote.db.DbAdapter;
import com.HishaTech.android.dayquote.db.model.QuoteCategory;
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
