package android.HishaTech.com.dayquote.db.table;

import android.HishaTech.com.dayquote.Conversions;
import android.HishaTech.com.dayquote.db.DbAdapter;
import android.HishaTech.com.dayquote.db.model.Author;
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

}
