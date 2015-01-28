package android.HishaTech.com.dayquote.db;

import android.HishaTech.com.dayquote.db.model.Author;
import android.HishaTech.com.dayquote.db.model.Category;
import android.HishaTech.com.dayquote.db.model.Quote;
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
            db.execSQL(DbConstants.AUTHOR_TABLE_CREATE_STRING);
            db.execSQL(DbConstants.CATEGORY_TABLE_CREATE_STRING);
            db.execSQL(DbConstants.QUOTE_TABLE_CREATE_STRING);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            Log.w(DbConstants.TAG, "Upgrading " + DbConstants.DATABASE_NAME
                    + " from version "
                    + oldVersion + " to " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS '" + DbConstants
                    .TABLE_AUTHOR + "'");
            db.execSQL("DROP TABLE IF EXISTS '" + DbConstants
                    .TABLE_CATEGORY + "'");
            db.execSQL("DROP TABLE IF EXISTS '" + DbConstants
                    .TABLE_QUOTE + "'");

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

    //region ** Author Table related **
    public long insertAuthor(Author author) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(DbConstants.AUTHOR_ROWID, author.getID());
        initialValues.put(DbConstants.AUTHOR_FIRSTNAME, author.getFirstName());
        initialValues.put(DbConstants.AUTHOR_LASTNAME,
                author.getLastName());
        initialValues.put(DbConstants.AUTHOR_WIKILINK,
                author.getWikiLink());
        return mDb.insert(DbConstants.TABLE_AUTHOR, null, initialValues);
    }

    public Author getAuthorById(Integer Id) {
        Author author = new Author();
        Cursor mCursor = mDb.query(DbConstants.TABLE_AUTHOR,
                new String[]{DbConstants.AUTHOR_FIRSTNAME,
                        DbConstants.AUTHOR_LASTNAME,
                        DbConstants.AUTHOR_WIKILINK},
                DbConstants.AUTHOR_ROWID + " = ?",
                new String[]{Integer.toString(Id)}, null, null, null);
        if (mCursor.moveToFirst()) {
            do {
                author.setID(Id);
                author.setFirstName(mCursor.getString(mCursor.getColumnIndex
                        (DbConstants.AUTHOR_FIRSTNAME)));
                author.setLastName(mCursor.getString(mCursor.getColumnIndex
                        (DbConstants.AUTHOR_LASTNAME)));
                author.setWikiLink(mCursor.getString(mCursor
                        .getColumnIndex(DbConstants.AUTHOR_WIKILINK)));
            } while (mCursor.moveToNext());
        }
        if (mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
        return author;
    }

    public boolean checkAuthorExistsById(Integer Id) {
        String SQLQuery = "SELECT * FROM " + DbConstants.TABLE_AUTHOR + "" +
                " WHERE " + DbConstants.AUTHOR_ROWID + " =?";
        Cursor mCursor = mDb.rawQuery(SQLQuery, new String[]{Integer
                .toString(Id)});
        boolean exists = (mCursor.getCount() > 0);
        mCursor.close();
        return exists;
    }

    public boolean checkAuthorExistsByName(String FirstName, String LastName) {
        String SQLQuery = "SELECT * FROM " + DbConstants.TABLE_AUTHOR +
                " WHERE " + DbConstants.AUTHOR_FIRSTNAME + " =? AND " +
                DbConstants.AUTHOR_LASTNAME + " =?";
        Cursor mCursor = mDb.rawQuery(SQLQuery, new String[]{FirstName,
                LastName});
        boolean exists = (mCursor.getCount() > 0);
        mCursor.close();
        return exists;
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

    //region ** Quote Table related **
    public long insertQuote(Quote quote) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(DbConstants.QUOTE_ROWID, quote.getID());
        initialValues.put(DbConstants.QUOTE_CATEGORYID, quote.getCategoryId());
        initialValues.put(DbConstants.QUOTE_AUTHORID,
                quote.getAuthorId());
        initialValues.put(DbConstants.QUOTE_QUOTE,
                quote.getQuote());
        return mDb.insert(DbConstants.TABLE_CATEGORY, null, initialValues);
    }

    public Quote getQuoteById(Integer Id) {
        Quote quote = new Quote();
        Cursor mCursor = mDb.query(DbConstants.TABLE_QUOTE,
                new String[]{DbConstants.QUOTE_CATEGORYID,
                        DbConstants.QUOTE_AUTHORID, DbConstants.QUOTE_QUOTE},
                DbConstants.QUOTE_ROWID + " = ?",
                new String[]{Integer.toString(Id)}, null, null, null);
        if (mCursor.moveToFirst()) {
            do {
                quote.setID(Id);
                quote.setCategoryId(mCursor.getInt(mCursor.getColumnIndex
                        (DbConstants.QUOTE_CATEGORYID)));
                quote.setAuthorId(mCursor.getInt(mCursor
                        .getColumnIndex(DbConstants.QUOTE_AUTHORID)));
                quote.setQuote(mCursor.getString(mCursor
                        .getColumnIndex(DbConstants.QUOTE_QUOTE)));
            } while (mCursor.moveToNext());
        }
        if (mCursor != null && !mCursor.isClosed()) {
            mCursor.close();
        }
        return quote;
    }

    public boolean checkQuoteExistsById(Integer Id) {
        String SQLQuery = "SELECT * FROM " + DbConstants.TABLE_QUOTE + "" +
                " WHERE " + DbConstants.QUOTE_ROWID + " =?";
        Cursor mCursor = mDb.rawQuery(SQLQuery, new String[]{Integer
                .toString(Id)});
        boolean exists = (mCursor.getCount() > 0);
        mCursor.close();
        return exists;
    }

    public boolean checkQuoteExistsByQuote(String Quote) {
        String SQLQuery = "SELECT * FROM " + DbConstants.TABLE_QUOTE +
                " WHERE " + DbConstants.QUOTE_QUOTE + " =?";
        Cursor mCursor = mDb.rawQuery(SQLQuery, new String[]{Quote});
        boolean exists = (mCursor.getCount() > 0);
        mCursor.close();
        return exists;
    }

    public Integer getQuoteCount() {
        Integer quoteCount = 0;
        String SQLQuery = "SELECT * FROM " + DbConstants
                .TABLE_QUOTE;
        Cursor mCursor = mDb.rawQuery(SQLQuery, null);
        if (mCursor != null) {
            quoteCount = mCursor.getCount();
            mCursor.close();
        }
        return quoteCount;
    }
    //endregion
}
