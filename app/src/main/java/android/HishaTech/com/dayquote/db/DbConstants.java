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
    public static final String AUTHOR_FIRSTNAME = "firstname";
    public static final String AUTHOR_LASTNAME = "lastname";
    public static final String AUTHOR_WIKILINK = "wikilink";

    // Author table creation string
    public static final String AUTHOR_TABLE_CREATE_STRING = "CREATE TABLE "
            + TABLE_AUTHOR
            + " ("
            + AUTHOR_ROWID
            + " integer primary key, "
            + AUTHOR_FIRSTNAME
            + " text not null, "
            + AUTHOR_LASTNAME
            + " text not null, "
            + AUTHOR_WIKILINK
            + " text not null);";

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
    public static final String QUOTE_CATEGORYID = "categoryid";
    public static final String QUOTE_AUTHORID = "authorid";
    public static final String QUOTE_QUOTE = "quote";

    // Quote table creation string
    public static final String QUOTE_TABLE_CREATE_STRING = "CREATE TABLE "
            + TABLE_QUOTE
            + " ("
            + QUOTE_ROWID
            + " integer primary key, "
            + QUOTE_CATEGORYID
            + " integer not null, "
            + QUOTE_AUTHORID
            + " integer not null, "
            + QUOTE_QUOTE
            + " text not null);";

}
