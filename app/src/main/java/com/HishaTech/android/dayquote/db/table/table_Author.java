package com.HishaTech.android.dayquote.db.table;

import com.HishaTech.android.dayquote.Conversions;
import com.HishaTech.android.dayquote.db.DbAdapter;
import com.HishaTech.android.dayquote.db.model.Author;

import android.content.Context;

/**
 * Created by smithkev on 1/27/2015.
 */
public class table_Author {

    public static boolean checkAuthorExistsById(Context context, Integer Id) {
        boolean recordExists = false;
        DbAdapter db = new DbAdapter(context);
        db.open();
        recordExists = db.checkAuthorExistsById(Id);
        db.close();
        return recordExists;
    }

    public static boolean insertAuthor(Context context,
                                       Author author) {
        boolean insertFailed = false;
        DbAdapter db = new DbAdapter(context);
        db.open();
        insertFailed = Conversions.TrueFalseIntToBoolean((int) db
                .insertAuthor
                        (author));
        db.close();
        return insertFailed;
    }

    public static Author getAuthorById(Context context, Integer AuthorId) {

        Author author = new Author();

        DbAdapter db = new DbAdapter(context);

        db.open();
        author = db.getAuthorById(AuthorId);
        db.close();

        return author;

    }

}
