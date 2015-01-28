package android.HishaTech.com.dayquote.db.model;

import android.HishaTech.com.dayquote.db.DbConstants;
import android.HishaTech.com.dayquote.db.table.table_Author;
import android.HishaTech.com.dayquote.db.table.table_Category;
import android.HishaTech.com.dayquote.db.table.table_Quote;
import android.HishaTech.com.dayquote.json.JsonConstants;
import android.HishaTech.com.dayquote.json.JsonParser;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by smithkev on 1/27/2015.
 */
public class FillTable {

    public static boolean Author(Context context) {
        try {
            JsonParser jParser = new JsonParser();
            JSONObject jObject = jParser.getJSONFromUrl(JsonConstants
                    .json_BaseURL + JsonConstants.json_AuthorURL);
            JSONArray jArray = jObject.getJSONArray(DbConstants.TABLE_AUTHOR);
            for (int i = 0; i < jArray.length(); i++) {
                try {
                    JSONObject oneObject = jArray.getJSONObject(i);
                    if (!table_Author.checkAuthorExistsById
                            (context, oneObject
                                    .getInt
                                            (DbConstants.AUTHOR_ROWID))) {
                        Author author = new Author();
                        author.setID(oneObject.getInt(DbConstants
                                .AUTHOR_ROWID));
                        author.setFirstName(oneObject.getString(DbConstants
                                .AUTHOR_FIRSTNAME));
                        author.setLastName(oneObject.getString(DbConstants
                                .AUTHOR_LASTNAME));
                        author.setWikiLink(oneObject.getString
                                (DbConstants.AUTHOR_WIKILINK));
                        table_Author.insertAuthor(context, author);
                    }
                } catch (JSONException e) {
                    // Oops
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean Categories(Context context) {
        try {
            JsonParser jParser = new JsonParser();
            JSONObject jObject = jParser.getJSONFromUrl(JsonConstants
                    .json_BaseURL + JsonConstants.json_CategoryURL);
            JSONArray jArray = jObject.getJSONArray(DbConstants.TABLE_CATEGORY);
            for (int i = 0; i < jArray.length(); i++) {
                try {
                    JSONObject oneObject = jArray.getJSONObject(i);
                    if (!table_Category.checkCategoryExistsById
                            (context, oneObject
                                    .getInt
                                            (DbConstants.CATEGORY_ROWID))) {
                        Category category = new Category();
                        category.setID(oneObject.getInt(DbConstants
                                .CATEGORY_ROWID));
                        category.setName(oneObject.getString(DbConstants
                                .CATEGORY_NAME));
                        category.setDescription(oneObject.getString
                                (DbConstants.CATEGORY_DESCRIPTION));
                        table_Category.insertCategory(context, category);
                    }
                } catch (JSONException e) {
                    // Oops
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean Quote(Context context) {
        try {
            JsonParser jParser = new JsonParser();
            JSONObject jObject = jParser.getJSONFromUrl(JsonConstants
                    .json_BaseURL + JsonConstants.json_QuoteURL);
            JSONArray jArray = jObject.getJSONArray(DbConstants.TABLE_QUOTE);
            for (int i = 0; i < jArray.length(); i++) {
                try {
                    JSONObject oneObject = jArray.getJSONObject(i);
                    if (!table_Quote.checkQuoteExistsById
                            (context, oneObject
                                    .getInt
                                            (DbConstants.QUOTE_ROWID))) {
                        Quote quote = new Quote();
                        quote.setID(oneObject.getInt(DbConstants
                                .QUOTE_ROWID));
                        quote.setCategoryId(oneObject.getInt(DbConstants
                                .QUOTE_CATEGORYID));
                        quote.setAuthorId(oneObject.getInt(DbConstants
                                .QUOTE_AUTHORID));
                        quote.setQuote(oneObject.getString
                                (DbConstants.QUOTE_QUOTE));
                        table_Quote.insertQuote(context, quote);
                    }
                } catch (JSONException e) {
                    // Oops
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
