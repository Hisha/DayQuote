package android.HishaTech.com.dayquote.db;

/**
 * Created by smithkev on 1/27/2015.
 */
public class DbConstants {

    // TAG for Log entries
    public static final String TAG = "DBAdapter";
    // Database name
    public static final String DATABASE_NAME = "dayquote.db";
    // Set the database version for upgrade purposes
    public static final int DATABASE_VERSION = 1;
    // table names used in database
    public static final String TABLE_AUTHOR = "author";
    public static final String TABLE_CATEGORY = "category";
    public static final String TABLE_QUOTE = "quote";

    // Author table columns
    public static final String AUTHOR_ROWID = "_id";

    // Category table columns
    public static final String CATEGORY_ROWID = "_id";
    public static final String CATEGORY_NAME = "name";
    public static final String CATEGORY_DESCRIPTION = "description";

    // Category table creation string
    public static final String CATEGORY_TABLE_CREATE_STRING = "CREATE TABLE "
            + TABLE_CATEGORY
            + " ("
            + CATEGORY_ROWID
            + " integer primary key, "
            + CATEGORY_NAME
            + " text not null, "
            + CATEGORY_DESCRIPTION
            + " text not null);";

    // Quote table columns
    public static final String QUOTE_ROWID = "_id";

}
