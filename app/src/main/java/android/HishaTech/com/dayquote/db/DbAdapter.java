package android.HishaTech.com.dayquote.db;

import android.HishaTech.com.dayquote.db.model.Category;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by smithkev on 1/27/2015.
 */
public class DbAdapter {

    //region ** DbAdapter Main Code **
    private final Context mCtx;
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    // Inner private class. Database Helper class for creating and updating
    // database
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DbConstants.DATABASE_NAME, null,
                    DbConstants.DATABASE_VERSION);
        }

        // onCreate method is called for the 1st time when database doesn't
        // exist
        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i(DbConstants.TAG, "Creating Database: " + DbConstants
                    .DATABASE_NAME);
            db.execSQL(DbConstants.CATEGORY_TABLE_CREATE_STRING);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            Log.w(DbConstants.TAG, "Upgrading " + DbConstants.DATABASE_NAME
                    + " from version "
                    + oldVersion + " to " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS '" + DbConstants
                    .TABLE_CATEGORY + "'");

            onCreate(db);
        }
    }

    /**
     * Constructor - takes the context to allow the database to be
     * opened/created
     *
     * @param ctx the Context within which to work
     */
    public DbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    /**
     * This method is used for creating/opening connection
     *
     * @return instance of DatabaseUtil
     * @throws SQLException
     */
    public DbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    /**
     * This method is used for closing the connection.
     */
    public void close() {
        mDbHelper.close();
    }
    //endregion

    //region ** Category Table related **
    public long insertCategory(Category category) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(DbConstants.CATEGORY_ROWID, category.getID());
        initialValues.put(DbConstants.CATEGORY_NAME, category.getName());
        initialValues.put(DbConstants.CATEGORY_DESCRIPTION,
                category.getDescription());
        return mDb.insert(DbConstants.TABLE_CATEGORY, null, initialValues);
    }

    public Category getCategoryById(Integer Id) {
        Category category = new Category();
        Cursor mCursor = mDb.query(DbConstants.TABLE_CATEGORY,
                new String[]{DbConstants.CATEGORY_NAME,
                        DbConstants.CATEGORY_DESCRIPTION},
                DbConstants.CATEGORY_ROWID + " = ?",
                new String[]{Integer.toString(Id)}, null, null, null);
        if (mCursor.moveToFirst()) {
            do {
                category.setID(Id);
                category.setName(mCursor.getString(mCursor.getColumnIndex
                        (DbConstants.CATEGORY_NAME)));
                category.setDescription(mCursor.getString(mCursor
                        .getColumnIndex(DbConstants.CATEGORY_DESCRIPTION)));
            } while (mCursor.moveToNext());
        }
        if (mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
        return category;
    }

    public boolean checkCategoryExistsById(Integer Id) {
        String SQLQuery = "SELECT * FROM " + DbConstants.TABLE_CATEGORY + "" +
                " WHERE " + DbConstants.CATEGORY_ROWID + " =?";
        Cursor mCursor = mDb.rawQuery(SQLQuery, new String[]{Integer
                .toString(Id)});
        boolean exists = (mCursor.getCount() > 0);
        mCursor.close();
        return exists;
    }

    public boolean checkCategoryExistsByName(String Name) {
        String SQLQuery = "SELECT * FROM " + DbConstants.TABLE_CATEGORY +
                " WHERE " + DbConstants.CATEGORY_NAME + " =?";
        Cursor mCursor = mDb.rawQuery(SQLQuery, new String[]{Name});
        boolean exists = (mCursor.getCount() > 0);
        mCursor.close();
        return exists;
    }
    //endregion

}
