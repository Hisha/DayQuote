package android.HishaTech.com.dayquote.db.table;

import android.HishaTech.com.dayquote.Conversions;
import android.HishaTech.com.dayquote.db.DbAdapter;
import android.HishaTech.com.dayquote.db.model.Category;
import android.content.Context;

/**
 * Created by smithkev on 1/27/2015.
 */
public class table_Category {

    public static boolean checkCategoryExistsById(Context context, Integer Id) {
        boolean recordExists = false;
        DbAdapter db = new DbAdapter(context);
        db.open();
        recordExists = db.checkCategoryExistsById(Id);
        db.close();
        return recordExists;
    }

    public static boolean insertCategory(Context context,
                                         Category category) {
        boolean insertFailed = false;
        DbAdapter db = new DbAdapter(context);
        db.open();
        insertFailed = Conversions.TrueFalseIntToBoolean((int) db
                .insertCategory
                        (category));
        db.close();
        return insertFailed;
    }

}
