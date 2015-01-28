package com.HishaTech.android.dayquote.db.table;

import com.HishaTech.android.dayquote.Conversions;
import com.HishaTech.android.dayquote.db.DbAdapter;
import com.HishaTech.android.dayquote.db.model.Quote;

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

    public static Integer getQuoteCount(Context context) {

        Integer quoteCount = 0;
        DbAdapter db = new DbAdapter(context);
        db.open();
        quoteCount = db.getQuoteCount();
        db.close();

        return quoteCount;

    }

    public static Quote getRandomQuote(Context context, Integer CategoryId) {

        Quote quote = new Quote();

        DbAdapter db = new DbAdapter(context);

        db.open();
        quote = db.getRandomQuote(CategoryId);
        db.close();

        return quote;
    }

}
